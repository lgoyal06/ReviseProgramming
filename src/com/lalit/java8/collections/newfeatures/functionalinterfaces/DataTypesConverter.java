package com.lalit.java8.collections.newfeatures.functionalinterfaces;

public final class DataTypesConverter {

    public static byte[] shortToByteConverter(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        int i = 0;
        for (short element : array) {
            transformedArray[i] = function.apply(element);
            ++i;
        }
        return transformedArray;
    }
}

