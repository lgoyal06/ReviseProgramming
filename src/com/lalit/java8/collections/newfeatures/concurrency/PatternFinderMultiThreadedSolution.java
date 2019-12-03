package com.lalit.java8.collections.newfeatures.concurrency;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PatternFinderMultiThreadedSolution {

    public static void main(String... s) throws Exception {

        List<Future<List<Integer>>> listOfFutures = new ArrayList<>();
        List<List<Integer>> listOfLines = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(25);
        File currentFile = new File("C:\\workspace\\acl\\services\\web\\src\\main\\groovy\\com\\aon\\mmbs\\domain");
        File[] files = null;
        if (currentFile.isDirectory()) {
            files = currentFile.listFiles();
        }
        long startTime = System.currentTimeMillis();
        for (File file : files) {
            listOfFutures.add(es.submit(() -> {
                return PatternFinderUtils.find(file.getPath(), "public");
            }));
        }
        for (Future<List<Integer>> taskFutureObj : listOfFutures) {
            while (!taskFutureObj.isDone()){

            }
            listOfLines.add(taskFutureObj.get());
        }
        for (List<Integer> listOfLine : listOfLines) {
            listOfLine.stream().forEach(e -> System.out.print(e + ","));
            System.out.println();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time taken is:" + (endTime - startTime));
    }
}
