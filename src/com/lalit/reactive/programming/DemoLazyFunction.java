package com.lalit.reactive.programming;

public class DemoLazyFunction {

    public static boolean evaluateMe(String data) {
        System.out.println("Evaluate me");
        return data.length() > 5;
    }
}
