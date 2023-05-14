package com.oop.bomberman.model.powerups;

import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.graphics.Sprite;

public class BombUp extends PowerUp {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public BombUp(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_bombs);
        update();
    }

    @Override
    public void activatePower(Player player) {

        player.increaseMaxBombs();
    }
}
