package com.oop.bomberman.model.enemies;

import com.oop.bomberman.model.AI.LowAI;
import com.oop.bomberman.model.sprite.Sprite;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class LowLevelEnemyTiger extends Enemy {
    private boolean spawned;

    public LowLevelEnemyTiger(double x, double y) {
        super(x, y, 200, false);
        ai = new LowAI(3);
        speed = 2;

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.tiger_left1);
        left.add(Sprite.tiger_left2);
        left.add(Sprite.tiger_left3);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.tiger_right1);
        right.add(Sprite.tiger_right2);
        right.add(Sprite.tiger_right3);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.tiger_dead);
        dead.add(Sprite.mob_dead1);
        dead.add(Sprite.mob_dead2);
        dead.add(Sprite.mob_dead3);

        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(dead);
    }

    @Override
    public void update() {
        if (isRemoved() && !spawned) {
            spawned = true;

            double spawnedX = Math.round(x / Sprite.getScaledSize()) * Sprite.getScaledSize();
            double spawnedY = Math.round(y / Sprite.getScaledSize()) * Sprite.getScaledSize();

            PauseTransition pauseTransition = new PauseTransition(Duration.millis(600));
            pauseTransition.setOnFinished(event -> {
                toAdd.add(new LowLevelEnemySpawnedTiger(spawnedX, spawnedY));
                toAdd.add(new LowLevelEnemySpawnedTiger(spawnedX + Sprite.getScaledSize(), spawnedY));
                toAdd.add(new LowLevelEnemySpawnedTiger(spawnedX - Sprite.getScaledSize(), spawnedY));
            });
            pauseTransition.play();
        }
        super.update();
    }
}
