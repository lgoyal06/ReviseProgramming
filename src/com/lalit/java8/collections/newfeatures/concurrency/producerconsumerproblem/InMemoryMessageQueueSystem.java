package com.lalit.java8.collections.newfeatures.concurrency.producerconsumerproblem;


import java.util.ArrayList;
import java.util.List;

/**
 * Slow Producer thread and Fast Consumer thread is causing Queue empty exception
 **/
class Producer implements Runnable {

    MessageQueue<Integer> queue;
    Integer value;

    public Producer(MessageQueue<Integer> queue, Integer value) {
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

class Consumer implements Runnable {

    MessageQueue<Integer> queue;

    public Consumer(MessageQueue<Integer> queue) {
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

class MessageQueue<T> {

    private List<T> list = new ArrayList<>();
    private int maxSize;

    public MessageQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void enqueue(T value) throws Exception {
        if (list.size() < maxSize) {
            list.add(list.size() == 0 ? 0 : list.size() - 1, value);
        } else {
            throw new Exception("Queue is full , can not insert anymore");
        }
        System.out.println("After Enqueue size is :::" + this.size());
    }

    public synchronized T dequeue() throws Exception {
        if (list.size() > 0) {
            T res = list.remove(0);
            System.out.println("After Dequeue size is :::" + this.size());
            return res;
        }
        throw new Exception("Queue is empty , can not delete anymore");
    }

    public int size() {
        return list.size();
    }
}

public class InMemoryMessageQueueSystem {

    public static void main(String... s) {
        MessageQueue<Integer> messageQueue = new MessageQueue<>(3);
        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; ++i) {
            Producer producer = new Producer(messageQueue, i);
            Consumer consumer = new Consumer(messageQueue);
            Thread th = new Thread(producer);
            Thread th1 = new Thread(consumer);
            th.start();
            th1.start();
            //Producer producer1 = new Producer(messageQueue, i + 10);
            //   Thread th2 = new Thread(producer1);
            //    th2.start();

            Consumer consumer1 = new Consumer(messageQueue);
            Thread th3 = new Thread(consumer1);
            th3.start();
        }
        // Consumer consumer = new Consumer(messageQueue);
        //  executorService.submit(consumer);
    }

}
