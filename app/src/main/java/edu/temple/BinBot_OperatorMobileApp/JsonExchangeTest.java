package edu.temple.BinBot_OperatorMobileApp;

import BinBotDemo1.connections.ServerConnection;

import java.io.IOException;

/**
 * Class to test exchanging .jgp files between the client and server.
 *
 * @author Sean DiGirolamo
 * @version 1.0
 * @since 2019-10-25
 */
public class JsonExchangeTest {

    static final String IP = "127.0.0.1";
    static final int PORT = 7002;

    static ServerConnection connection;

    public static void main(String[] args) throws IOException {
        serverTest();
    }

    public static void serverTest() throws IOException {
        System.out.println("Connecting to " + IP + " " + PORT + "...");
        connection = new ServerConnection(IP, PORT);
        System.out.println("Connection established!");

        System.out.println("Attempting to receive");
        String jsonReceive = connection.receive();
        System.out.println("received: " + jsonReceive);

        AppMessage instrSend = new AppMessage(jsonReceive);
        System.out.print("Sending: " + instrSend.json());
        connection.send(instrSend.json());
        System.out.println("Sent");
    }
}