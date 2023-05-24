package com.oop.bomberman.model.level;

import com.oop.bomberman.controller.BombermanController;
import com.oop.bomberman.model.Game;
import com.oop.bomberman.model.enity.Entity;
import com.oop.bomberman.model.Player;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private final AnimationTimer animation;
    private final FileLevel fileLevel;
    private int currentLevel;
    private final GraphicsContext gc;
    private static DoubleProperty x;

    public Level(AnimationTimer animation) {
        fileLevel = new FileLevel();
        gc = BombermanController.getGraphicContext();
        x = new SimpleDoubleProperty();
        this.animation = animation;
        currentLevel = 1;
    }

    public static DoubleProperty xProperty() {
        return x;
    }

    public void newGame() {
        transition();
        Game.resetTotalPoints();
        Player.resetLife();
        fileLevel.loadLevel(1);
    }

    public void nextLevel() {

        ++currentLevel;
        transition();
        fileLevel.loadLevel(currentLevel);
    }

    public void restartLevel() {
        transition();
        fileLevel.loadLevel(currentLevel);
    }

    public void startGimmick() {
        fileLevel.gimmick();
    }

    private void transition() {
        Entity.entityList.clear();

        animation.stop();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0));
        pauseTransition.setOnFinished(event -> {
            fileLevel.createEntities();
            animation.start();
        });
        pauseTransition.play();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public FileLevel getFileLevel() {
        return fileLevel;
    }
}