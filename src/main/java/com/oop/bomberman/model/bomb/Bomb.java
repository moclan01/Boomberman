package com.oop.bomberman.model.bomb;

import com.oop.bomberman.model.enity.AnimatedEntity;
import com.oop.bomberman.model.graphics.Sprite;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends AnimatedEntity {
    private static int bombCount;
    private boolean passedBomb;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Bomb(double x, double y, boolean increaseRadius) {
        super(x, y, true);
        direction = 0;
        ++bombCount;

        PauseTransition explode = new PauseTransition(Duration.seconds(2.5));
        explode.setOnFinished(event -> {
            clear();
            new Explosion(this.getX(), this.getY(), increaseRadius);
            toRemove.add(this);
            --bombCount;
        });
        explode.play();

        //Animation
        List<Sprite> animation = new ArrayList<>();
        animation.add(Sprite.bomb);
        animation.add(Sprite.bomb_1);
        animation.add(Sprite.bomb_2);

        spritesList.add(animation);

    }

    public static int getBombCount() {
        return bombCount;
    }

    public boolean passedBomb() {
        return passedBomb;
    }

    public void setPassedBomb(boolean passedBomb) {
        this.passedBomb = passedBomb;
    }

    @Override
    public void update() {
        animate();
        render();
    }
}