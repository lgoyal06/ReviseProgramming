package com.lalit.designPattern.command;

public class TurnOffCommand implements Commands {

    Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.turnOff();
    }
}
