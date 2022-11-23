package ClientSide;

import javax.swing.*;
import java.awt.*;

public class EndOfGameScreen {

    int playerOneScore;
    int playerTwoScore;
    String player;

    JPanel endOfGameBasePanel = new JPanel(new GridLayout(3,0));

    JPanel northPanel = new JPanel();
    JLabel northLabel = new JLabel();
    JPanel centerPanel = new JPanel(new GridLayout(0,2));
    JPanel centerLeftPanel = new JPanel();

    JPanel centerRightPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JLabel southLabel = new JLabel(player + " wins!!!");


    public EndOfGameScreen(int playerOneScore, int playerTwoScore){
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;

        JLabel centerLeftLabel = new JLabel("Player One: " + playerOneScore);
        JLabel centerRightLabel = new JLabel("Player Two: " + playerTwoScore);

        endOfGameBasePanel.add(northPanel);
        northPanel.add(northLabel);
        endOfGameBasePanel.add(centerPanel);
        centerPanel.add(centerLeftPanel);
        centerPanel.add(centerRightPanel);
        centerLeftPanel.add(centerLeftLabel);
        centerRightPanel.add(centerRightLabel);

        endOfGameBasePanel.add(southPanel);
        southPanel.add(southLabel);

        endOfGameBasePanel.setBackground(Color.decode("#8D9EFF"));
    }

    // Eftersom att vi lägger allting i panels kan vi returnera hela paneler tillbaka till Client.
    public JPanel getEndOfGameBasePanel() {
        return endOfGameBasePanel;
    }
}
