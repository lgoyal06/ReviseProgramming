package com.lalit.designPattern.observer.java.api;

public class MainClass {

    public static void main(String... s) {
        WeatherDataObservable weatherDataObservable = new WeatherDataObservable();
        GeneralDisplayObserver generalDisplayObserver = new GeneralDisplayObserver(weatherDataObservable);
        ForcastDisplayObserver forcastDisplayObserver = new ForcastDisplayObserver(weatherDataObservable);
        CurrentDisplayObserver currentDisplayObserver = new CurrentDisplayObserver(weatherDataObservable);
        weatherDataObservable.fetchUpdatedData();
    }
}
