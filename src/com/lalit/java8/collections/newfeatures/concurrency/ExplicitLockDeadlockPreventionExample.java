package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLockDeadlockPreventionExample {

    public static void main(String... s) {
        Friend f = new Friend("A");
        Friend f1 = new Friend("B");
        Thread th = new Thread(new BowTask(f, f1));
        Thread th1 = new Thread(new BowTask(f1, f));
        th.start();
        th1.start();
    }

}

class BowTask implements Runnable {
    Friend f1, f2;

    public BowTask(Friend f1, Friend f2) {
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

class Friend {
    final String name;
    private final Lock lock = new ReentrantLock();

    public Friend(String name) {
        this.name = name;
    }

    public void bowed(Friend friend) {
        if (approachingBow(friend)) {
            System.out.println(friend.name + " bowed his friend " + this.name);
            friend.bowedBack(this);
        }
    }

    private void bowedBack(Friend friend) {
        System.out.println(friend.name + " bowed back his friend " + this.name);
    }

    public boolean approachingBow(Friend bower) {
        boolean myLock = false;
        boolean friendLock = false;
        if (this.lock.tryLock() && bower.lock.tryLock()) {
            return true;
        } else if (this.lock.tryLock()) {
            this.lock.unlock();
        } else {
            bower.lock.unlock();
        }
        return false;
    }
}
