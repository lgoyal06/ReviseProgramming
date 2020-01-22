package com.lalit.designPattern.state;

public class Delivered implements PackageState {

    private static final Delivered instance = new Delivered();

    private Delivered() {

    }

    public static Delivered getInstance() {
        return instance;
    }

    @Override
    public void updateState(DeliveryContext context) {
        System.out.println("Delivered");
    }
}
