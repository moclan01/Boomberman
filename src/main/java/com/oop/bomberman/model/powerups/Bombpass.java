package com.oop.bomberman.model.powerups;

import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.sprite.Sprite;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class Bombpass extends PowerUp {

    public Bombpass(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_bombpass);
    }

    @Override
    public void activatePower(Player player) {

        player.setBombpass(true);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> player.setBombpass(false));
            }
        };
        timer.schedule(task, 15000);
    }
}
