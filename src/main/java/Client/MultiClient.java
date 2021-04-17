package Client;

import Client.ClientReceiver;
import Client.ClientSender;

import java.net.Socket;


public class MultiClient extends Thread{

    public static void main(String[] args) throws Exception {

        String serversAddress = "localhost";
        int serverPort = 6789;
        Socket serverSocket = new Socket(serversAddress, serverPort);

        ClientReceiver receiver = new ClientReceiver(serverSocket);
        ClientSender sender = new ClientSender(serverSocket);

        receiver.start();
        sender.start();

    }

}


