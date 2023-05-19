package com.oop.bomberman.model.powerups;

import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.sprite.Sprite;

public class FireUp extends PowerUp {

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
