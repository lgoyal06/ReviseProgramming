package com.lalit.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataFetcher implements Subject {

    private List<Observer> observers = new ArrayList<>();
    String temperature;
    int humidity;
    int pressure;

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    @Override
    public String getTemperature() {
        return "98.4";
    }

    @Override
    public int getHumidity() {
        return 0;
    }

    @Override
    public int getPressure() {
        return 0;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    public void fetchWeatherInfo() throws InterruptedException {
        setHumidity(34);
        setPressure(44);
        setTemperature("98.4c");
        notifyObservers();
        Thread.sleep(1000);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(getTemperature(), getHumidity(), getPressure());
        }
    }
}
