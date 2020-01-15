package com.lalit.designPattern.decorator.factory;

import com.lalit.designPattern.decorator.Beverage;
import com.lalit.designPattern.decorator.condiment.Milk;
import com.lalit.designPattern.decorator.condiment.Mocha;
import com.lalit.designPattern.decorator.condiment.Soy;
import com.lalit.designPattern.decorator.condiment.Whip;

public class CondimentFactory {


    private CondimentFactory() {

    }

    public static Beverage getInstance(String condiment, Beverage coffeeType) {
        if (Beverage.CondimentTypes.Milk.name().equalsIgnoreCase(condiment)) {
            return new Milk(coffeeType);
        } else if (Beverage.CondimentTypes.Mocha.name().equalsIgnoreCase(condiment)) {
            return new Mocha(coffeeType);
        } else if (Beverage.CondimentTypes.Soy.name().equalsIgnoreCase(condiment)) {
            return new Soy(coffeeType);
        }
        return new Whip(coffeeType);
    }
}
