package ServerSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSidePlayer extends Thread{
    GameProtocol gameProtocol;
    Socket socketToClient;
    ObjectOutputStream oos;
    Protocol protocol;

    public ServerSidePlayer(Socket socketToClient, GameProtocol gameProtocol) {
        this.gameProtocol = gameProtocol;
        this.socketToClient = socketToClient;
    }

    public void run(){
        try     (
                ObjectOutputStream oos = new ObjectOutputStream(socketToClient.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socketToClient.getInputStream());
                )
        {
            this.oos = oos;
            Object fromUser;
            Object fromServer;

            gameProtocol.receive(new Response());

            while((fromUser = ois.readObject()) != null){
                gameProtocol.receive(fromUser);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
