package com.lalit.java8.collections.newfeatures.spi;

public class SMSMessageServiceProvider implements MessageServiceProvider {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Message Via SMS");
    }
}
