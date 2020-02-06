package com.lalit.designPattern.chainofresponsibility;

public class DefaultNumberHandler implements Chain {

    @Override
    public void setNext(Chain nextInChain) {

    }

    @Override
    public void process(Number number) {
        System.out.println("I can handle any type of Number");
    }
}
