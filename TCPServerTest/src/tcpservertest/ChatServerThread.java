/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpservertest;

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

public class ChatServerThread extends Thread {

    private ChatServer server = null;
    private Socket socket = null;
    private int ID = -1;
    private ObjectInputStream streamIn = null;
    private ObjectOutputStream streamOut = null;
    private volatile boolean running = true;

    public ChatServerThread(ChatServer _server, Socket _socket) {
        super();
        server = _server;
        socket = _socket;
        ID = socket.getPort();
    }

    public void resetStreamOut() {
        try {
            streamOut.reset();
        } catch (Exception e) {
            System.out.println("Reset!!!!fail!!!");
        }
    }

    public void send(EcoSystem msg) {
        try {
            streamOut.reset();
            streamOut.writeObject(msg);
            streamOut.flush();

        } catch (IOException ioe) {
            System.out.println(ID + "ERROR sending" + ioe.getMessage());
            server.remove(ID);
            setStop();
        }
    }

    public int getID() {
        return ID;
    }

    public void setStop() {
        running = false;
    }

    public void run() {
        if (running) {
            System.out.println("Server Thread" + ID + "running");
            while (true) {
                try {
                    Object a = streamIn.readObject();
                    if (a.equals("Bye")) {
                        server.remove(ID);
                        setStop();
                        return;
                    }
                    EcoSystem eco = (EcoSystem) a;
                    server.handle(ID, eco);
                } catch (IOException ioe) {
                    System.out.println(ID + "Error reading:" + ioe.getMessage());
                    System.out.println(ID + "Error reading:" + ioe.getStackTrace());
                    ioe.printStackTrace();
                    server.remove(ID);
                    setStop();
                } catch (ClassNotFoundException e) {
                    System.out.println("ClassNotFoundException" + e.getMessage());

                }
            }
        }
    }

    public void open() throws IOException {

        streamOut = new ObjectOutputStream(socket.getOutputStream());
        streamOut.flush();
        streamIn = new ObjectInputStream(socket.getInputStream());
    }

    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
        if (streamIn != null) {
            streamIn.close();
        }
        if (streamOut != null) {
            streamOut.close();
        }
    }
}
