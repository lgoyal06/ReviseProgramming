package com.lalit.sapient.coding.problem.core;

import com.lalit.sapient.coding.problem.fileUtils.FileServiceFactory;
import com.lalit.sapient.coding.problem.model.InputFields;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String... s) {
        String reportName = "PerCapita";
        String fileFormat = "CSV";
        List<InputFields> extractedData = (List<InputFields>) FileServiceFactory.getFileService(reportName, fileFormat).readFromFile("/Users/lalitgoyal/Desktop/Input.csv");
        Map<String, Map<String, BigDecimal>> outputData = (Map<String, Map<String, BigDecimal>>) FileServiceFactory.getFileService(reportName, fileFormat).buildOutputData(extractedData);
        FileServiceFactory.getFileService(reportName, fileFormat).writeToFile("/Users/lalitgoyal/Desktop/Output1.csv", outputData);
    }
}