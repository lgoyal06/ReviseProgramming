package com.lalit.designPattern.command;


//Receiver
public class Light {

    public void turnOn() {
        System.out.println("Light turned on");
    }

    public void turnOff() {
        System.out.println("Light turned off");
    }

    public void turnDim() {
        System.out.println("Light turned  Dim");
    }
}
