package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample implements Callable {

    int a;
    int b;

    public CallableExample(int a, int b) {
        this.a = a;
        this.b = b;

    }

    public Integer call() {
        return MyMath.add(a, b);
    }

    public static void main(String... s) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CallableExample task1 = new CallableExample(2, 4);
        CallableExample task2 = new CallableExample(4, 4);
        Future<Integer> futureTask1 = executorService.submit(task1);
        Future<Integer> futureTask2 = executorService.submit(task2);

        while (!futureTask1.isDone()) {

        }

        System.out.println(futureTask1.get());

        while (!futureTask2.isDone()) {

        }
        System.out.println(futureTask2.get());
    }

}
