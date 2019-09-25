package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ImplicitLockDeadlockExample {

    public static void main(String... s) {
        Friend1 f = new Friend1("A");
        Friend1 f1 = new Friend1("B");
        Thread th = new Thread(new BowTask1(f, f1));
        Thread th1 = new Thread(new BowTask1(f1, f));
        th.start();
        th1.start();

    }

}

class BowTask1 implements Runnable {
    Friend1 f1, f2;

    public BowTask1(Friend1 f1, Friend1 f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            f1.bowed(f2);
        }
    }
}

class Friend1 {
    final String name;

    public Friend1(String name) {
        this.name = name;
    }

    public synchronized void bowed(Friend1 friend) {
            System.out.println(friend.name + " bowed his friend " + this.name);
            friend.bowedBack(this);
    }

    private synchronized void bowedBack(Friend1 friend) {
        System.out.println(friend.name + " bowed back his friend " + this.name);
    }


}
