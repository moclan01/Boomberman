package com.oop.bomberman.model.materials;

import com.oop.bomberman.model.sprite.Sprite;

public class Portal extends Tile {
    private boolean canActivate;


    public Portal(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.portal);
        new Brick(x, y);
    }

    public void setCanActivate(boolean canActivate) {
        this.canActivate = canActivate;
    }

    public boolean canActivate() {
        return canActivate;
    }
}
