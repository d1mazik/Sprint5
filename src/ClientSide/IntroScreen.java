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
        introBasePanel.setOpaque(true);//för att kunna se färgen(Mac)
    }

    // Eftersom att vi lägger allting i panels kan vi returnera hela paneler tillbaka till Client.
    public JPanel getIntroScreen() {
        return introBasePanel;
    }
    }