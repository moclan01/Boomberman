package com.oop.bomberman.model.powerups;

import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.graphics.Sprite;

public class Skate extends PowerUp {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
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
