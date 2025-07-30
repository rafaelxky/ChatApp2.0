package com.example.app.server.Commands;

public interface Command {
    public String execute();
    public String getFlag();
    public Scope getScope();

    default boolean hasArgs(){
        return false;
    }
}
