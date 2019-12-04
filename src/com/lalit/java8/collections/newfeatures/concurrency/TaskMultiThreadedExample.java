package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.stream.IntStream;

public class TaskMultiThreadedExample extends Thread {

    public void run() {
        if(interrupted()){
            System.out.println("Interrupted");
        }

        doTask();
    }

    private void doTask() {
        IntStream.range(0, 150000).forEach(e -> System.out.print('T'));
    }

    public static void main(String... s) throws InterruptedException {
        TaskMultiThreadedExample task1 = new TaskMultiThreadedExample();
        task1.start();

        task1.sleep(1);
        task1.interrupt();
        IntStream.range(0, 15000).forEach(e -> System.out.print('M'));
    }
}
