package com.lalit.sapient.coding.problem.fileUtils;

import java.util.ArrayList;
import java.util.List;

public class FileServiceFactory {

    static final List<FileService> fileServiceList = new ArrayList<>();

    static {
        fileServiceList.add(new PerCapitaCSVFileService());
    }

    public static FileService getFileService(String reportName, String fileFormat) {
        for (FileService fs : fileServiceList) {
            if (fs.getFileFormat().equalsIgnoreCase(fileFormat) && fs.getReportName().equalsIgnoreCase(reportName)) {
                return fs;
            }
        }
        throw new RuntimeException("No Matching Implementation has been found");
    }
}
