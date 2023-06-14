package com.oop.bomberman.model.enity;

import com.oop.bomberman.model.sprite.Sprite;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public abstract class AnimatedEntity extends Entity {
    protected final List<List<Sprite>> spritesList;
    protected boolean goUp;
    protected boolean goDown;
    protected boolean goLeft;
    protected boolean goRight;
    protected boolean isMoving;
    protected double speed;
    protected int direction = 3;
    protected boolean canMove;
    private boolean removed;
    private int frame = 0;// đếm số lần chuyển đổi sprite


    public AnimatedEntity(double x, double y, boolean spawned) {
        super(x, y, spawned);
        spritesList = new ArrayList<>();
    }

    public boolean isRemoved() {
        return removed;
    }

    public void remove() {
        removed = true;
    }

    public void update() {
        double dx = 0, dy = 0;
        // nếu player chết
        if (removed) {
            direction = 4;
            deadAnimate();
            return;
        }
        // nếu player di chuyển
        if (goUp) {
            dy -= speed;
            direction = 0;
        }
        if (goDown) {
            dy += speed;
            direction = 1;
        }
        if (goLeft) {
            dx -= speed;
            direction = 2;
        }
        if (goRight)  {
            dx += speed;
            direction = 3;
        }
        //Nếu player đang di chuyển, gọi phương thức animate() để thực hiện hiệu ứng chuyển động
        // và phương thức moveBy() để di chuyển đối tượng.
        if(isMoving) {
            animate();
            moveBy(dx, dy);
        } else {
            spriteIndex = 0;
        }
        //hiện thị nhân vật trên màn hình
        render();
    }

    //chuyển đổi hình ảnh sprite hiển thị
    protected void animate() {
        clear();
        ++frame;
        if (frame >= 10) {
            spriteIndex = ++spriteIndex % spritesList.get(direction).size();
            frame = 0;
        }
    }
    /*
    Khởi tạo một đối tượng PauseTransition với thời gian chờ 500ms.
    Thiết lập sự kiện kết thúc cho PauseTransition để thêm đối tượng hiện tại vào danh sách toRemove để xóa.
    Gọi phương thức animate() và render() để thực hiện hiệu ứng chết.
     */
    protected void deadAnimate() {
        PauseTransition pauseTransition = new PauseTransition(Duration.millis(500));
        pauseTransition.setOnFinished(event -> toRemove.add(this));
        pauseTransition.play();
        animate();
        render();
    }
    /*
     mô tả di chuyển
     */
    protected void moveBy(double dx, double dy) {
        //Nếu dx và dy đều bằng 0, không di chuyển đối tượng.
        if (dx == 0 && dy == 0) return;
        //Tính toán tọa độ mới của đối tượng sau khi di chuyển.
        double x = this.x + dx;
        double y = this.y + dy;
        //Nếu đối tượng va chạm với các đối tượng khác, ngừng di chuyển.
        //Nếu đối tượng không va chạm, di chuyển đối tượng đến tọa độ mới.
        if(!moveCheck(x, y)) {
            return;
        }

        this.x = x;
        this.y = y;
    }

    /*
    Kiểm tra xem đối tượng có va chạm với các đối tượng khác hay không.
    Nếu đối tượng va chạm, không di chuyển.
     */
    private boolean moveCheck(double x, double y) {
        for (Entity entity : entityList) {
            if (collide(entity, x, y)) {
                return false;
            }
        }
        return true;
    }
    /*
    Kiểm tra xem đối tượng có va chạm với đối tượng e tại tọa độ x và y hay không.
    Nếu đối tượng không va chạm, trả về false.
    Nếu đối tượng va chạm, thiết lập biến canMove và trả về true.
     */
    protected boolean collide(Entity e, double x, double y) {
        if (this == e) {
            return false;
        }

        int spriteSize = Sprite.getScaledSize();
        canMove = !(x < e.getX() + spriteSize &&
                x + spriteSize > e.getX() &&
                y < e.getY() + spriteSize &&
                y + spriteSize > e.getY());
        return !canMove;
    }
    /*
   Vẽ hình ảnh sprite của đối tượng tương ứng với hướng di chuyển và chỉ số sprite hiện tại.
    */
    @Override
    public void render() {
        gc.drawImage(spritesList.get(direction).get(spriteIndex).getTexture(), x, y);
    }
}
