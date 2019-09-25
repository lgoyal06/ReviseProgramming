package com.lalit.java8.collections.newfeatures.concurrency;

public class MessageProducerTask implements Runnable {

    EmailService emailService;
    int counter = 0;

    public MessageProducerTask(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void run() {
        try {
            emailService.putMessage("Message is coming");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
