package com.lalit.java8.collections.newfeatures.lambda;

@FunctionalInterface
public interface FunctionalInterfacesExample<T> {

    void accept(T t);

    default void defaultMethod() {
        System.out.println("Default method");
    }


    default void defaultMethod1() {
        System.out.println("Default method");
    }

    static void staticMethod() {
        System.out.println("Static method");
    }

    static void staticMethod1() {
        System.out.println("Static method");
    }
}
