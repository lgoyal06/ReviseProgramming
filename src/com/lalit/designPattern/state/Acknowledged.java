package com.lalit.designPattern.state;

public class Acknowledged implements PackageState {

    private static final Acknowledged instance = new Acknowledged();

    private Acknowledged() {

    }

    public static Acknowledged getInstance() {
        return instance;
    }

    @Override
    public void updateState(DeliveryContext context) {
        System.out.println("Acknowledged");
        context.setNextState(Shipped.getInstance());
    }
}
