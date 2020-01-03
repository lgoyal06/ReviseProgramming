package com.lalit.designPattern.observer.java.api;

import java.util.Observable;

public class WeatherDataObservable extends Observable {

    String temperature;
    int humidity;
    int pressure;

    public void fetchUpdatedData() {
        setTemperature("100");
        setHumidity(34);
        setPressure(34);
        setChanged();
        notifyObservers();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }


}
