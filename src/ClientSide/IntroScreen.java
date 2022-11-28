package ClientSide;

import javax.swing.*;
import java.awt.*;

public class IntroScreen {

    //INTROSCREEN
    JPanel introBasePanel = new JPanel();
    JLabel introTextLabel = new JLabel("Väntar på att en annan spelare ansluter...",SwingConstants.CENTER);

    public IntroScreen() {

        introBasePanel.setLayout(new GridBagLayout());
        introBasePanel.add(introTextLabel);
        introTextLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        introBasePanel.setBackground(Color.decode("#3B9AE1"));
        introBasePanel.setOpaque(true);//för att kunna se färgen(Mac)
    }

    // Eftersom att vi lägger allting i panels kan vi returnera hela paneler tillbaka till Client.
    public JPanel getIntroScreen() {
        return introBasePanel;
    }
    }