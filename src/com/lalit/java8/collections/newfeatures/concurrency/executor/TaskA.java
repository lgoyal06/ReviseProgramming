package com.lalit.java8.collections.newfeatures.concurrency.executor;

public class TaskA implements Runnable {

    @Override
    public void run() {
        System.out.println("Task A started");
    }
}
