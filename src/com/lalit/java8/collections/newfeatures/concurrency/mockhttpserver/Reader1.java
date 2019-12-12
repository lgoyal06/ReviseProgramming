package com.lalit.java8.collections.newfeatures.concurrency.mockhttpserver;

import java.io.*;

public class Reader1{

    public static void printFile() throws IOException {
        File fileDB = new File("/Users/lalitgoyal/IdeaProjects/ReviseProgramming/src/com/lalit/java8/collections/newfeatures/concurrency/mockhttpserver/a.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
           // fr = new InputStreamReader(fileDB.g);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileDB)));
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new IOException();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            br.close();
//            fr.close();
        }
    }
    public static void main(String ...s) throws IOException {
        Reader1.printFile();
    }

}