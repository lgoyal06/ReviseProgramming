package com.lalit.designPattern.decorator;

public abstract class CondimentDecorator implements Beverage {

    public abstract int cost();

    public abstract String getDescription();
}
