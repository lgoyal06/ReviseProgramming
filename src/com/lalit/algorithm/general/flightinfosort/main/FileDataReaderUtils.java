package com.lalit.algorithm.general.flightinfosort.main;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileDataReaderUtils {

    public static List<FlightInfo> readFile(String[] filesName) throws IOException {
        List<FlightInfo> flightInfos = new ArrayList<>();
        for (String fileName : filesName) {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/lalitgoyal/IdeaProjects/ReviseProgramming/src/com/lalit/algorithm/general/flightinfosort/main/" + fileName));
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                String[] splitByPipe = line.split("\\|");
                FlightInfo flightInfo = FlightInfo.FlightInfoBuilder.createInstance()
                        .setFlightNumber(splitByPipe[0])
                        .setDeptLocation(splitByPipe[1])
                        .setArrivalLocation(splitByPipe[2])
                        .setDate(LocalDate.parse(splitByPipe[3], DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                        .setTime(LocalTime.parse(splitByPipe[4], DateTimeFormatter.ofPattern("HHmm")))
                        .setFlightDuration(Double.valueOf(splitByPipe[5]))
                        .setFare(new BigDecimal(splitByPipe[6]))
                        .build();
                flightInfos.add(flightInfo);
                line = reader.readLine();
            }
        }
        return flightInfos;
    }
}
