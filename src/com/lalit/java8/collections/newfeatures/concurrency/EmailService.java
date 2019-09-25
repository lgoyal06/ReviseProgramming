package com.lalit.java8.collections.newfeatures.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class EmailService {

    private Queue<String> messageQueue = new LinkedList<String>();

    public void putMessage(String message) throws InterruptedException {

        System.out.println(message);
        synchronized (this) {
            messageQueue.add(message);
        }
    }

    public String consumeMessage() throws InterruptedException{
        synchronized (this) {
            String message = messageQueue.poll();
            return message;
        }
    }

    public boolean isQueueEmpty() {
        return messageQueue.isEmpty();
    }

    public boolean isQueueFull() {
        return messageQueue.size() == 10;
    }
}
