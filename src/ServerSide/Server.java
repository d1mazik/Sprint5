package ServerSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Server extends Thread{

    int port = 12345;
    Socket socketToClient;
    Protocol protocol = new Protocol();
    public Server(Socket socketToClient){
        this.socketToClient = socketToClient;
    }

    public void run(){

        try     (
                ObjectOutputStream oos = new ObjectOutputStream(socketToClient.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socketToClient.getInputStream());
                )
        {
            Object fromUser;
            Object fromServer;

            oos.writeObject(protocol.processStage(null));
            while((fromUser = ois.readObject()) != null){
                oos.writeObject(protocol.processStage(fromUser));
                // FÖR DEBUGGING:
                System.out.println("Sent: " + fromUser);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
