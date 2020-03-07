package com.lalit.reactive.programming;

import java.util.function.Supplier;

public class MatchMeClass_new {

    public static String matchMe(Supplier<Boolean> result1, Supplier<Boolean> result2) {
        return result1.get() && result2.get() ? "both values are equals" : "values are different";
    }
}
