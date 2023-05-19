package com.oop.bomberman.model.enemies;

import com.oop.bomberman.model.AI.LowAI;
import com.oop.bomberman.model.sprite.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Dahl extends Enemy {

    public Dahl(double x, double y) {
        super(x, y, 400, false);
        speed = 1.8;
        ai = new LowAI(6);

        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.dahl_left1);
        left.add(Sprite.dahl_left2);
        left.add(Sprite.dahl_left3);
        spritesList.add(left);

        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.dahl_right1);
        right.add(Sprite.dahl_right2);
        right.add(Sprite.dahl_right3);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.dall_dead);
        dead.add(Sprite.mob_dead1);
        dead.add(Sprite.mob_dead2);
        dead.add(Sprite.mob_dead3);

        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(dead);
    }
}
