package com.lalit.designPattern.decorator.condiment;

import com.lalit.designPattern.decorator.Beverage;
import com.lalit.designPattern.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    Beverage beverage;


    @Override
    public int cost() {

        return beverage.cost() + 45;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Soy added";
    }
}
