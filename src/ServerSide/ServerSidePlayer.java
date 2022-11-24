package ServerSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSidePlayer extends Thread{
    Socket socketToClient;
    ObjectOutputStream oos;
    Protocol protocol;

    public ServerSidePlayer(Socket socketToClient){
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

            ServerListener.gameProtocol.receive(new Response());

            while((fromUser = ois.readObject()) != null){
                ServerListener.gameProtocol.receive(fromUser);
                //oos.writeObject(protocol.processStage(fromUser));
                // FÖR DEBUGGING:
                //System.out.println("Sent: " + fromUser);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
