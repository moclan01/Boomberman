package com.oop.bomberman.model;

import com.oop.bomberman.controller.BombermanController;
import com.oop.bomberman.model.Game;
import com.oop.bomberman.model.Player;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Banner implements BannerSubject {
    private List<BannerObserver> observerList = new ArrayList<>();
    private final Timeline timeline;
    private final IntegerProperty timeSeconds;
    private int point;
    private int timer;
    private int life;

    public Banner() {

        timeSeconds = new SimpleIntegerProperty();
        timeline = new Timeline();
        startTimer();
        notifyObservers();
    }

    public boolean timeUp() {
        return timeSeconds.get() == 0;
    }

    public void startTimer() {
        int time = 1000;
        timeSeconds.set(time);

        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(time + 1), new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
    }

    public void update() {
        this.point = Game.getTotalPoints();
        this.timer = timeSeconds.get();
        this.life = Player.getLife();
        System.out.println(Player.getLife());

        notifyObservers();
    }

    @Override
    public void registerObserver(BannerObserver bannerObserver) {
        this.observerList.add(bannerObserver);
    }

    @Override
    public void unregisterObserver(BannerObserver bannerObserver) {
        this.observerList.remove(bannerObserver);
    }

    @Override
    public void notifyObservers() {
        for (BannerObserver bannerObserver : this.observerList) {
            bannerObserver.updateBannerObserver(this.point, this.timer, this.life);
        }
    }
}
