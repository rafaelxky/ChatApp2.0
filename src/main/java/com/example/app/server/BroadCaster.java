package com.example.app.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BroadCaster {
    public List<Client> clientList;

    public BroadCaster(){
        this.clientList = new ArrayList<>();
    }

    public void add(Client clientSender) {
        clientList.add(clientSender);
    }

    public void broadcast(String message, ClientSender sender){
        for (Client client : clientList){
            try {
                if (client.clientSender != sender) {
                    client.clientSender.send(client.name + ": " + message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
