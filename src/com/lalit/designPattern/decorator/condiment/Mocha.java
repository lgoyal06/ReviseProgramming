package com.lalit.designPattern.decorator.condiment;

import com.lalit.designPattern.decorator.Beverage;
import com.lalit.designPattern.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 50;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Mocha added";
    }
}
