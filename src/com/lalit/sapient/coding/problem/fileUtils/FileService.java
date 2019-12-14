package com.lalit.sapient.coding.problem.fileUtils;

public interface FileService {

    String getReportName();

    String getFileFormat();

    void writeToFile(String filePath, Object output);

    Object readFromFile(String filePath);

    Object buildOutputData(Object list);

}
