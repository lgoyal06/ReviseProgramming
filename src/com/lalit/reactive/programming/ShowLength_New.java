package com.lalit.reactive.programming;

import java.util.function.Function;

public class ShowLength_New {

    public void show(int length, Function<Integer, String> converter) {
        System.out.println(converter.apply(length));

    }
}
