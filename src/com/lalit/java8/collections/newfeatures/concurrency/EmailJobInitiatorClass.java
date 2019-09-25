package com.lalit.java8.collections.newfeatures.concurrency;

public class EmailJobInitiatorClass {


    public static void main(String... s) {
        EmailService emailService = new EmailService();
        Thread producerThread = new Thread(new MessageProducerTask(emailService));
        Thread consumerThread = new Thread(new MessageConsumerTask(emailService));
        producerThread.start();
        consumerThread.start();
        producerThread = new Thread(new MessageProducerTask(emailService));
        consumerThread = new Thread(new MessageConsumerTask(emailService));
        consumerThread.start();
        producerThread.start();
        producerThread = new Thread(new MessageProducerTask(emailService));
        producerThread.start();
        Thread consumerThread1 = new Thread(new MessageProducerTask(emailService));
        Thread consumerThread2 = new Thread(new MessageConsumerTask(emailService));
        consumerThread1.start();
        consumerThread2.start();

    }

}

