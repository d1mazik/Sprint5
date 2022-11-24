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
        waitBasePanel.setOpaque(true);

    }

    public JPanel getWaitScreen() {
        return waitBasePanel;
    }
    }
