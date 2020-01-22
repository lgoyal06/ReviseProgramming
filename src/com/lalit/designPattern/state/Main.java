package com.lalit.designPattern.state;

public class Main {
    public static void main(String... s) {
        DeliveryContext context = new DeliveryContext(null, "Package_344_del_to_mum");
        context.updateState();
        context.updateState();
        context.updateState();
        context.updateState();
        context.updateState();

    }
}
