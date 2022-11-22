package ServerSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {

    int port = 12345;

    public ServerListener() throws IOException {
            try (
                    ServerSocket serverSocket = new ServerSocket(port);
            )
            {
                while(true) {
                    Socket socketToClient = serverSocket.accept();
                    Server server = new Server(socketToClient);
                    server.start();
            }

        }
    }


    public static void main(String[] args) throws IOException {
        ServerListener sl = new ServerListener();
    }
}

