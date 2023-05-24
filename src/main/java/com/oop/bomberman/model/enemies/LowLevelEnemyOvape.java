package com.oop.bomberman.model.enemies;

import com.oop.bomberman.model.AI.LowAI;
import com.oop.bomberman.model.sprite.Sprite;

import java.util.ArrayList;
import java.util.List;

public class LowLevelEnemyOvape extends Enemy {

    public LowLevelEnemyOvape(double x, double y) {
        super(x, y, 2000, false);
        speed = 1;
        ai = new LowAI(6);
        wallpass = true;

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.ovape_left1);
        left.add(Sprite.ovape_left2);
        left.add(Sprite.ovape_left3);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.ovape_right1);
        right.add(Sprite.ovape_right2);
        right.add(Sprite.ovape_right3);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.ovape_dead);
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
