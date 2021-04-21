package Server;

import javax.xml.crypto.Data;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {

    public static void main(String[] args) throws Exception
    {
        ArrayList<DataOutputStream> clients = new ArrayList<DataOutputStream>();
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Queue queue = new Queue();

        /*
        Takes list of clients' streams which is initially empty.
        It gets updated on every while iteration.
         */
        Broadcaster caster = new Broadcaster(clients, queue);
        caster.start();

        while(true){
            Socket connection = welcomeSocket.accept();

            /*
            Created and passed to Worker so that it can remove the client from the list
            upon request
             */
            DataOutputStream clientOut = new DataOutputStream(connection.getOutputStream());

            // Updates list of clients with the new addition
            clients.add(clientOut);
            Worker worker = new Worker(connection, queue, clientOut, clients);
            worker.start();
        }
    }

}

