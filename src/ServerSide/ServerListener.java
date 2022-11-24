package ServerSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerListener {

    static GameProtocol gameProtocol;
    int port = 50001;

    public ServerListener() throws IOException {
            try (
                    ServerSocket serverSocket = new ServerSocket(port);
                )
            {

                while(true) {
                    gameProtocol = new GameProtocol(serverSocket.accept(), serverSocket.accept());
                    //Game game = new Game(playerOne, playerTwo);
                    //games.add(game);
                    //game.initPlayerOneFirstRound();
                    //playerOne.protocolNextStage();
                    //playerOne.oos.writeObject(playerOne.protocol.processStage(null));
                    /*
       public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Tic Tac Toe Server is Running");
        try {
            while (true) {
                ServerSideGame game = new ServerSideGame();

                ServerSidePlayer playerX
                        = new ServerSidePlayer(listener.accept(), 'X', game);
                ServerSidePlayer playerO
                        = new ServerSidePlayer(listener.accept(), 'O', game);

                playerX.setOpponent(playerO);
                playerO.setOpponent(playerX);
                game.currentPlayer = playerX;
                playerX.start();
                playerO.start();

                //ALternativ approach
                //Game2 game2 = new Game2(socket1, socket2);

            }
        } finally {
            listener.close();
        }
                    * */


            }

        }
    }


    public static void main(String[] args) throws IOException {
        ServerListener sl = new ServerListener();
    }
}

