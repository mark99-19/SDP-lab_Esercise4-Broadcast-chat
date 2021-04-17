package Client;

import java.net.Socket;
import java.io.*;

public class ClientReceiver extends Thread {

    private final Socket socket;
    private final DataOutputStream outToClient;
    private final BufferedReader inFromServer;

    //TODO: servono entrambi gli stream?

    protected ClientReceiver(Socket socket) throws Exception
    {
        this.socket = socket;
        this.outToClient = new DataOutputStream(this.socket.getOutputStream());
        this.inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run()
    {
        String message;
        while(true)
        {
            try {
                message = inFromServer.readLine();
                System.out.printf("[Client %d] Ricevuto un messaggio: %s",
                        this.getId(), message);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
