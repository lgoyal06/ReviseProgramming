package com.lalit.java8.collections.newfeatures.concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableFutures {

    public static void main(String... s) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Long>> listOfFutures = new ArrayList<>();
        for (int i = 0; i < 2; ++i) {
            Callable<Long> worker = new MyCallable();
            Future<Long> submit = executor.submit(worker);
            listOfFutures.add(submit);
        }
        long sum = 0;
        System.out.println(listOfFutures.size());
        for (Future<Long> future : listOfFutures) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        executor.shutdown();

    }
}
