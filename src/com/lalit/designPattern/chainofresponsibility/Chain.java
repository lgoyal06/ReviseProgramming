package com.lalit.designPattern.chainofresponsibility;

public interface Chain {
    void setNext(Chain nextInChain);

    //Number is request to process
    void process(Number number);
}
