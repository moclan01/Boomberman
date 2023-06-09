package com.oop.bomberman.model;

import com.oop.bomberman.Bomberman;
import com.oop.bomberman.controller.BombermanController;
import com.oop.bomberman.controller.PlayerController;
import com.oop.bomberman.model.enity.AnimatedEntity;
import com.oop.bomberman.model.enity.Entity;
import com.oop.bomberman.model.enemies.Enemy;
import com.oop.bomberman.model.bomb.Bomb;
import com.oop.bomberman.model.bomb.ExplodeDirection;
import com.oop.bomberman.model.materials.Brick;
import com.oop.bomberman.model.materials.Portal;
import com.oop.bomberman.model.materials.Tile;
import com.oop.bomberman.model.powerups.PowerUp;
import com.oop.bomberman.model.sprite.Sprite;
import com.oop.bomberman.model.level.Level;
import javafx.animation.PauseTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Player extends AnimatedEntity {
    private Pane pane;
    private Rectangle clip;
    private final DoubleProperty xProperty;
    private int maxBombs;
    private static int life = 4;
    private static boolean activatePortal;
    private boolean increaseRadius;
    private boolean wallpass;
    private boolean flamepass;
    private boolean bombpass;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */

    public Player(double x, double y) {
        super(x, y, false);
        this.xProperty = new SimpleDoubleProperty();
        speed = 2;
        maxBombs = 1;

        //Initialize up animation sprites
        List<Sprite> up = new ArrayList<>();
        up.add(Sprite.player_up);
        up.add(Sprite.player_up_1);
        up.add(Sprite.player_up_2);

        //Initialize down animation sprites
        List<Sprite> down = new ArrayList<>();
        down.add(Sprite.player_down);
        down.add(Sprite.player_down_1);
        down.add(Sprite.player_down_2);

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.player_left);
        left.add(Sprite.player_left_1);
        left.add(Sprite.player_left_2);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.player_right);
        right.add(Sprite.player_right_1);
        right.add(Sprite.player_right_2);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.player_dead1);
        dead.add(Sprite.player_dead2);
        dead.add(Sprite.player_dead3);

        spritesList.add(up);
        spritesList.add(down);
        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(dead);

        addCamera();
    }

    public static void resetLife() {
        life = 4;
    }

    public static void decreaseLife() {
        --life;
    }

    public static int getLife() {
        return life;
    }

    public static boolean activatedPortal() {
        return activatePortal;
    }

    private double clampRange() {
        double value = x - Bomberman.getScene().getWidth() / 2;
        double max = pane.getWidth() - Bomberman.getScene().getWidth();
        if (value < 0) {
            return 0;
        }
        return Math.min(value, max);
    }

    private void addCamera() {
        pane = BombermanController.getPane();
        clip = new Rectangle();

        clip.widthProperty().bind(Bomberman.getScene().widthProperty());
        clip.heightProperty().bind(Bomberman.getScene().heightProperty());

        pane.setClip(clip);
        pane.translateXProperty().bind(clip.xProperty().multiply(-1));
    }

    public void increaseMaxBombs() {
        ++maxBombs;
    }

    public void increaseRadius(boolean increaseRadius) {
        this.increaseRadius = increaseRadius;
    }

    public void increaseSpeed() {
        ++speed;
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(20));
        pauseTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                --speed;
            }
        });
        pauseTransition.play();
    }

    public void setWallpass(boolean wallpass) {
        this.wallpass = wallpass;
    }

    public void setFlamepass(boolean flamepass) {
        this.flamepass = flamepass;
    }

    public void setBombpass(boolean bombpass) {
        this.bombpass = bombpass;
    }

    public boolean canPassFlame() {
        return flamepass;
    }

    private void placeBomb() {
        double bombX = Math.round(x / Sprite.getScaledSize()) * Sprite.getScaledSize();
        double bombY = Math.round(y / Sprite.getScaledSize()) * Sprite.getScaledSize();
        new Bomb(bombX, bombY, increaseRadius);
    }

    @Override
    protected void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
        xProperty.set(x);

        Level.xProperty().bind(Bindings.createDoubleBinding(this::clampRange, xProperty));
        clip.xProperty().bind(Bindings.createDoubleBinding(this::clampRange, xProperty, pane.widthProperty()));
    }

    @Override
    public boolean collide(Entity e, double x, double y) {
        if (wallpass && e instanceof Brick) {
            return false;
        }

        if (flamepass && e instanceof ExplodeDirection) {
            return false;
        }

        if (bombpass && e instanceof Bomb) {
            return false;
        }

        boolean collide = super.collide(e, x, y);

        if (e instanceof Tile) {
            clear();
            this.x = Math.round(this.x / Sprite.getScaledSize()) * Sprite.getScaledSize();
            this.y = Math.round(this.y/ Sprite.getScaledSize()) * Sprite.getScaledSize();
        }

        if (collide && e instanceof Enemy) {
            remove();
        }

        if (e instanceof Bomb && !((Bomb) e).passedBomb()) {
            if (this.getX() <= e.getX() - Sprite.getScaledSize()
                    || this.getX() >= e.getX() + Sprite.getScaledSize()
                    || this.getY() <= e.getY() - Sprite.getScaledSize()
                    || this.getY() >= e.getY() + Sprite.getScaledSize()) {
                ((Bomb) e).setPassedBomb(true);
                return true;
            }
            return false;
        }

        if (collide && e instanceof PowerUp && ((PowerUp) e).canActivate()) {
            ((PowerUp) e).activatePower(this);
            toRemove.add(e);
        }

        activatePortal = collide && e instanceof Portal && ((Portal) e).canActivate();
        return collide;
    }

    @Override
    public void update() {
        isMoving = PlayerController.move;
        goUp = PlayerController.up;
        goDown = PlayerController.down;
        goLeft = PlayerController.left;
        goRight = PlayerController.right;
        if (PlayerController.bomb && Bomb.getBombCount() < maxBombs) {
            placeBomb();
            PlayerController.bomb = false;
        }
        super.update();
    }


}
