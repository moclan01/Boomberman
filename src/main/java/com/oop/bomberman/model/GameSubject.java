package com.oop.bomberman.model;

public interface GameSubject {
    public void registerObserver(GameObserver gameObserver);
    public void unregisterObserver(GameObserver gameObserver);
    public void notifyObservers();
}
