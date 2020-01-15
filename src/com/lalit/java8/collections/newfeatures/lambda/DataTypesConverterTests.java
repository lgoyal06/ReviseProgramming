package com.lalit.java8.collections.newfeatures.lambda;

import com.lalit.java8.collections.newfeatures.functionalinterfaces.DataTypesConverter;

public class DataTypesConverterTests {

    public static void main(String... s) {
        short[] array = new short[]{
                34, 2, 6, 5, 7, 8, 55, 4, 4, 46
        };
        byte[] byteArray = DataTypesConverter.shortToByteConverter(array, s1 -> (byte) s1);
        System.out.println(byteArray);
    }
}
