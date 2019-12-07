package com.lalit.java8.collections.newfeatures.concurrency;

class Sample1 {
    public static int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    static int a = 5;
    int b = 10;

    public void incr() throws InterruptedException {

        //Very good Learning Lock on Class object to make static fields /object thread safe in multi threaded environment
        synchronized (Sample1.class) {
            Thread.sleep(1);
            ++a;
        }
        synchronized (this) {
            Thread.sleep(1);
            ++b;
        }
    }
}


class MyThread1 implements Runnable {

    Sample1 obj;

    public MyThread1(Sample1 obj) {
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

public class SynchronizedExample {

    public static void main(String... s) throws InterruptedException {
        Sample1 s1 = new Sample1();
        Sample1 s2 = new Sample1();
        Thread th1 = new Thread(new MyThread1(s1));
        Thread th2 = new Thread(new MyThread1(s2));
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(s1.getA());
        System.out.println(s2.getA());
        System.out.println(s1.getB());
        System.out.println(s2.getB());
    }

}
