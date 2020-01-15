package com.lalit.designPattern.decorator.coffeetypes;

import com.lalit.designPattern.decorator.Beverage;

public class Espresso implements Beverage {
    @Override
    public int cost() {
        return 450;
    }

    @Override
    public String getDescription() {
        return "Espresso coffee";
    }
}
