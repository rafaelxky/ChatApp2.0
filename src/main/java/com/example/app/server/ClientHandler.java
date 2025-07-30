package com.example.app.server;

import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    public Socket clientSocket;
    public BroadCaster broadCaster;
    public ClientSender sender;

    public ClientHandler(Socket clientSocket, BroadCaster broadCaster) {
        this.clientSocket = clientSocket;
        this.broadCaster = broadCaster;
    }

    @Override
    public void run() {
        System.out.println("Created new ClientThread");
        Thread listenerThread = new Thread(new ClientReceiver(this.clientSocket, this.broadCaster, this));
        listenerThread.start();
    }
}
