package com.lalit.designPattern.command;

public class NoHandler implements Commands {
    @Override
    public void execute() throws Exception {
        throw new Exception("No Handler for this command found");
    }
}
