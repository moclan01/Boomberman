package com.oop.bomberman.model.enemies;

import com.oop.bomberman.model.enity.AnimatedEntity;
import com.oop.bomberman.model.enity.Entity;
import com.oop.bomberman.model.AI.AI;
import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.materials.Brick;
import com.oop.bomberman.model.materials.Tile;
import com.oop.bomberman.model.powerups.PowerUp;
import com.oop.bomberman.model.sprite.Sprite;

public abstract class Enemy extends AnimatedEntity {
    protected AI ai;
    private final int point;
    protected boolean wallpass;


    public Enemy(double x, double y, int point, boolean spawned) {
        super(x, y, spawned);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    @Override
    protected boolean collide(Entity e, double x, double y) {
        if (e instanceof Tile) {
            clear();
            this.x = Math.round(this.x / Sprite.getScaledSize()) * Sprite.getScaledSize();
            this.y = Math.round(this.y/ Sprite.getScaledSize()) * Sprite.getScaledSize();
        }

        boolean collide = super.collide(e, x, y);
        if (collide && e instanceof Player) {
            ((Player) e).remove();
        }
        if (this.wallpass && (e instanceof Brick || e instanceof PowerUp || e instanceof Enemy)) {
            return false;
        }

        return collide;
    }

    public void update() {
        int direction = ai.calculate();

        if (direction == -1 || !canMove) {
            isMoving = false;
        }

        if (!isMoving) {
            goUp = goDown = goLeft = goRight = false;
            isMoving = true;
            switch (direction) {
                case 0 -> goUp = true;
                case 1 -> goDown = true;
                case 2 -> goLeft = true;
                case 3 -> goRight = true;
                default -> isMoving = false;
            }
        }

        super.update();
    }
}
