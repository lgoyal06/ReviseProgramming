package com.lalit.designPattern.command;

public class TurnOnCommand implements Commands {

    Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.turnOn();
    }
}
