package com.lalit.java8.collections.newfeatures.concurrency.producerconsumerproblem;


import java.util.ArrayList;
import java.util.List;

/**
 * wait notify cause fast consumer to wait till slow Producer produces more message to queue
 **/
class Producer2 implements Runnable {

    MessageQueue2<Integer> queue;
    Integer value;

    public Producer2(MessageQueue2<Integer> queue, Integer value) {
        this.queue = queue;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            queue.enqueue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer2 implements Runnable {

    MessageQueue2<Integer> queue;

    public Consumer2(MessageQueue2<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.dequeue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MessageQueue2<T> {

    private List<T> list = new ArrayList<>();
    private int maxSize;

    public MessageQueue2(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void enqueue(T value) throws Exception {
        if (list.size() < maxSize) {
            list.add(list.size() == 0 ? 0 : list.size() - 1, value);
            this.notify();
        } else {
            while (isFull()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("After Enqueue size is :::" + this.size());
    }

    public synchronized T dequeue() throws Exception {
        while (isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T res = list.remove(0);
        System.out.println("After Dequeue size is :::" + this.size());
        this.notify();
        return res;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public boolean isFull() {
        return list.size() == maxSize;
    }

    public int size() {
        return list.size();
    }
}

public class InMemoryMessageQueueSystemUsingWaitNotify {

    public static void main(String... s) {
        MessageQueue2<Integer> messageQueue = new MessageQueue2<>(3);
        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; ++i) {
            Producer2 producer = new Producer2(messageQueue, i);
            Consumer2 consumer = new Consumer2(messageQueue);
            Thread th = new Thread(producer);
            Thread th1 = new Thread(consumer);
            th.start();
            th1.start();
            //Producer2 producer1 = new Producer2(messageQueue, i + 10);
            //   Thread th2 = new Thread(producer1);
            //    th2.start();

            Consumer2 consumer1 = new Consumer2(messageQueue);
            Thread th3 = new Thread(consumer1);
            th3.start();
        }
        // Consumer2 consumer = new Consumer2(messageQueue);
        //  executorService.submit(consumer);
    }

}
