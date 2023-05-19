package com.oop.bomberman.model.AI;

import com.oop.bomberman.model.enemies.Enemy;
import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.sprite.Sprite;

public class MediumAI extends AI {
    private final Player player;
    private final Enemy enemy;
    private double steps;

    public MediumAI(Player player, Enemy enemy, int maxSteps) {
        this.player = player;
        this.enemy = enemy;
        this.maxSteps = maxSteps * Sprite.getScaledSize();
    }

    @Override
    public int calculate() {
        if(steps++ > maxSteps) {
            steps = 0;
            return -1;
        }
        int rand = random.nextInt(2);
        int direction;
        if (rand == 1) {
            direction = calculateRow();
            if (direction == -1) {
                direction = calculateCol();
            }
        } else {
            direction = calculateCol();
            if (direction == -1) {
                direction = calculateRow();
            }
        }
        return direction;
    }

    private int calculateCol() {
        if(player.getXTile() < enemy.getXTile()) {
            return 2;
        }
        if(player.getXTile() > enemy.getXTile()) {
            return 3;
        }
        return -1;
    }

    private int calculateRow() {
        if(player.getYTile() < enemy.getYTile()) {
            return 0;
        }
        if(player.getYTile() > enemy.getYTile()) {
            return 1;
        }
        return -1;
    }
}
