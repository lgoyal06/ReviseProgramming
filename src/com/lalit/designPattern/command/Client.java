package com.lalit.designPattern.command;

//Client
public class Client {

    public static void main(String... s) throws Exception {
        //receiver
        Light light = new Light();
        //invoker
        Switcher switcher = new Switcher();
        switcher.execute("TURN_ON", light);
        switcher.execute("TURN_DIM", light);
        switcher.execute("TURN_OFF", light);
    }

}
