package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSender extends Thread {
    private Socket socket;
    private BufferedReader userInput;
    DataOutputStream outToServer;

    protected ClientSender(Socket socket) throws IOException {
        this.socket = socket;
        this.userInput = new BufferedReader(new InputStreamReader(System.in));
        this.outToServer = new DataOutputStream(socket.getOutputStream());
    }

    public void run()
    {
        String input;
        while(true)
        {
            System.out.printf("[Client %d] Inserisci un messaggio: ", this.getId());
            try {
                input = userInput.readLine();
                this.outToServer.writeBytes(input + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
