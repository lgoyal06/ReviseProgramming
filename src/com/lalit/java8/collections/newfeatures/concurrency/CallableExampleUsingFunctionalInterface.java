package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExampleUsingFunctionalInterface {
    public static void main(String... s) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> futureTask1 = executorService.submit(()->{return MyMath.add(3,4);});
        Future<Integer> futureTask2 = executorService.submit(()->{return MyMath.add(4,4);});
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
    }

}
