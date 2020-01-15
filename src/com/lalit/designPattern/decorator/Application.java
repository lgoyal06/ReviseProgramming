package com.lalit.designPattern.decorator;

import com.lalit.designPattern.decorator.factory.CoffeeFactory;
import com.lalit.designPattern.decorator.factory.CondimentFactory;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String... s) {
        List<String> condiments = new ArrayList<>();
        condiments.add("Mocha");
        condiments.add("Mocha");
        condiments.add("Whip");
        String typeOfCoffee = "Espresso";
        Beverage beverage = CoffeeFactory.getInstance(typeOfCoffee);
        for (String condiment : condiments) {
            beverage = CondimentFactory.getInstance(condiment, beverage);
        }
        System.out.println(beverage.cost());
        System.out.println(beverage.getDescription());
    }
}
