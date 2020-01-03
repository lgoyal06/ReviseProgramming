package com.lalit.designPattern.observer.java.api;

import java.util.Observable;
import java.util.Observer;

public class CurrentDisplayObserver implements Observer {

    public CurrentDisplayObserver(Observable observable) {
        //Register with Observable
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataObservable) {
            System.out.println("Current display----->" + ((WeatherDataObservable) o).getHumidity() + "---" + ((WeatherDataObservable) o).getTemperature() + "-----" + ((WeatherDataObservable) o).getPressure());
        }
    }
}
