package com.example.app.server.Commands;

public class LennyCommand implements Command{
    @Override
    public String execute() {
        return "( ͡° ͜ʖ ͡°)";
    }

    @Override
    public String getFlag() {
        return "-lenny";
    }

    @Override
    public Scope getScope() {
        return Scope.ALLANDSELF;
    }
}
