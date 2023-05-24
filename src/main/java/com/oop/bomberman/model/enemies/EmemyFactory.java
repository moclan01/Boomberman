package com.oop.bomberman.model.enemies;

import com.oop.bomberman.model.Player;

public interface EmemyFactory {
     Enemy generateEnemies(String enemyType, int x, int y, Player player);
}
