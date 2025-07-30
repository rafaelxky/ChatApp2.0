package com.example.app.server.Commands;

public class WisperCommand implements Command{
    @Override
    public String execute() {
        return null;
    }

    @Override
    public String getFlag() {
        return "-w";
    }

    @Override
    public Scope getScope() {
        return Scope.SPECIFIC;
    }
}
