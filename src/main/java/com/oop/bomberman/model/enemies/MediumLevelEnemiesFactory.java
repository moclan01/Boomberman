package com.oop.bomberman.model.enemies;

import com.oop.bomberman.model.Player;

public class MediumLevelEnemiesFactory implements EmemyFactory{
    @Override
    public Enemy generateEnemies(String enemyType, int x, int y, Player player) {
        if(enemyType.equalsIgnoreCase("Kindoria"))
            return new MediumLevelEnemyKondoria(x,y,player);
        if(enemyType.equalsIgnoreCase("Minvo"))
            return new MediumLevelEnemyMinvo(x,y,player);
        if(enemyType.equalsIgnoreCase("Oneal"))
            return new MediumLevelEnemyOneal(x,y,player);
        if(enemyType.equalsIgnoreCase("Pontan"))
            return new MediumLevelEnemyPontan(x,y,player);
        return null;
    }

    public static void main(String[] args) {
        EmemyFactory medium = new MediumLevelEnemiesFactory();
        System.out.println(medium.generateEnemies("Kindoria",10,1,null).toString());
    }
}
