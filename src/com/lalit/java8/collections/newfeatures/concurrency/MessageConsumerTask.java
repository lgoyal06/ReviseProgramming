package com.lalit.java8.collections.newfeatures.concurrency;

public class MessageConsumerTask implements Runnable {


    EmailService emailService;

    public MessageConsumerTask(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void run() {
        try {
            System.out.println(emailService.consumeMessage()+" Consumed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
