package org.academiadecodigo.loopeytunes.tictactoe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket serverSocket;
    private ExecutorService cachedPool;
    private HashMap<Integer, ServerConnection> connectionsMap;
    private int connectionCounter = 0;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            setupConnection();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                connectionCounter++;
                ServerConnection serverConnection = new ServerConnection(clientSocket, this);
                cachedPool.submit(serverConnection);
                connectionsMap.put(connectionCounter, serverConnection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupConnection() throws IOException {
        int port = 9900;
        serverSocket = new ServerSocket(port);
        cachedPool = Executors.newCachedThreadPool();
        connectionsMap = new HashMap<>();
    }

    public void broadcast(String message, ServerConnection sender) {

        for (ServerConnection serverConnection : connectionsMap.values()) {
            if (sender.getPlayerNumber() % 2 != 0) {
                if (serverConnection.getPlayerNumber() == sender.getPlayerNumber() + 1) {
                    serverConnection.respond(message);
                }
            } else {
                if (serverConnection.getPlayerNumber() == sender.getPlayerNumber() - 1) {
                    serverConnection.respond(message);
                }
            }
        }
    }

    public int getConnectionCounter() {
        return connectionCounter;
    }

}
