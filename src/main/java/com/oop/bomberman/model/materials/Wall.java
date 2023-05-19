package com.oop.bomberman.model.materials;

import com.oop.bomberman.model.enity.Tile;
import com.oop.bomberman.model.sprite.Sprite;

public class Wall extends Tile {

    public Wall(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.wall);
        update();
    }

}
