package ServerSide;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerListener {

    int port = 50001;

    public ServerListener() throws IOException {
            try (
                    ServerSocket serverSocket = new ServerSocket(port);
                )
            {
                while(true) {
                    GameProtocol gameProtocol = new GameProtocol();
                    gameProtocol.setPlayer1(new ServerSidePlayer(serverSocket.accept(), gameProtocol));
                    gameProtocol.setPlayer2(new ServerSidePlayer(serverSocket.accept(), gameProtocol));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerListener sl = new ServerListener();
    }
}

