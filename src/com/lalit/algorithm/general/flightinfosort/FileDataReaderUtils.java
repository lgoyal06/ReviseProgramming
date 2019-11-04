package com.lalit.algorithm.general.flightinfosort;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

public class FileDataReaderUtils {

    public void readFile(List<String> filesName) throws IOException {

        for (String fileName : filesName) {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                String[] splitByPipe = line.split("|");
                String dateTimeFormat = "mm-dd-yyyy HHMM";
                FlightInfo flightInfo = FlightInfo.FlightInfoBuilder.createInstance()
                        .setFlightNumber(Integer.valueOf(splitByPipe[0]))
                        .setDeptLocation(splitByPipe[1])
                        .setArrivalLocation(splitByPipe[2])
                        .setDate(splitByPipe[3])
                        .setTime(splitByPipe[4])
                        .setFlightDuration(Double.valueOf(splitByPipe[5]))
                        .setFare(new BigDecimal(splitByPipe[6]))
                        .build();
            }
        }
        File file = new File("FileA.txt");
        File file = new File("FileA.txt");
        File file = new File("FileA.txt");
    }
}
