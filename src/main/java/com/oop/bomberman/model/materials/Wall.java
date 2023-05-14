package com.oop.bomberman.model.materials;

import com.oop.bomberman.model.enity.Tile;
import com.oop.bomberman.model.graphics.Sprite;

public class Wall extends Tile {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Wall(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.wall);
        update();
    }

}
