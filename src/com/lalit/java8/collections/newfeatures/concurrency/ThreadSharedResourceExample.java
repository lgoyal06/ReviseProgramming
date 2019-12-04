package com.lalit.java8.collections.newfeatures.concurrency;

class Sample {
    int x = 10;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void incr() throws InterruptedException {
        int y = getX();
        ++y;
        Thread.sleep(1);
        setX(y);
    }
}

class MyThread implements Runnable {

    Sample obj;

    public MyThread(Sample obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            obj.incr();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadSharedResourceExample {

    public static void main(String... s) throws InterruptedException {
        Sample obj = new Sample();
        Thread th1 = new Thread(new MyThread(obj));
        Thread th2 = new Thread(new MyThread(obj));
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(obj.getX());
    }
}
