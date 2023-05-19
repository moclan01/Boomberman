package com.oop.bomberman.model.powerups;

import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.sprite.Sprite;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class Wallpass extends PowerUp {

    public Wallpass(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_wallpass);
    }

    @Override
    public void activatePower(Player player) {

        player.setWallpass(true);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> player.setWallpass(false));
            }
        };
        timer.schedule(task, 15000);
    }
}
