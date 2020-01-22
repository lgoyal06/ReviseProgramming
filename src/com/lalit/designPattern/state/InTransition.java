package com.lalit.designPattern.state;

public class InTransition implements PackageState {
    private static final InTransition instance = new InTransition();

    private InTransition() {

    }

    public static InTransition getInstance() {
        return instance;
    }

    @Override
    public void updateState(DeliveryContext context) {
        System.out.println("InTransition");
        context.setNextState(OutForDelivery.getInstance());
    }
}
