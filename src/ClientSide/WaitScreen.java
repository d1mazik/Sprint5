package ClientSide;

import javax.swing.*;
import java.awt.*;

public class WaitScreen {

    //INTROSCREEN
    JPanel waitBasePanel = new JPanel();
    JLabel waitTitelLabel = new JLabel("Quizkampen",SwingConstants.CENTER);
    JLabel waitTextLabel = new JLabel("Waiting for the other players turn to end...",SwingConstants.CENTER);

    public WaitScreen() {

        waitBasePanel.add(waitTitelLabel, BorderLayout.NORTH);
        waitBasePanel.add(waitTextLabel, BorderLayout.CENTER);
        //Nedan fungerar inte
        waitBasePanel.setBackground(Color.decode("#8D9EFF"));


        /*        introBasePanel.setVisible(true);
        introBasePanel.setSize(800, 840);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("QuizKampen");*/

    }

    public JPanel getWaitScreen() {
        return waitBasePanel;
    }
    }

// Main metoden existerar bara för debugging. Ta bort vid implementering
//    public static void main(String[] args) {
//        IntroScreen is = new IntroScreen();
//    }
//}
