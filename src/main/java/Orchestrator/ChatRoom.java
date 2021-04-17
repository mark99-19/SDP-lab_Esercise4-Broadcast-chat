package Orchestrator;

import Server.Worker;
import java.util.ArrayList;

public class ChatRoom {
    private static Queue buffer;
    private static ArrayList<Worker> clients;


    public static void main(String[] args) {

        buffer = new Queue();

    }

    public synchronized boolean sendMessage(String message)
    {

    }

    private synchronized boolean joinRoom(Worker client)
    {

    }

    private synchronized boolean exitRoom(Worker client)
    {
        try {
            clients.remove(clients.indexOf(client));
            return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // private synchronized void

    /*
    Debugging purposes
     */
    private void getCurrentClients()         //print all clients (JVM references || PIDs)
    {
        System.out.println(this.clients);
    }

}
