package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class Worker extends Thread {
    private final Socket connection;
    private final BufferedReader inFromClient;
    private final Queue queue;
    private final DataOutputStream outToClient;
    private final ArrayList<DataOutputStream> currentClients;

    public Worker(Socket s, Queue queue, DataOutputStream clientOut, ArrayList<DataOutputStream> currentClients) throws Exception
    {
        this.connection = s;
        this.inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        this.queue = queue;
        this.outToClient = clientOut;
        this.currentClients  = currentClients;
    }

    public void run()
    {

        System.out.printf("[%d] Processo creato.\n", this.connection.getPort());
        System.out.printf("[%d] Client connesso: %s:%d\n",
                this.connection.getPort(),
                this.connection.getInetAddress().getHostAddress(),
                this.connection.getPort());

        while (!this.connection.isClosed()) {

            String message = "";
            try
            {
                message = inFromClient.readLine();

                //TODO: controlla metodo per evitare propagazione null
                if(message == null) continue;
                if(message.compareToIgnoreCase("exit") == 0){
                    // client asked to disconnect, close socket

                    message = String.format("[INFO] Il client con porta %d si è disconnesso dalla room.",
                            connection.getPort());

                    this.currentClients.remove(currentClients.indexOf(outToClient));
                    this.connection.close();

                    this.queue.put(message);

                    System.out.printf("[%d] Il client si è disconnesso: %s | %s.\n",
                            this.getId(),
                            this.currentClients.contains(outToClient),
                            this.connection.isClosed());

                } else queue.put(message);
            } catch(Exception e) {
                    e.printStackTrace();
            }
        }

    }
/*
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null) return false;
        if(!(o instanceof Worker)) return false;

        Worker worker = (Worker) o;
        return this.getId() == worker.getId();
    }*/
}
