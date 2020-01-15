package com.lalit.designPattern.decorator;

public interface Beverage {

    int cost();

    String getDescription();

    enum CoffeeTypes {

        HouseBlend, DarkRoast, Espresso, Decaf

    }

    enum CondimentTypes {

        Milk, Mocha, Soy, Whip

    }
}
