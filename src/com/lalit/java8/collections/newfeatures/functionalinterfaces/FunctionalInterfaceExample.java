package com.lalit.java8.collections.newfeatures.functionalinterfaces;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

//https://www.baeldung.com/java-8-functional-interfaces  very good link
public class FunctionalInterfaceExample {


    public static Stream<Integer> fibonacciSeries() {
        int fibs[] = {0, 1};
        return Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        });
    }

    public static void main(String... s) {
        Map<String, Integer> map = new HashMap<>();
        Integer val = map.computeIfAbsent("John", String::length);
        System.out.println(val);
        Function<Integer, String> intToString = Objects::toString;
        Function<String, String> quote = s1 -> "'" + s1 + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        System.out.println(intToString.apply(5));
        System.out.println(quoteIntToString.apply(5));
        // Function<Integer, String> intToStringQuote = intToString.compose(quote);
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("Freddy", 343434);
        salaries.put("John", 1222);
        salaries.put("lalit", 121212121);
        salaries.replaceAll((name, oldVal) -> name.equalsIgnoreCase("Freddy") ? oldVal : oldVal + 1000);
        salaries.values().stream().forEach(System.out::println);
        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());
        // FunctionalInterfaceExample.fibonacciSeries().forEach(System.out::println);
        List<String> names = Arrays.asList("bob", "lalit", "goyal");
        names.replaceAll(name -> name.toUpperCase());
        names.stream().forEach(System.out::println);
        List<Integer> values = Arrays.asList(3, 5, 6, 8, 8);
        int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
        values.stream().count();
        System.out.println(sum);
    }
}
