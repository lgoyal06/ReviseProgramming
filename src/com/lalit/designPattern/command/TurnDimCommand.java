package com.lalit.designPattern.command;

public class TurnDimCommand implements Commands {

    Light light;

    public TurnDimCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.turnDim();
    }
}
