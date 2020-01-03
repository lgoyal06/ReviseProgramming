package com.lalit.designPattern.observer;


//Observer Implementation
public class CustomObserver implements Observer {

    public CustomObserver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(String temp, int humidity, int pressure) {
        System.out.println("Temp , humidity & Pressure updated: " + temp + "  " + humidity + "    " + pressure);
    }
}
