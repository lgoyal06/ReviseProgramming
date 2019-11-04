package com.lalit.algorithm.general.flightinfosort;

import java.io.IOException;
import java.util.List;

public class MainClass {

    public static void main(String... s) throws IOException {

        List<FlightInfo> flightInfos = FileDataReaderUtils.readFile(new String[]{"FileA.txt", "FileB.txt", "FileC.txt"});
    }
}
