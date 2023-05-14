package com.oop.bomberman.model.enity;

import com.oop.bomberman.model.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile extends Entity {
    protected final List<Sprite> spritesList;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Tile(double x, double y) {
        super(x, y, false);
        spritesList = new ArrayList<>();
    }

    @Override
    public void update() {
        render();
    }

    @Override
    public void render() {
        gc.drawImage(spritesList.get(0).getTexture(), x, y);
    }
}
