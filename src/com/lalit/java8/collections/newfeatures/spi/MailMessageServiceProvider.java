package com.lalit.java8.collections.newfeatures.spi;

public class MailMessageServiceProvider implements MessageServiceProvider {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Message Via Mail");
    }
}
