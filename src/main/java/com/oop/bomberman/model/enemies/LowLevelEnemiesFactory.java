package com.oop.bomberman.model.enemies;

import com.oop.bomberman.model.Player;

public class LowLevelEnemiesFactory implements EmemyFactory {
    @Override
    public Enemy generateEnemies(String enemyType, int x, int y, Player player) {
        if (enemyType.equalsIgnoreCase("balloom"))
            return new LowLevelEnemyBalloom(x, y);
        if (enemyType.equalsIgnoreCase("Ovape"))
            return new LowLevelEnemyOvape(x, y);
        if(enemyType.equalsIgnoreCase("Dahl"))
            return new LowLevelEnemyDahl(x,y);
        if(enemyType.equalsIgnoreCase("SpawnedTiger"))
            return new LowLevelEnemySpawnedTiger(x,y);
        if(enemyType.equalsIgnoreCase("Tiger"))
            return new LowLevelEnemyTiger(x,y);
        return null;
    }

//    public static void main(String[] args) {
//        EmemyFactory enemyFactory = new LowLevelEnemiesFactory();
//        System.out.println(enemyFactory.generateEnemies("Balloom", 10, 2, null).toString());
//
//
//
//    }
}


