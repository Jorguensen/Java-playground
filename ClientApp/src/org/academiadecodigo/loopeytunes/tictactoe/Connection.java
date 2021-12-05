package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.graphics.Text;
import java.io.*;
import java.net.Socket;

public class Connection {
    private final Cursor cursor;
    private BufferedReader in;
    private PrintWriter out;

    public Connection(String host, int port) {

        new Field();

        cursor = new Cursor(Field.PADDING, Field.PADDING, Field.WIDTH / 3, Field.HEIGHT / 3);

        setupConnection(host, port);
        start();
    }

    public void setupConnection(String host, int port) {

        try {
            Socket clientSocket = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String answer = in.readLine();
            if (answer.equals("a")) {
                cursor.setPlaying(true);
            }

        } catch (IOException e) {

            System.out.println("Server offline.");
            Text errorMessage = new Text(Field.WIDTH / 2, Field.HEIGHT / 2, "SERVER OFFLINE");
            errorMessage.grow(200, 100);
            errorMessage.draw();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.exit(1);
        }
    }

    public void start() {
        if (cursor.isPlaying()) {
            play();
        }

        while (!cursor.isGameOver()) {
            String opponent;

            try {
                System.out.println("listening...");

                opponent = in.readLine();

                if ( opponent != null) {
                    System.out.println("position received: " + opponent);

                    cursor.addOpponentPlayToList(opponent);

                    if (!cursor.isGameOver()) {
                        cursor.setPlaying(true);
                        play();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void play() {
        String play;

        while (true) {

            play = cursor.getLastPlay();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (play != null) {
                out.println(cursor.getLastPlay());

                cursor.nullLastPlay();
                break;
            }
        }
    }
}
