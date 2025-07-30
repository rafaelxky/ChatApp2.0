package com.example.app.server;

import com.example.app.server.Commands.Commands;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerListener {
    public BroadCaster broadCaster;

    public ServerListener(){
        this.broadCaster = new BroadCaster();
        Commands.addBroadCaster(broadCaster);
        Commands.setup();
    }

    public void start() {
        System.out.println("Started server");
            try {
                ServerSocket serverSocket = new ServerSocket(9005);
                while (true) {
                    listen(serverSocket);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public void listen(ServerSocket serverSocket){
        try {
            Socket clientSocket = serverSocket.accept();
            Thread clientHandler = new Thread(new ClientHandler(clientSocket, this.broadCaster));
            clientHandler.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
