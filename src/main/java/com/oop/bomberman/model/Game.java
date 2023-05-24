package com.oop.bomberman.model;

import com.oop.bomberman.model.enity.Entity;
import com.oop.bomberman.model.enemies.Enemy;
import com.oop.bomberman.model.materials.Wall;
import com.oop.bomberman.model.level.Level;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.List;


public class Game implements GameSubject{
    private List<GameObserver> gameObserverList = new ArrayList<>();
    private Level level;
    private boolean passedLevel;
    private boolean playerDead = false;
    private static int totalPoints;
    private boolean gimmickStarted;

    private Banner banner;
    private AnimationTimer animation;

    public static int getTotalPoints() {
        return totalPoints;
    }

    public static void addTotalPoints(int points) {
        totalPoints += points;
    }

    public static void resetTotalPoints() {
        totalPoints = 0;
    }

    public void start() {
        banner = new Banner();

        animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                banner.update();
                Entity.updateList();
                passedLevel = true;
                playerDead = true;
                for(Entity e : Entity.entityList) {
                    if (!(e instanceof Wall)) {
                        e.update();
                    }
                    if (e instanceof Enemy) {
                        passedLevel = false;
                    }
                    if (e instanceof Player) {
                        playerDead = false;
                    }
                }
                if (banner.timeUp() && !gimmickStarted) {
                    level.startGimmick();
                    gimmickStarted = true;
                    notifyObservers();
                } else if (!banner.timeUp()) {
                    gimmickStarted = false;
                }
                if (passedLevel && Player.activatedPortal()) {
                    level.nextLevel();
                    banner.startTimer();
                }
                if(playerDead) {
                    Player.decreaseLife();
                    if (Player.getLife() == 0) {
//                        level.newGame();
//                        banner.startTimer();
                        notifyObservers();
                    } else {
                        level.restartLevel();
                    }
                }
            }
        };

        level = new Level(animation);
        level.newGame();
    }


    public Banner getBanner() {
        return banner;
    }
     public Level getLevel(){
        return level;
     }

     public AnimationTimer getAnimation() {
        return animation;
     }

    @Override
    public void registerObserver(GameObserver gameObserver) {
        this.gameObserverList.add(gameObserver);
    }

    @Override
    public void unregisterObserver(GameObserver gameObserver) {
        this.gameObserverList.remove(gameObserver);
    }

    @Override
    public void notifyObservers() {
        for(GameObserver gameObserver : gameObserverList){
            gameObserver.updateGameObserver();
        }
    }
}
