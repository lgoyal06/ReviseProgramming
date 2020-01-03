package com.lalit.designPattern.observer;

public class MainClass {

    public static void main(String... s) throws InterruptedException {

        WeatherDataFetcher subject = new WeatherDataFetcher();
        CustomObserver customObserver = new CustomObserver(subject);
        CustomObserver customObserver1 = new CustomObserver(subject);
        for (int i = 0; i < 10; ++i)
            subject.fetchWeatherInfo();
        System.out.println("------------------");
        subject.removeObserver(customObserver);
        for (int i = 0; i < 10; ++i)
            subject.fetchWeatherInfo();
        System.out.println("------------------");
        subject.removeObserver(customObserver1);
        for (int i = 0; i < 10; ++i)
            subject.fetchWeatherInfo();
    }
}
