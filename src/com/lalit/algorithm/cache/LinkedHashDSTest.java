package com.lalit.algorithm.cache;

public class LinkedHashDSTest {
    public static void main(String... s) {

        //Put done
        LinkedHashDS<Integer, String> linkedHashDS = new LinkedHashDS<>(4);
        linkedHashDS.put(1, "lalit");
        linkedHashDS.put(2, "lucky");
        linkedHashDS.put(3, "Goyal");
        linkedHashDS.put(12, "lucky1");
        linkedHashDS.put(2, "jitu3");
        linkedHashDS.put(2, "jitu4");
        linkedHashDS.put(23, "jitu");
        linkedHashDS.printElement();
        System.out.println("--------------");
        linkedHashDS.remove(23);
        linkedHashDS.remove(12);
        linkedHashDS.put(132, "ertert");
        linkedHashDS.put(152, "fghfh");
        linkedHashDS.put(126, "sdfsdf");
        linkedHashDS.put(1246, "sdfsdf");
      //  linkedHashDS.put(1263, "sdfsdf");
        linkedHashDS.printElement();

        //linkedHashDS.remove(2);
    }
}
