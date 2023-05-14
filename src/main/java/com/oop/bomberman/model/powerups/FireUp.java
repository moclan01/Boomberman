package com.oop.bomberman.model.powerups;

import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.graphics.Sprite;

public class FireUp extends PowerUp {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public FireUp(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_flames);
        update();
    }

    @Override
    public void activatePower(Player player) {

        active = true;
        player.increaseRadius(true);
    }
}
