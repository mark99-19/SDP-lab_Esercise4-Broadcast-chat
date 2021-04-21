package Server;
import Server.Worker;

import java.io.DataOutputStream;
import java.util.ArrayList;

public class Broadcaster extends Thread{
    /*
    dorme sul buffer
    viene svegliato dal worker all'arrivo di un messaggio
    invia a tutti i client il primo messaggio nella coda
    */
    private ArrayList<DataOutputStream> currentClients;
    private Queue queue;

    public Broadcaster(ArrayList<DataOutputStream> currentClients, Queue queue)
    {
        this.currentClients = currentClients;
        this.queue = queue;
    }

    public void run()
    {
        String message = "";

        while(true){
            try{
                // waits on queue if no message present
                message = queue.take();

                for(DataOutputStream client : currentClients)
                {
                    client.writeBytes(message + "\n");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
