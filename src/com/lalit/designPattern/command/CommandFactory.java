package com.lalit.designPattern.command;

public class CommandFactory {

    private CommandFactory() {
    }

    public static Commands getCommandInstance(String action, Light light) {
        if (action.equalsIgnoreCase(CommandsEnum.TURN_ON.name())) {
            return new TurnOnCommand(light);
        } else if (action.equalsIgnoreCase(CommandsEnum.TURN_OFF.name())) {
            return new TurnOffCommand(light);
        } else if (action.equalsIgnoreCase(CommandsEnum.TURN_DIM.name())) {
            return new TurnDimCommand(light);
        }
        return new NoHandler();
    }

}
