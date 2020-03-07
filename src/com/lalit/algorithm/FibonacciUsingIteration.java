package com.lalit.algorithm;

public class FibonacciUsingIteration {

    public static void main(String... s) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= 9; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
