package com.oop.bomberman.model.AI;

import com.oop.bomberman.model.graphics.Sprite;

public class LowAI extends AI {
    private int steps;

    public LowAI(int maxSteps) {
        this.maxSteps = maxSteps * Sprite.getScaledSize();
    }

    @Override
    public int calculate() {
        if(steps++ >= maxSteps) {
            steps = 0;
            return -1;
        }
        return random.nextInt(4);
    }
}
