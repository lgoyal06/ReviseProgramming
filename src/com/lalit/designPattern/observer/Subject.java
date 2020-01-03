package com.lalit.designPattern.observer;

public interface Subject {

    String getTemperature();

    int getHumidity();

    int getPressure();

    void registerObserver(Observer observer);

    boolean removeObserver(Observer observer);

}
