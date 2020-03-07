package com.lalit.reactive.programming;

public class ShowLength {
    public void show(int length) {
        System.out.println(new LengthConverter().toKiloMeter(length));
    }
}
