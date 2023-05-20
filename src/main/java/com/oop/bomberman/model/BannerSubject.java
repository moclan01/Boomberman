package com.oop.bomberman.model;

public interface BannerSubject {
    public void registerObserver(BannerObserver bannerObserver);
    public void unregisterObserver(BannerObserver bannerObserver);
    public void notifyObservers();

}
