package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.stream.IntStream;

public class TaskMultiThreadedExample1 extends Thread {

    public void run() {

        doTask();
    }

    private void doTask() {
        for(;;){
            if(interrupted()){
                System.out.println("Interrupted");
                break;
            }

            System.out.println("T");
        }
    }

    public static void main(String... s) throws InterruptedException {
        TaskMultiThreadedExample1 task1 = new TaskMultiThreadedExample1();
        task1.start();

        task1.sleep(1);
        task1.interrupt();
        IntStream.range(0, 15000).forEach(e -> System.out.print('M'));
    }
}
