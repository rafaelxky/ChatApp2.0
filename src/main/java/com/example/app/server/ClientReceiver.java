package com.example.app.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiver implements Runnable {

    private final Socket clientSocket;
    public BroadCaster broadCaster;
    public ClientHandler handler;
    public BufferedReader in;
    public ClientSender sender;
    public Client client;

    public ClientReceiver(Socket clientSocket, BroadCaster broadCaster, ClientHandler handler) {
        this.clientSocket = clientSocket;
        this.broadCaster = broadCaster;
        this.handler = handler;
        try {
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            this.sender = new ClientSender(this.clientSocket);
            this.client = new Client(sender, getUserName());
            broadCaster.add(this.client);
            listenLoop(this.in);
        } catch (IOException e) {
            System.err.println("Error in ClientReceiver: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException ignored) {}
            System.out.println(this.client.name + " disconnected: " + clientSocket.getRemoteSocketAddress());
        }
    }

    public void listenLoop(BufferedReader in) throws IOException {
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println(this.client.name + ": " + message);
            broadCaster.broadcast(message, this.sender);
        }
        System.out.println(this.client.name + " closed the connection");
    }

    public void serverMessage(String text){
        try {
            this.sender.send(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUserName(){
        try {
            this.sender.send("Type your name:");
            String name = this.in.readLine();
            this.sender.send("Hello " + name);
            return name;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
