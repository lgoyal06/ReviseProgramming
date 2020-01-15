package com.lalit.designPattern.decorator.coffeetypes;

import com.lalit.designPattern.decorator.Beverage;

public class HouseBlend implements Beverage {
    @Override
    public int cost() {
        return 300;
    }

    @Override
    public String getDescription() {
        return "House Blend coffee";
    }
}
