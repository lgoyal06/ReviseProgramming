package com.lalit.designPattern.decorator.condiment;

import com.lalit.designPattern.decorator.Beverage;
import com.lalit.designPattern.decorator.CondimentDecorator;

public class Milk extends CondimentDecorator {

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Milk added";
    }
}
