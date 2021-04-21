package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSender extends Thread {

    private final BufferedReader userInput;
    private final DataOutputStream outToServer;
    private final Socket connection;

    protected ClientSender(Socket socket) throws IOException
    {
        this.userInput = new BufferedReader(new InputStreamReader(System.in));
        this.outToServer = new DataOutputStream(socket.getOutputStream());
        this.connection = socket;
    }

    public void run()
    {
        String input;
        while(!this.connection.isClosed()) {
            try {
                input = userInput.readLine();
                this.outToServer.writeBytes(input + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
