package com.lalit.java8.collections.newfeatures.lambda;

public interface TestInterface {
    public String test(String content);

    default String test1(String content){
        return "sdfsdf";
    }
}
