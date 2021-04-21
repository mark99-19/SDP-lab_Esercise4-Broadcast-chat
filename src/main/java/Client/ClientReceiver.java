package Client;

import java.net.Socket;
import java.io.*;

public class ClientReceiver extends Thread {

    private final BufferedReader inFromServer;
    private final Socket connection;


    protected ClientReceiver(Socket socket) throws Exception
    {
        this.inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.connection = socket;
    }


    public void run()
    {
        String message = "";
        while(!this.connection.isClosed()) {
            try {
                /*
                TODO: abbiamo vinto la battaglia ma non la guerra:
                 è necessario mettere qualcosa che non faccia crashare la readline!
                 (abbiamo già visto "Socket socket.wait()")
                */
                message = this.inFromServer.readLine();
                System.out.printf("[Client %d] Ricevuto un messaggio: %s\n",
                        this.getId(), message);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
