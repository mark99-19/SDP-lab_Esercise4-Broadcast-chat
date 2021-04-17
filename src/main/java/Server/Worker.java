package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Worker extends Thread {
    private final Socket connection;
    //private final BufferedReader inFromClient;
    //private final DataOutputStream outToClient;

    public Worker(Socket s) {
        connection = s;
        //inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        //outToClient = new DataOutputStream(connection.getOutputStream());
    }

    public void run() {
        /*String clientMessage;

        System.out.printf("[%d] Processo creato.", this.getId());
        System.out.printf("[%d] Client connesso: %s:%d",
                this.getId(),
                connection.getInetAddress().getHostAddress(),
                connection.getPort()
        );*/

        try {

            /*
            Codice per chiamare l'interfaccia di chat room
             */


            connection.close();

        }
        catch(Exception e) {
            e.printStackTrace();
            //System.err.println(e);
        }

    }

    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null) return false;
        if(!(o instanceof Worker)) return false;

        Worker worker = (Worker) o;
        return this.getId() == worker.getId();
    }
}
