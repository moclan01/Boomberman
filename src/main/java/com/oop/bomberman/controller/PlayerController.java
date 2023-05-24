package com.oop.bomberman.controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class PlayerController {
    public static boolean move;
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean bomb;

    public void handle(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W, UP -> up = true;
                    case S, DOWN -> down = true;
                    case A, LEFT -> left = true;
                    case D, RIGHT -> right = true;
                    case X, SPACE -> bomb = true;
                }
                if (up || down || left || right) {
                    move = true;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W, UP -> up = false;
                    case S, DOWN -> down = false;
                    case A, LEFT -> left = false;
                    case D, RIGHT -> right = false;
                    case X, SPACE -> bomb = false;
                }
                if (!up && !down && !left && !right) {
                    move = false;
                }
            }
        });
    }
}