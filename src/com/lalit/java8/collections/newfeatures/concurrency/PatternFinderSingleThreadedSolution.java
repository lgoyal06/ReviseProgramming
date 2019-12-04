package com.lalit.java8.collections.newfeatures.concurrency;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PatternFinderSingleThreadedSolution {

    public static void main(String... s) throws Exception {

        List<List<Integer>> listOfFutures = new ArrayList<>();
        File currentFile = new File("C:\\workspace\\acl\\services\\web\\src\\main\\groovy\\com\\aon\\mmbs\\domain");
        File[] files = null;
        if (currentFile.isDirectory()) {
            files = currentFile.listFiles();
        }
        long startTime = System.currentTimeMillis();
        for (File file : files) {
            listOfFutures.add(PatternFinderUtils.find(file.getPath(), "public"));
        }
        for (List<Integer> result : listOfFutures) {
            result.stream().forEach(e -> System.out.print(e + ","));
            System.out.println();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time taken is:" + (endTime - startTime));
    }
}
