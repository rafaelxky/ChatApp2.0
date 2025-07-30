package com.example.app.server;

public class ServerMain {
    public static void main(String[] args) {
        ServerListener server = new ServerListener();
        server.start();
    }
}
