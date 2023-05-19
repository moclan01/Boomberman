package com.oop.bomberman.model.materials;

import com.oop.bomberman.model.sprite.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Brick extends AnimatedTile {

    public Brick(double x, double y) {
        super(x, y, false);

        List<Sprite> normal = new ArrayList<>();
        normal.add(Sprite.brick);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.brick_exploded);
        dead.add(Sprite.brick_exploded1);
        dead.add(Sprite.brick_exploded2);

        spritesList.add(normal);
        spritesList.add(dead);
    }

    @Override
    public void deadAnimate() {
        direction = 1;
        super.deadAnimate();
    }
}
