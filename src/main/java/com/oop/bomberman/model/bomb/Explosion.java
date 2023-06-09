package com.oop.bomberman.model.bomb;

import com.oop.bomberman.model.sprite.Sprite;

public class Explosion {

    public Explosion(double x, double y, boolean increaseRadius) {
        int tileSize = Sprite.getScaledSize();
        //tọa độ cho các hiệu ứng vùng boom nổ
        new ExplodeDirection(x, y, 0);
        ExplodeDirection left = new ExplodeDirection(x - tileSize, y, 1);
        ExplodeDirection right = new ExplodeDirection(x + tileSize, y, 1);
        ExplodeDirection up = new ExplodeDirection(x, y - tileSize, 2);
        ExplodeDirection down = new ExplodeDirection(x, y + tileSize, 2);

        if (increaseRadius) {
            if (left.flagged2()) {
                new ExplodeDirection(x - 2 * tileSize, y, 3);
            }
            if (right.flagged2()) {
                new ExplodeDirection(x + 2 * tileSize, y, 4);
            }
            if (up.flagged2()) {
                new ExplodeDirection(x, y - 2 * tileSize, 5);
            }
            if (down.flagged2()) {
                new ExplodeDirection(x, y + 2 * tileSize, 6);
            }
        }

    }
}
