package com.lalit.designPattern.state;

public class Shipped implements PackageState {

    private static final Shipped instance = new Shipped();

    private Shipped() {

    }

    public static Shipped getInstance() {
        return instance;
    }

    @Override
    public void updateState(DeliveryContext context) {
        System.out.println("Shipped");
        context.setNextState(InTransition.getInstance());
    }
}
