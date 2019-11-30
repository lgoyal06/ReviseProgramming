package com.lalit.system.design.tinyurl;

import java.io.IOException;

public class TinyUrlMain {
    public static void main(String... s) throws IOException {
        DBOperations dbOperations = new FileDBOperationsImpl();
        String shortUrl = dbOperations.save(s[0]);
        System.out.println("http://srt.url/" + shortUrl);
        // System.out.println(dbOperations.fetchOriginalUrl(s[0].substring(s[0].lastIndexOf("/") + 1)));
    }
}
