package org.academiadecodigo.loopeytunes.tictactoe;

public class Client {
    public static void main(String[] args) {
        String address = (args.length != 1) ? "192.168.1.14" : args[0];

        new Connection(address, 9900);

    }
}