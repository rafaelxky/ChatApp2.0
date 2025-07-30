package com.example.app.server.Commands;

import com.example.app.server.Client;

public class List implements Command{

    @Override
    public String execute() {
       java.util.List<Client> clientList = Commands.getBroadCaster().get().clientList;
       StringBuilder out = new StringBuilder();
       out.append("Users:");
       for (Client client : clientList){
           out.append("\n").append(client.name);
       }
       return out.toString();
    }

    @Override
    public String getFlag() {
        return "-l";
    }

    @Override
    public Scope getScope() {
       return Scope.SELF;
    }
}
