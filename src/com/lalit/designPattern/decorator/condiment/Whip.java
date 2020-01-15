package com.lalit.designPattern.decorator.condiment;

import com.lalit.designPattern.decorator.Beverage;
import com.lalit.designPattern.decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 80;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Whip added";
    }
}
