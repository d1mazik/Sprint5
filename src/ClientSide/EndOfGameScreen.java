package ClientSide;

import javax.swing.*;
import java.awt.*;

public class EndOfGameScreen {

    int playerOneScore;
    int playerTwoScore;
    String winner;

    JPanel endOfGameBasePanel = new JPanel(new GridLayout(3,0));

    JPanel northPanel = new JPanel();
    JLabel northLabel = new JLabel("Resultat");
    JPanel centerPanel = new JPanel(new GridLayout(0,2));
    JPanel centerLeftPanel = new JPanel();

    JPanel centerRightPanel = new JPanel();
    JPanel southPanel = new JPanel();


    public EndOfGameScreen(int playerOneScore, int playerTwoScore){
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;

        JLabel centerLeftLabel = new JLabel("Player One: " + playerOneScore);
        JLabel centerRightLabel = new JLabel("Player Two: " + playerTwoScore);

        endOfGameBasePanel.setBackground(Color.decode("#8D9EFF"));

        endOfGameBasePanel.add(northPanel);
        northPanel.setLayout(new GridBagLayout());
        northPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        northPanel.add(northLabel);
        endOfGameBasePanel.add(centerPanel);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerPanel.add(centerLeftPanel);
        centerLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerLeftPanel.setLayout(new GridBagLayout());
        centerPanel.add(centerRightPanel);
        centerLeftPanel.add(centerLeftLabel);
        centerRightPanel.add(centerRightLabel);
        centerRightPanel.setLayout(new GridBagLayout());

        endOfGameBasePanel.add(southPanel);
        southPanel.add(southLabel);
        southPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        southPanel.setLayout(new GridBagLayout());



    }



    // Eftersom att vi lägger allting i panels kan vi returnera hela paneler tillbaka till Client.
    public JPanel getEndOfGameBasePanel() {
        return endOfGameBasePanel;
    }
}
