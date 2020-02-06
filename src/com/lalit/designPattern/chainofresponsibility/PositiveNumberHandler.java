package com.lalit.designPattern.chainofresponsibility;

public class PositiveNumberHandler implements Chain {

    private Chain nextInChain;

    @Override
    public void setNext(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void process(Number number) {
        if (number.getValue() > 0) {
            System.out.println("Request has been handled");
        } else {
            nextInChain.process(number);
        }

    }
}
