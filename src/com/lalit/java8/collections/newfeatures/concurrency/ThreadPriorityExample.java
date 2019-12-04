package com.lalit.java8.collections.newfeatures.concurrency;


public class ThreadPriorityExample {

    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            for (; ; ) System.out.print("T1");
        });
        th1.setPriority(Thread.MAX_PRIORITY);
        th1.start();
        Thread th2 = new Thread(() -> {
            for (; ; ) System.out.print("-");
        });
        th2.start();
    }

}