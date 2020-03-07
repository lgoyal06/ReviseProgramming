package com.lalit.reactive.programming;

import java.util.function.BiFunction;
import java.util.function.Function;


// add , square is reference to a function
public class DemoFunction_composition_Basic {
    public static void main(String... s) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> square = a -> a * a;
        System.out.println(add.apply(3, 4));
        System.out.println(square.apply(3));
        System.out.println(add.andThen(square).apply(3, 4));
    }
}
