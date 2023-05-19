package com.oop.bomberman.model.enity;

import com.oop.bomberman.controller.BombermanController;
import com.oop.bomberman.model.bomb.ExplodeDirection;
import com.oop.bomberman.model.sprite.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected double x;
    protected double y;
    public static final List<Entity> entityList = new ArrayList<>();
    public static final List<Entity> toRemove = new ArrayList<>();
    public static final List<Entity> toAdd = new ArrayList<>();
    protected int spriteIndex = 0 ;
    protected final GraphicsContext gc;


    public Entity(double x, double y, boolean spawned) {
        this.gc = BombermanController.getGraphicContext();
        if (!spawned) {
            entityList.add(this);
            this.x = x * Sprite.getScaledSize();
            this.y = y * Sprite.getScaledSize();
        } else {
            this.x = x;
            this.y = y;
            toAdd.add(this);
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Calculate x tile from coordinate
     * @return x tile
     */
    public int getXTile() {
        return (int) (x / Sprite.getScaledSize());
    }

    /**
     * Calculate y tile from coordinate
     * @return y tile
     */
    public int getYTile() {
        return (int) (y / Sprite.getScaledSize());
    }

    public abstract void render();

    public abstract void update();

    public static void updateList() {
        entityList.addAll(0, toAdd);

        entityList.removeAll(toRemove);
        for (Entity e : toRemove) {
            if(e instanceof ExplodeDirection && ((ExplodeDirection) e).flagged()) {
                continue;
            }
            e.clear();
        }

        toAdd.clear();
        toRemove.clear();
    }

    public void clear() {
        gc.clearRect(x, y, Sprite.getScaledSize(), Sprite.getScaledSize());
    }
}

