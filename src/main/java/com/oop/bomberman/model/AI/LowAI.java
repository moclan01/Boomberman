package com.oop.bomberman.model.AI;

import com.oop.bomberman.model.sprite.Sprite;

public class LowAI extends AI {
    private int steps;

    public LowAI(int maxSteps) {
        this.maxSteps = maxSteps * Sprite.getScaledSize();
    }

    /*
    Phương thức này sử dụng biến steps để kiểm tra số bước di chuyển đã được thực hiện.
    Nếu giá trị steps lớn hơn hoặc bằng giá trị maxSteps, phương thức sẽ đặt steps về 0
    và trả về giá trị âm (-1) để báo hiệu rằng đối tượng LowAI đã hoàn thành việc di chuyển.
    Nếu không, phương thức trả về một giá trị ngẫu nhiên từ 1 đến 3, đại diện cho 2 trong 4 hướng di chuyển
     */
    @Override
    public int calculate() {
        if(steps++ >= maxSteps) {
            steps = 0;
            return -1;
        }
        return random.nextInt(4);
    }
}
