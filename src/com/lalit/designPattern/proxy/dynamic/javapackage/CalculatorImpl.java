package com.lalit.designPattern.proxy.dynamic.javapackage;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int left, int right) {
        return left + right;
    }
}