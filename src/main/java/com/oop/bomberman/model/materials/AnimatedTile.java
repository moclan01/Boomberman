package com.oop.bomberman.model.materials;

import com.oop.bomberman.model.enity.AnimatedEntity;

public abstract class AnimatedTile extends AnimatedEntity {
    /**
     * Initialize object.
     *
     * @param x       coordinate x
     * @param y       coordinate y
     * @param spawned spawned
     */
    public AnimatedTile(double x, double y, boolean spawned) {
        super(x, y, spawned);
        direction = 0;
    }
}
