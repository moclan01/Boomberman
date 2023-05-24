package com.oop.bomberman.model.level;

import com.oop.bomberman.Bomberman;
import com.oop.bomberman.model.enemies.*;
import com.oop.bomberman.model.Player;
import com.oop.bomberman.model.materials.*;
import com.oop.bomberman.model.powerups.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FileLevel {
    private Player player;
    private int level;
    private static int height;
    private static int width;
    private String[] lineTiles;

    public int getLevel() {
        return level;
    }

    EmemyFactory lowLevelEnemyFactory = new LowLevelEnemiesFactory();
    EmemyFactory medLevelEnemyFactory = new MediumLevelEnemiesFactory();


    public void loadLevel(int level) {
        try {
            InputStream input = Bomberman.class.getResourceAsStream("levels/Level" + level + ".txt");
            assert input != null;
            InputStreamReader fileReader = new InputStreamReader(input);
            BufferedReader in = new BufferedReader(fileReader);

            String data = in.readLine();
            StringTokenizer tokens = new StringTokenizer(data);

            level = Integer.parseInt(tokens.nextToken());
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());

            lineTiles = new String[height];

            for (int i = 0; i < height; i++) {
                lineTiles[i] = in.readLine().substring(0, width);
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createEntities() {
        Player player;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                addLevelEntity(lineTiles[i].charAt(j), j, i);
//                player = createLevelPlayer(lineTiles[i].charAt(j), j, i);
//                createLevelTiles(lineTiles[i].charAt(j), j, i);
//                createLevelBrick(lineTiles[i].charAt(j), j, i);
//                createLowLevelEnemies(lineTiles[i].charAt(j), j, i);
//                createMediumLevelEnemies(lineTiles[i].charAt(j), j, i,player);
//                createPowerUp(lineTiles[i].charAt(j), j, i);

            }
        }
    }

//    public Tile createLevelTiles(char c, int x, int y){
//        switch (c){
//            case '#' :{
//                return new Wall(x,y);
//            }
//            case 'x' :{
//                return new Portal(x,y);
//            }
//        }
//        return null;
//    }
//    public AnimatedTile createLevelBrick (char c, int x, int y){
//        switch (c){
//            case '*' : {
//                return new Brick(x,y);
//            }
//        }
//        return null;
//    }
//
//    public Player createLevelPlayer(char c, int x, int y){
//        switch (c){
//            case '*' : {
//                return new Player(x,y);
//            }
//        }
//        return null;
//    }
//    public LowLevelEnemiesFactory createLowLevelEnemies(char c, int x, int y){
//        switch (c){
//            case '1' :
//                new LowLevelEnemyBalloom(x, y);
//            case '3' :
//                new LowLevelEnemyDahl(x, y);
//            case '6' :
//                new LowLevelEnemyTiger(x, y);
//        }
//        return null;
//    }
//
//    public MediumLevelEnemiesFactory createMediumLevelEnemies(char c, int x, int y,Player player){
//        switch (c){
//            case '2' :
//                new MediumLevelEnemyOneal(x, y, player);
//            case '4' :
//                new MediumLevelEnemyMinvo(x, y, player);
//            case '5' :
//                new MediumLevelEnemyKondoria(x, y, player);
//        }
//        return null;
//    }
//
//    public PowerUp createPowerUp(char c, int x, int y){
//        switch(c){
//            case 'b' :
//                new BombUp(x, y);
//            case 'f' :
//                new FireUp(x, y);
//            case 's' :
//                new Skate(x, y);
//            case 'd':
//                new Flamepass(x, y);
//            case 'e' :
//                new Bombpass(x, y);
//            case 'w' :
//                new Wallpass(x, y);
//        }
//        return null;
//    }

//    private void addLevelEntity(char c, int x, int y) {
//        switch (c) {
//            case '#' -> new Wall(x, y);
//            case '*' -> new Brick(x, y);
//            case 'x' -> new Portal(x, y);
//            case 'p' -> player = new Player(x, y);
//            case '1' -> new LowLevelEnemyBalloom(x, y);
//            case '2' -> new MediumLevelEnemyOneal(x, y, player);
//            case '3' -> new LowLevelEnemyDahl(x, y);
//            case '4' -> new MediumLevelEnemyMinvo(x, y, player);
//            case '5' -> new MediumLevelEnemyKondoria(x, y, player);
//            case '6' -> new LowLevelEnemyTiger(x, y);
//            case 'b' -> new BombUp(x, y);
//            case 'f' -> new FireUp(x, y);
//            case 's' -> new Skate(x, y);
//            case 'd'-> new Flamepass(x, y);
//            case 'e' -> new Bombpass(x, y);
//            case 'w' -> new Wallpass(x, y);
//        }
//    }

    private void addLevelEntity(char c, int x, int y) {
        switch (c) {
            case '#' -> new Wall(x, y);
            case '*' -> new Brick(x, y);
            case 'x' -> new Portal(x, y);
            case 'p' -> player = new Player(x, y);
            case '1' -> lowLevelEnemyFactory.generateEnemies("Balloom", x, y, null);
            case '2' -> medLevelEnemyFactory.generateEnemies("Oneal", x, y, player);
            case '3' -> lowLevelEnemyFactory.generateEnemies("Dahl", x, y, null);
            case '4' -> medLevelEnemyFactory.generateEnemies("Minvo", x, y, player);
            case '5' -> medLevelEnemyFactory.generateEnemies("Kondoria", x, y, player);
            case '6' -> lowLevelEnemyFactory.generateEnemies("Tiger", x, y, null);
            case 'b' -> new BombUp(x, y);
            case 'f' -> new FireUp(x, y);
            case 's' -> new Skate(x, y);
            case 'd'-> new Flamepass(x, y);
            case 'e' -> new Bombpass(x, y);
            case 'w' -> new Wallpass(x, y);
        }
    }

    public void gimmick() {
        for (int i = 0; i < 5; ++i) {
            new MediumLevelEnemyPontan(1, 1, player);
        }
    }
}
