package com.lalit.algorithm.cache;

public class LinkedHashDSTest {
    public static void main(String... s) {
        LinkedHashDS<Integer, String> linkedHashDS = new LinkedHashDS<>();
        linkedHashDS.put(1, "lalit");
        linkedHashDS.put(2, "lucky");
        linkedHashDS.put(3, "Goyal");
        linkedHashDS.put(12, "lucky1");
        linkedHashDS.remove(2);
    }
}
