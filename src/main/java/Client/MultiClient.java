package Client;

import Server.Queue;

import java.net.Socket;


public class MultiClient {

    public static void main(String[] args) throws Exception
    {

        String serversAddress = "localhost";
        int serverPort = 6789;
        Socket serverSocket = new Socket(serversAddress, serverPort);

        ClientReceiver receiver = new ClientReceiver(serverSocket);
        ClientSender sender = new ClientSender(serverSocket);

        receiver.start();
        sender.start();

    }

}


