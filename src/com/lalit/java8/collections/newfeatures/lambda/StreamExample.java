package com.lalit.java8.collections.newfeatures.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String... s) {
        List<String> name = new ArrayList<>();
        name.add("Lalit");
        name.add("Lucky");
        name.add("Goyal");
        name.add("Goyal");
        Stream<String> listOfStream = name.stream().distinct();
        listOfStream.map(e -> e.toUpperCase()).forEach(e -> System.out.println(e));
        listOfStream.map(e -> e.toUpperCase()).forEach(e -> System.out.println(e));
    }
}
