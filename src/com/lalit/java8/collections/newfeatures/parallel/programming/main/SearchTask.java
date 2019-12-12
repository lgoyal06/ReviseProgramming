package com.lalit.java8.collections.newfeatures.parallel.programming.main;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SearchTask extends RecursiveTask<Integer> {
    int[] array;
    int start;
    int end;
    int elementToSearch;

    public SearchTask(int[] array, int startIndex, int endIndex, int elementToSearch) {
        this.array = array;
        this.start = startIndex;
        this.end = endIndex;
        this.elementToSearch = elementToSearch;
    }

    @Override
    protected Integer compute() {
        int sizeOfArray = start + end;
        //System.out.println(sizeOfArray);
        if (end - start <= 3) {
            return processSearch(array, start, end, elementToSearch);
        } else {
            int mid = sizeOfArray / 2;
            SearchTask st1 = new SearchTask(array, start, mid, elementToSearch);
            SearchTask st2 = new SearchTask(array, mid + 1, end, elementToSearch);
            st1.fork();
            st2.fork();
            int total = st1.join() + st2.join();
            return total;
        }
    }

    private Integer processSearch(int[] array, int start, int end, int elementToSearch) {
        int count = 0;
        for (int i = start; i <= end; ++i) {
            if (array[i] == elementToSearch) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String... s) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int[] array = {
                4, 5, 3, 67, 65, 67, 67, 4, 5, 5, 5, 5
        };
        System.out.println("CPU Core: " + Runtime.getRuntime().availableProcessors());
        System.out.println("CommonPool Parallelism: " + ForkJoinPool.commonPool().getParallelism());
        System.out.println("CommonPool Common Parallelism: " + ForkJoinPool.getCommonPoolParallelism());
        SearchTask st = new SearchTask(array, 0, array.length - 1, 5);
        Integer int1 = pool.invoke(st);
        System.out.println(int1);
    }
}
