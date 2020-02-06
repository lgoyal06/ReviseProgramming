package com.lalit.designPattern.chainofresponsibility;

public class Client {

    public static void main(String... s) {
        Chain positiveNumberHandler = new PositiveNumberHandler();
        Chain zeroNumberHandler = new ZeroNumberHandler();
        Chain negativeNumberHandler = new NegativeNumberHandler();
        positiveNumberHandler.setNext(zeroNumberHandler);
        zeroNumberHandler.setNext(negativeNumberHandler);
        negativeNumberHandler.setNext(new DefaultNumberHandler());
        positiveNumberHandler.process(new Number(4));
        positiveNumberHandler.process(new Number(-4));
        positiveNumberHandler.process(new Number(0));
    }
}
