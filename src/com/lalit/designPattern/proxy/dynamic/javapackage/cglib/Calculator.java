package com.lalit.designPattern.proxy.dynamic.javapackage.cglib;

public class Calculator {

    public Calculator() {
        System.out.println("constructor of Calculator class called");
    }

    public int add(int left, int right) {
        System.out.println("Original called ");
        return left + right;
    }
}
