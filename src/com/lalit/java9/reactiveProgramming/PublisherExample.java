package com.lalit.java9.reactiveProgramming;
/**
import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

public class PublisherExample {

    public static void main(String ...s){
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        //Register Subscriber
        MySubscriber<String> subscriber = new MySubscriber<>();
        publisher.subscribe(subscriber);

        //Publish items
        System.out.println("Publishing Items...");
        int i1=0;
        while(i1<10000000){
            String[] items = {"1", "x", "2", "x", "3", "x"};
            Arrays.asList(items).stream().forEach(i -> publisher.submit(i));
            ++i1;
        }
        publisher.close();
    }
}
**/