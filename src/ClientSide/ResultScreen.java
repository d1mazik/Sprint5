package ClientSide;

import Resources.GameResults;
import ServerSide.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ResultScreen implements ActionListener {
    String category;
    int points;


    int playerOneTotalScore;
    int playerTwoTotalScore;

    int roundCounter = 1;

    /*
    * TODO: Hårdkoda in backgroundcolor på varenda jävla panel
    * */

    //INTROSCREEN
    JPanel waitScreenBasePanel = new JPanel();

    //Rad 1
    JPanel winnerTextPanel = new JPanel();

    //Rad 2
    JPanel rowTwoBasePanel = new JPanel();
    JPanel playerOnePanel = new JPanel();
    JLabel playerOneLabel = new JLabel("Spelare 1");
    JPanel totalScorePanel = new JPanel();
    JLabel totalScoreLabel = new JLabel("null - null");
    JPanel playerTwoPanel = new JPanel();
    JLabel playerTwoLabel = new JLabel("Spelare 2");

    //Rad 3
    JPanel rowThreeBasePanel = new JPanel();
    JPanel pointsPanelLeft = new JPanel();
    JPanel pointsPanelBlank = new JPanel();
    JPanel pointsPanelRight = new JPanel();
    JLabel pointsLabelLeft = new JLabel("Poäng");
    JLabel pointsLabelRight = new JLabel("Poäng");

    //Rad 4 - round one
    JPanel rowFourBasePanel = new JPanel();
    JPanel pointspanelLeftRoundOne = new JPanel();
    JLabel pointsLabelLeftRoundOne = new JLabel("-");
    JPanel categoryPanelRoundOne = new JPanel();
    //                                                    För test
    JLabel categoryLabelRoundOne = new JLabel( "Round 1" + "\n" + "SPORT");
    JPanel pointsPanelRightRoundOne = new JPanel();
    JLabel pointsLabelRightRoundOne = new JLabel("-");

    //Rad 5 - round two
    JPanel rowFiveBasePanel = new JPanel();
    JPanel pointspanelLeftRoundTwo = new JPanel();
    JLabel pointsLabelLeftRoundTwo = new JLabel("-");
    JPanel categoryPanelRoundTwo = new JPanel();
    JLabel categoryLabelRoundTwo = new JLabel( "Round 2" + "\n" + category);
    JPanel pointsPanelRightRoundTwo = new JPanel();
    JLabel pointsLabelRightRoundTwo = new JLabel("-");

    //Rad 6 - round three
    JPanel rowSixBasePanel = new JPanel();
    JPanel pointspanelLeftRoundThree = new JPanel();
    JLabel pointsLabelLeftRoundThree = new JLabel("-");
    JPanel categoryPanelRoundThree = new JPanel();
    JLabel categoryLabelRoundThree = new JLabel( "Round 3" + "\n" + category);
    JPanel pointsPanelRightRoundThree = new JPanel();
    JLabel pointsLabelRightRoundThree = new JLabel("-");

    //Rad 7 - round four
    JPanel rowSevenBasePanel = new JPanel();
    JPanel pointspanelLeftRoundFour = new JPanel();
    JLabel pointsLabelLeftRoundFour = new JLabel("-");
    JPanel categoryPanelRoundFour = new JPanel();
    JLabel categoryLabelRoundFour = new JLabel( "Round 4" + "\n" + category);
    JPanel pointsPanelRightRoundFour = new JPanel();
    JLabel pointsLabelRightRoundFour = new JLabel("-");

    //Start next round button
    JButton startNextRoundButton = new JButton("Påbörja nästa runda!");




    public ResultScreen(GameResults gameResults) {
        waitScreenBasePanel.setLayout(new GridLayout(8, 0));

        //rad 1
        waitScreenBasePanel.add(winnerTextPanel);
        winnerTextPanel.setBackground(Color.decode("#3B9AE1"));
        winnerTextPanel.setOpaque(true);

        //rad 2
        waitScreenBasePanel.add(rowTwoBasePanel);
        rowTwoBasePanel.setLayout(new GridLayout(0, 3));
        rowTwoBasePanel.add(playerOnePanel);
        playerOnePanel.setBackground(Color.decode("#3B9AE1"));
        playerOnePanel.setOpaque(true);
        playerOnePanel.add(playerOneLabel);
        rowTwoBasePanel.add(totalScorePanel);
        totalScorePanel.add(totalScoreLabel);
        totalScorePanel.setBackground(Color.decode("#3B9AE1"));
        totalScorePanel.setOpaque(true);
        rowTwoBasePanel.add(playerTwoPanel);
        playerTwoPanel.add(playerTwoLabel);
        playerTwoPanel.setBackground(Color.decode("#3B9AE1"));
        playerTwoPanel.setOpaque(true);

        //Rad 3
        waitScreenBasePanel.add(rowThreeBasePanel);
        rowThreeBasePanel.setLayout(new GridLayout(0, 3));
        rowThreeBasePanel.add(pointsPanelLeft);
        pointsPanelLeft.add(pointsLabelLeft);
        pointsPanelLeft.setBackground(Color.decode("#3B9AE1"));
        pointsPanelLeft.setOpaque(true);
        rowThreeBasePanel.add(pointsPanelBlank);
        pointsPanelBlank.setBackground(Color.decode("#3B9AE1"));
        pointsPanelBlank.setOpaque(true);
        rowThreeBasePanel.add(pointsPanelRight);
        pointsPanelRight.setBackground(Color.decode("#3B9AE1"));
        pointsPanelRight.setOpaque(true);
        pointsPanelRight.add(pointsLabelRight);

        totalScoreLabel.setText(gameResults.playerOneTotalScore()+"     -     "+gameResults.playerTwoTotalScore());

        for (int i = 0; i < gameResults.getCategoryNames().size(); i++) {
            JPanel row = new JPanel();
            row.setBackground(Color.decode("#3B9AE1"));
            waitScreenBasePanel.add(row);
            waitScreenBasePanel.setOpaque(true);

            JLabel playerOneScore = new JLabel();
            JLabel playerTwoScore = new JLabel();
            try {
                playerTwoScore.setText(String.valueOf(gameResults.getPlayerTwoScores().get(i)));
            } catch (IndexOutOfBoundsException e) {
                playerTwoScore.setText("-");
            }
            try {
                playerOneScore.setText(String.valueOf(gameResults.getPlayerOneScores().get(i)));
            } catch (IndexOutOfBoundsException e) {
                playerOneScore.setText("-");
            }
            JLabel categoryName = new JLabel("Runda: " + roundCounter + " " + gameResults.getCategoryNames().get(i));
            roundCounter++;

            JPanel pointsPanelLeft = new JPanel();
            pointsPanelLeft.setBackground(Color.decode("#3B9AE1"));
            pointsPanelLeft.setOpaque(true);
            JPanel categoryPanel = new JPanel();
            categoryPanel.setBackground(Color.decode("#3B9AE1"));
            categoryPanel.setOpaque(true);
            JPanel pointsPanelRight = new JPanel();
            pointsPanelRight.setBackground(Color.decode("#3B9AE1"));
            pointsPanelRight.setOpaque(true);


            row.setLayout(new GridLayout(0, 3));
            row.add(pointsPanelLeft);
            pointsPanelLeft.add(playerOneScore);
            row.add(categoryPanel);
            categoryPanel.add(categoryName);
            row.add(pointsPanelRight);
            pointsPanelRight.add(playerTwoScore);

        }

        waitScreenBasePanel.add(startNextRoundButton);
        startNextRoundButton.setBackground(Color.decode("#ADE792"));
        startNextRoundButton.setOpaque(true);
        startNextRoundButton.addActionListener(this);
        startNextRoundButton.setVisible(false);


        waitScreenBasePanel.setBackground(Color.decode("#3B9AE1"));
        waitScreenBasePanel.setOpaque(true);


        if (gameResults.getGameOver()) {
            String winner = "Oavgjort!";
            if (gameResults.playerOneTotalScore() > gameResults.playerTwoTotalScore()) {
                winner = "Spelare 1 vann!";
            } else if (gameResults.playerTwoTotalScore() > gameResults.playerOneTotalScore()) {
                winner = "Spelare 2 vann!";
            }
            JOptionPane.showMessageDialog(null, winner);
        }
    }

    

    public void enableStartNextRoundButton() {
        startNextRoundButton.setEnabled(true);
        startNextRoundButton.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(startNextRoundButton)) {
            //Lägg till funktionalitet för att den INTE ska kunna gå att trycka på innan man har svarat på frågan.
            try {
                Client.oos.writeObject(new Response());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return;
        }
    }

    public JPanel getWaitScreen() {
        return waitScreenBasePanel;
    }

    //För debugging
//    public static void main(String[] args) {
//        WaitScreen ws = new WaitScreen();
//    }
}
