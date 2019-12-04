package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.stream.IntStream;

public class TaskSingleThreadedExample {


    void doTask() {
        IntStream.range(0, 1500).forEach(e -> System.out.print('T'));
    }

    public static void main(String... s) {
        new TaskSingleThreadedExample().doTask();
        IntStream.range(0, 1500).forEach(e -> System.out.print('M'));

    }


}
