package com.oop.bomberman.model.enemies;

import com.oop.bomberman.model.AI.LowAI;
import com.oop.bomberman.model.sprite.Sprite;

import java.util.ArrayList;
import java.util.List;

public class LowLevelEnemyBalloom extends Enemy {

    public LowLevelEnemyBalloom(double x, double y) {
        super(x, y, 100, false);
        ai = new LowAI(5);
        speed = 1;

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.balloom_left1);
        left.add(Sprite.balloom_left2);
        left.add(Sprite.balloom_left3);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.balloom_right1);
        right.add(Sprite.balloom_right2);
        right.add(Sprite.balloom_right3);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.balloom_dead);
        dead.add(Sprite.mob_dead1);
        dead.add(Sprite.mob_dead2);
        dead.add(Sprite.mob_dead3);

        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(dead);
    }

//    @Override
//    public String toString() {
//        return "Tao la Balloom";
//    }
}
