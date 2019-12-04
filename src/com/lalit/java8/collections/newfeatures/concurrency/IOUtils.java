package com.lalit.java8.collections.newfeatures.concurrency;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtils {
    public static void copyFile(String sourceFile, String destFile) throws IOException {
        if(Thread.currentThread().interrupted()){
            System.out.println("interrupted");
            new File(destFile).delete();
        }
        FileInputStream fis = new FileInputStream(sourceFile);
        FileOutputStream fout = new FileOutputStream(destFile);
        int value;
        while ((value = fis.read()) != -1) {
            fout.write(value);
        }
    }
}
