/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

/**
 *
 * @author liuch
 */
import Network.Network;
import business.Person.Person;
import business.UserAccount.UserAccount;
import business.business.EcoSystem;
import java.net.*;
import java.io.*;

public class ChatClientThread extends Thread {

    private Socket socket = null;
    private MainJFrame client = null;
    private ObjectInputStream streamIn = null;
    private volatile boolean running = true;

    public ChatClientThread(MainJFrame _client, Socket _socket) {
        client = _client;
        socket = _socket;
        open();
        System.out.println("lll");
        start();
    }

    public void open() {
        try {
            System.out.println("3333");
            streamIn = new ObjectInputStream(socket.getInputStream());
            System.out.println("opened");
        } catch (IOException ioe) {
            System.out.println("Error getting input stream:" + ioe);
            client.stop();
        }
    }

    public void close() {
        try {
            if (streamIn != null) {
                streamIn.close();
            }
        } catch (IOException ioe) {
            System.out.println("Error closing input stream:" + ioe);

        }
    }

    public void setStop() {
        running = false;
    }

    public void run() {
        if (running) {
            while (true) {
                try {
                    client.handle((EcoSystem) streamIn.readObject());
                    System.out.println("[ps");
                } catch (IOException ioe) {
                    System.out.println("Learning error:" + ioe.getMessage());
                    client.stop();
                } catch (ClassNotFoundException e) {
                    System.out.println("Class Nor found error" + e.getMessage());
                }

            }
        }
    }
}
