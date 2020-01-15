package com.lalit.designPattern.decorator.coffeetypes;

import com.lalit.designPattern.decorator.Beverage;

public class DarkRoast implements Beverage {
    @Override
    public int cost() {
        return 340;
    }

    @Override
    public String getDescription() {
        return "Dark Blend coffee";
    }
}
