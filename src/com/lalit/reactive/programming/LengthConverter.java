package com.lalit.reactive.programming;

public class LengthConverter {
    public String toMeter(int len) {
        return len / 100.0 + " meter";
    }

    public String toKiloMeter(int len) {
        return len / 1000.0 + " km";
    }
}