package com.oop.bomberman.model.powerups;

import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.sprite.Sprite;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class Flamepass extends PowerUp {

    public Flamepass(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_flamepass);
    }

    @Override
    public void activatePower(Player player) {

        player.setFlamepass(true);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> player.setFlamepass(false));
            }
        };
        timer.schedule(task, 15000);
    }
}
