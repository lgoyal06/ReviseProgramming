package com.lalit.java8.collections.newfeatures.functionalinterfaces;

@FunctionalInterface
public interface TypeAToBConverterFunction<T, V> {

    V apply(T val);
}