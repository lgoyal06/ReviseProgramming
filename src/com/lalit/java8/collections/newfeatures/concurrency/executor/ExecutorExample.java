package com.lalit.java8.collections.newfeatures.concurrency.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample {

public static void main(String ...s){
    Executor executor = Executors.newSingleThreadExecutor();
    executor.execute(new TaskA());
}
}
