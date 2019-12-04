package com.lalit.java8.collections.newfeatures.concurrency;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created Task using Thread
 */
public class CopyFileTask implements Runnable {

    public final String sourceFile;
    public final String destFile;

    public CopyFileTask(String sourceFile, String destFile) {
        this.sourceFile = sourceFile;
        this.destFile = destFile;
    }

    @Override
    public void run() {
        try {
            IOUtils.copyFile(this.sourceFile, this.destFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
