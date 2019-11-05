package com.lalit.algorithm.general.flightinfosort.main;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

public class MainClass {

    public static void main(String... s) throws IOException, ClassNotFoundException {
        List<FlightInfo> flightInfo = FileDataReaderUtils.readFile(new String[]{"FileA.txt", "FileB.txt", "FileC.txt"});
        TreeSet<FlightInfo> set = new TreeSet<>(FlightInfoComparatorFactory.getComparator(s[0], s[1]));
        set.addAll(flightInfo);
        set.stream().forEach(e -> System.out.println(e));
    }
}
