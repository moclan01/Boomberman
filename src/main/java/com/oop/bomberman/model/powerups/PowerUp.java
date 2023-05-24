package com.oop.bomberman.model.powerups;


import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.materials.Brick;
import com.oop.bomberman.model.materials.Tile;

public abstract class PowerUp extends Tile {
    protected boolean canActivate;
    protected boolean active;


    public PowerUp(double x, double y) {
        super(x, y);
        new Brick(x, y);
    }

    public abstract void activatePower(Player player);


    public void setCanActivate(boolean canActivate) {
        this.canActivate = canActivate;
    }

    public boolean canActivate() {
        return canActivate;
    }
}
