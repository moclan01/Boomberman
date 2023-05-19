package com.oop.bomberman.model.powerups;

import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.sprite.Sprite;

public class Skate extends PowerUp {

    public Skate(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_speed);
        update();
    }

    @Override
    public void activatePower(Player player) {

        player.increaseSpeed();
    }
}
