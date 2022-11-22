package ClientSide;

import Resources.QuestionsWithAnswers;
import ServerSide.Initiator;
import ServerSide.Response;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame {

/*

  TODO: STEG 1: Skapa en client som fungerar.
  TODO: STEG 2: lägg på nätverksdelarna.
  TODO: STEG 3: Koppla till actionlistener.
  TODO: STEG 4: Labba med hur data skickas via swing.

*/

    ClientGUI gui = new ClientGUI();
    IntroScreen introScreen;
    PlayScreen playScreen;
public static ObjectOutputStream oos;

    public Client() {
        //Swing stuff

        //network stuff
        String iAddress = "127.0.0.1";
        int port = 12345;

        try(
                Socket socketToServer = new Socket(iAddress,port);
                ObjectInputStream ois = new ObjectInputStream(socketToServer.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socketToServer.getOutputStream());
                )
        {
            Client.oos = oos;
            Object fromClient;
            Object fromServer;
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));

            while((fromServer = ois.readObject()) != null){
                if (fromServer instanceof Initiator){
                    IntroScreen introScreen = new IntroScreen();
                    gui.setCurrentPanel(introScreen.getIntroScreen());
                    oos.writeObject(new Response());
                } else if (fromServer instanceof QuestionsWithAnswers question) {
                    playScreen = new PlayScreen(question);
                    gui.setCurrentPanel(playScreen.getPlayScreen());
                } else if (fromServer instanceof Integer correctAnswerIndex) {
                    playScreen.revealAnswer(correctAnswerIndex);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Host address not eligible: " + iAddress);
            System.exit(1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
    }


}
