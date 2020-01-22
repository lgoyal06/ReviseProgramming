package com.lalit.designPattern.state;

public class OutForDelivery implements PackageState {

    private static final OutForDelivery instance = new OutForDelivery();

    private OutForDelivery() {

    }

    public static OutForDelivery getInstance() {
        return instance;
    }


    @Override
    public void updateState(DeliveryContext context) {
        System.out.println("OutForDelivery");
        context.setNextState(Delivered.getInstance());
    }
}
