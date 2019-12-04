package com.lalit.java8.collections.newfeatures.concurrency;


/**
 * Udamy Course - https://www.udemy.com/course/java-multi-threading-by-sagar/learn/lecture/11972264#overview
 * */
public class MainClass {

    public static void main(String... s) throws InterruptedException {
        String currentPath = "/Users/lalitgoyal/IdeaProjects/ReviseProgramming/src/com/lalit/multithreading";
        CopyFileTask task1 = new CopyFileTask(currentPath + "/a.txt", currentPath + "/c2.txt");
        CopyFileTask task2 = new CopyFileTask(currentPath + "/b.txt", currentPath + "/d2.txt");

        //Running one thread per task
       Thread th1 = new Thread(task1);
        Thread th2 = new Thread(task2);
        th1.start();
        th2.start();
        th1.sleep(10);
        th2.sleep(20);
        th1.interrupt();
        th2.interrupt();

        //Using Executor framework to handle creation and management of the thread for running tasks
        /**Executor executor = Executors.newFixedThreadPool(10);
        executor.execute(task1);
        executor.execute(task2);**/
    }
}
