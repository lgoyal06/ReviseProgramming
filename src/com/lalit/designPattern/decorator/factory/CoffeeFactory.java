package com.lalit.designPattern.decorator.factory;

import com.lalit.designPattern.decorator.Beverage;
import com.lalit.designPattern.decorator.coffeetypes.DarkRoast;
import com.lalit.designPattern.decorator.coffeetypes.Decaf;
import com.lalit.designPattern.decorator.coffeetypes.Espresso;
import com.lalit.designPattern.decorator.coffeetypes.HouseBlend;

public class CoffeeFactory {


    private CoffeeFactory() {

    }

    public static Beverage getInstance(String coffeeType) {
        if (Beverage.CoffeeTypes.Espresso.name().equalsIgnoreCase(coffeeType)) {
            return new Espresso();
        } else if (Beverage.CoffeeTypes.DarkRoast.name().equalsIgnoreCase(coffeeType)) {
            return new DarkRoast();
        } else if (Beverage.CoffeeTypes.Decaf.name().equalsIgnoreCase(coffeeType)) {
            return new Decaf();
        }
        return new HouseBlend();
    }
}
