package com.oop.bomberman.controller;

import com.oop.bomberman.model.*;
import com.oop.bomberman.model.level.Level;
import com.oop.bomberman.model.sprite.Sprite;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class BombermanController implements BannerObserver {
    @FXML
    private Canvas canvas;
    @FXML
    private Canvas banner;
    @FXML
    private Pane pane;
    private static Pane staticPane;
    private static GraphicsContext gc;
    private static GraphicsContext gcBanner;

    public static Pane getPane() {
        return staticPane;
    }

    public static GraphicsContext getGraphicContext() {
        return gc;
    }

//    public static GraphicsContext getGcBanner() {
//        return gcBanner;
//    }

    private Banner bannerSubject;
    private Game game;
    private AnimationTimer animation;
    private Level level;


    public void registerSubject(BannerSubject bannerSubject) {
        bannerSubject.registerObserver(this);
    }

    @FXML

    private void initialize() {

        gc = canvas.getGraphicsContext2D();
        gcBanner = banner.getGraphicsContext2D();
        staticPane = pane;
        game = new Game();

        canvas.setWidth(31 * Sprite.getScaledSize());
        canvas.setHeight(13 * Sprite.getScaledSize());

        pane.setStyle("-fx-background-color: #50a000");
        pane.setMinSize(31 * Sprite.getScaledSize(), 13 * Sprite.getScaledSize());
        pane.setPrefSize(31 * Sprite.getScaledSize(), 13 * Sprite.getScaledSize());
        pane.setMaxSize(31 * Sprite.getScaledSize(), 13 * Sprite.getScaledSize());


        game.start();

        animation = game.getAnimation();
        bannerSubject = game.getBanner();
        level = game.getLevel();

        this.registerSubject(bannerSubject);
    }

    public void displayPoint(int point) {
        gcBanner.fillText("Score: " + point, 10, 15);
    }

    public void displayTimer(int timer) {
        gcBanner.fillText("Timer: " + timer, 100, 15);
    }

    public void displayLife(int life) {
        gcBanner.fillText("Remain Life: " + life, 200, 15);
    }

    public void displayBanner() {

        gcBanner.setFill(Color.WHITE);
        gcBanner.setTextBaseline(VPos.CENTER);
    }


    @Override
    public void updateBannerObserver(int point, int timer, int life) {
        gcBanner.clearRect(0, 0, 800, 34);
        displayBanner();
        displayPoint(point);
        displayTimer(timer);
        displayLife(life);
    }

}
