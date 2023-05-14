package com.oop.bomberman.model.powerups;


import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.materials.Brick;
import com.oop.bomberman.model.enity.Tile;

public abstract class PowerUp extends Tile {
    protected boolean canActivate;
    protected boolean active;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
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
