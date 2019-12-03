package com.lalit.java8.collections.newfeatures.concurrency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatternFinderUtils {

    public static List<Integer> find(String filePath, String pattern) {
        List<Integer> listOfLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            int lineNumber = 1;
            while ((line != null)) {
                if (line.contains(pattern)) {
                    listOfLines.add(lineNumber);
                }
                ++lineNumber;
                line = br.readLine();
            }
            Thread.sleep(100);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return listOfLines;
    }
}
