package com.lalit.designPattern.observer.java.api;

import java.util.Observable;
import java.util.Observer;

public class GeneralDisplayObserver implements Observer {

    public GeneralDisplayObserver(Observable observable) {
        //Register with Observable
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataObservable) {
            System.out.println("General Display ---->" + ((WeatherDataObservable) o).getHumidity() + "---" + ((WeatherDataObservable) o).getTemperature() + "-----" + ((WeatherDataObservable) o).getPressure());
        }
    }
}
