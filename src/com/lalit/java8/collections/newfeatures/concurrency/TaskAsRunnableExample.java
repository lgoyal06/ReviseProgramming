package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.stream.IntStream;

public class TaskAsRunnableExample {

    public static void main(String... s) {
        new Thread(() -> {
            IntStream.range(0, 15000).forEach(e -> System.out.print("T"));
        }).start();
        IntStream.range(0, 15000).forEach(e -> System.out.print("M"));
    }
}