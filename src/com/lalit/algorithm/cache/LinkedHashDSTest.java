package com.lalit.algorithm.cache;

public class LinkedHashDSTest {
    public static void main(String... s) {

        //Put done
        LinkedHashDS<Integer, String> linkedHashDS = new LinkedHashDS<>(7);
        linkedHashDS.put(1, "lalit");
        linkedHashDS.put(2, "lucky");
        linkedHashDS.put(3, "Goyal");
        linkedHashDS.put(12, "lucky1");
        linkedHashDS.put(2, "jitu");
        linkedHashDS.put(2, "jitu");
        Object value = linkedHashDS.search(3);
        System.out.println(value);
        //Search


        //linkedHashDS.remove(2);
    }
}
