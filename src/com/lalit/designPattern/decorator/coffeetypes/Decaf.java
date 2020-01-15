package com.lalit.designPattern.decorator.coffeetypes;

import com.lalit.designPattern.decorator.Beverage;

public class Decaf implements Beverage {
    @Override
    public int cost() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "Decaf";
    }
}
