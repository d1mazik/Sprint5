package ClientSide;

import javax.swing.*;
import java.awt.*;

public class IntroScreen {

    //INTROSCREEN
    JPanel introBasePanel = new JPanel();
    JLabel introTitelLabel = new JLabel("Quizkampen",SwingConstants.CENTER);
    JLabel introTextLabel = new JLabel("Waiting for another player to connect...",SwingConstants.CENTER);

    public IntroScreen() {

        introBasePanel.add(introTitelLabel, BorderLayout.NORTH);
        introBasePanel.add(introTextLabel, BorderLayout.CENTER);
        //Nedan fungerar inte
        introBasePanel.setBackground(Color.decode("#8D9EFF"));


        /*        introBasePanel.setVisible(true);
        introBasePanel.setSize(800, 840);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("QuizKampen");*/

    }

    public JPanel getIntroScreen() {
        return introBasePanel;
    }
    }

// Main metoden existerar bara för debugging. Ta bort vid implementering
//    public static void main(String[] args) {
//        IntroScreen is = new IntroScreen();
//    }
//}
