package com.example.app.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSender {
    private final BufferedWriter out;

    public ClientSender(Socket clientSocket) {
        try {
            this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String text) throws IOException {
        out.write(text +"\n");
        out.flush();
    }
}
