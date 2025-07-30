package com.example.app.server;

public class Client {
     public ClientSender clientSender;
     public String name;

     public Client (ClientSender clientSender, String name){
         this.clientSender = clientSender;
         this.name = name;
     }
}
