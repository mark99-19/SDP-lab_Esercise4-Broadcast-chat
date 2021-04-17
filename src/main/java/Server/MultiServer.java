package Server;

import Orchestrator.ChatRoom;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

    public static void main(String[] args) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){
            Socket connection = welcomeSocket.accept();
            Worker worker = new Worker(connection);
            worker.start();
        }
    }

}
