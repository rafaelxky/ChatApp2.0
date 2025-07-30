package com.example.app.server.Commands;

public class ErrorCommand implements Command{
    @Override
    public String execute() {
        return "Invalid command";
    }

    @Override
    public String getFlag() {
        return null;
    }

    @Override
    public Scope getScope() {
        return Scope.SELF;
    }
}
