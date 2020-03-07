package com.lalit.designPattern.command;


//Invoker
public class Switcher {

    public void execute(String action, Light light) throws Exception {
        CommandFactory.getCommandInstance(action, light).execute();
    }

}
