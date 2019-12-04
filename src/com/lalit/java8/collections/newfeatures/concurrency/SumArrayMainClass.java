package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumArrayMainClass {

    public static void main(String... s) throws ExecutionException, InterruptedException {
        int[] array = new int[]{34, 3, 3, 23, 34, 546, 34, 3, 3, 34, 34, 34, 4, 34};
        int arrayLength = array.length;
        int[] array1 = new int[arrayLength / 2];
        int[] array2 = new int[arrayLength / 2];
        for (int i = 0; i < arrayLength / 2; ++i) {
            array1[i] = array[i];
            array2[i] = array[arrayLength / 2 + i];
        }
        List<Future<Integer>> listOfFutures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        listOfFutures.add(executorService.submit(new SumOfArrayElementsTask(array1)));
        listOfFutures.add(executorService.submit(new SumOfArrayElementsTask(array2)));
        int arraySum = 0;
        for (Future<Integer> taskFutureObj : listOfFutures) {
            while (!taskFutureObj.isDone()) {
                Thread.yield();
            }
            arraySum = arraySum + taskFutureObj.get();
        }
        System.out.println(arraySum);
    }
}
