package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.concurrent.Callable;

public class SumOfArrayElementsTask implements Callable {

    int[] array;

    public SumOfArrayElementsTask(int[] array) {
        this.array = array;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum = array[i] + sum;
        }
        return sum;
    }
}
