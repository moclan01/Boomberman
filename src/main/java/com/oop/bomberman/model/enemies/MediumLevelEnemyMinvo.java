package com.oop.bomberman.model.enemies;

import com.oop.bomberman.model.AI.MediumAI;
import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.sprite.Sprite;

import java.util.ArrayList;
import java.util.List;

public class MediumLevelEnemyMinvo extends Enemy {

    public MediumLevelEnemyMinvo(double x, double y, Player player) {
        super(x, y, 800, false);
        speed = 2.5;
        ai = new MediumAI(player, this, 1);

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.minvo_left1);
        left.add(Sprite.minvo_left2);
        left.add(Sprite.minvo_left3);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.minvo_right1);
        right.add(Sprite.minvo_right2);
        right.add(Sprite.minvo_right3);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.minvo_dead);
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
