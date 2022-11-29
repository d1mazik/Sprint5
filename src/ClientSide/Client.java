package ClientSide;

import Resources.GameResults;
import Resources.QuestionPackage;
import ServerSide.Category;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame {

    ClientGUI gui = new ClientGUI();
    IntroScreen introScreen;
    PlayScreen playScreen;
    ResultScreen waitScreen;
    public static ObjectOutputStream oos;

    public Client() {
        //Swing stuff

        //network stuff
        String iAddress = "127.0.0.1";
        int port = 50001;

        try (
                Socket socketToServer = new Socket(iAddress, port);
                ObjectInputStream ois = new ObjectInputStream(socketToServer.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socketToServer.getOutputStream());
        ) {
            Client.oos = oos;
            Object fromClient;
            Object fromServer;
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));

            while ((fromServer = ois.readObject()) != null) {
                if (fromServer instanceof String string && string.equals("waitForPlayers")) {
                    introScreen = new IntroScreen();
                    gui.setCurrentPanel(introScreen.getIntroScreen());
                } else if (fromServer instanceof Category[] categories) {
                    gui.setCurrentPanel(new ChooseCategoryScreen(categories).getCategoryScreen());
                } else if (fromServer instanceof QuestionPackage question) {
                    playScreen = new PlayScreen(question);
                    gui.setCurrentPanel(playScreen.getPlayScreen());
                } else if (fromServer instanceof Integer correctAnswerIndex) {
                    playScreen.revealAnswer(correctAnswerIndex);
                } else if (fromServer instanceof GameResults gameResults) {
                    System.out.println("Wait Screen");
                    waitScreen = new ResultScreen(gameResults);
                    gui.setCurrentPanel(waitScreen.getWaitScreen());
                } else if (fromServer instanceof String string && string.equals("enableButton")) {
                    waitScreen.enableStartNextRoundButton();
                } else if (fromServer instanceof String string && string.equals("loadingQuestions")) {
                    System.out.println("Loading Questions");
                } else if (fromServer instanceof int[] correctAnswersPerPlayer) {
                    gui.setCurrentPanel(new EndGameScreen(correctAnswersPerPlayer[0], correctAnswersPerPlayer[1]).getEndOfGameBasePanel());
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
