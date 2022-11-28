package ClientSide;

import Resources.GameResults;
import ServerSide.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WaitScreen implements ActionListener {
    String category;
    int points;


    int playerOneTotalScore;
    int playerTwoTotalScore;

    /*
    * TODO: Hårdkoda in backgroundcolor på varenda jävla panel
    * */

    //INTROSCREEN
    JPanel waitScreenBasePanel = new JPanel();

    //Rad 1
    JPanel waitTextPanel = new JPanel();
    JLabel waitTextLabel = new JLabel("Waiting for the other players turn to end...", SwingConstants.CENTER);

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




    public WaitScreen(GameResults gameResults) {
        waitScreenBasePanel.setLayout(new GridLayout(8, 0));

        //rad 1
        waitScreenBasePanel.add(waitTextPanel);
        waitTextPanel.add(waitTextLabel, BorderLayout.CENTER);
        waitTextPanel.setBackground(Color.decode("#8D9EFF"));

        //rad 2
        waitScreenBasePanel.add(rowTwoBasePanel);
        rowTwoBasePanel.setLayout(new GridLayout(0, 3));
        rowTwoBasePanel.add(playerOnePanel);
        playerOnePanel.setBackground(Color.decode("#8D9EFF"));
        playerOnePanel.add(playerOneLabel);
        rowTwoBasePanel.add(totalScorePanel);
        totalScorePanel.add(totalScoreLabel);
        totalScorePanel.setBackground(Color.decode("#8D9EFF"));
        rowTwoBasePanel.add(playerTwoPanel);
        playerTwoPanel.add(playerTwoLabel);
        playerTwoPanel.setBackground(Color.decode("#8D9EFF"));

        //Rad 3
        waitScreenBasePanel.add(rowThreeBasePanel);
        //om texten inte hamnar åt sidorna, testa att sätta tre cols istället.
        rowThreeBasePanel.setLayout(new GridLayout(0, 3));
        rowThreeBasePanel.add(pointsPanelLeft); //, BorderLayout.WEST);
        pointsPanelLeft.add(pointsLabelLeft);
        pointsPanelLeft.setBackground(Color.decode("#8D9EFF"));
        rowThreeBasePanel.add(pointsPanelBlank);
        pointsPanelBlank.setBackground(Color.decode("#8D9EFF"));
        rowThreeBasePanel.add(pointsPanelRight);//, BorderLayout.EAST);
        pointsPanelRight.setBackground(Color.decode("#8D9EFF"));
        pointsPanelRight.add(pointsLabelRight);

        totalScoreLabel.setText(gameResults.playerOneTotalScore()+"     -     "+gameResults.playerTwoTotalScore());

        for (int i = 0; i < gameResults.getCategoryNames().size(); i++) {
            JPanel row = new JPanel();
            row.setBackground(Color.decode("#8D9EFF"));
            waitScreenBasePanel.add(row);

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
            JLabel categoryName = new JLabel(gameResults.getCategoryNames().get(i));

            JPanel pointsPanelLeft = new JPanel();
            pointsPanelLeft.setBackground(Color.decode("#8D9EFF"));
            JPanel categoryPanel = new JPanel();
            categoryPanel.setBackground(Color.decode("#8D9EFF"));
            JPanel pointsPanelRight = new JPanel();
            pointsPanelRight.setBackground(Color.decode("#8D9EFF"));


//TODO: Dra åt helvete
//            for(Component panel : row.getComponents()) {
//                panel.setBackground(Color.decode("#ADE792"));
//            }

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
        startNextRoundButton.addActionListener(this);


        waitScreenBasePanel.setBackground(Color.decode("#8D9EFF"));
        waitScreenBasePanel.setOpaque(true);
//        //Rad 4
//        waitScreenBasePanel.add(rowFourBasePanel);
//        rowFourBasePanel.setBackground(Color.decode("#8D9EFF"));
//        rowFourBasePanel.setLayout(new GridLayout(0, 3));
//        rowFourBasePanel.add(pointspanelLeftRoundOne);
//        pointspanelLeftRoundOne.add(pointsLabelLeftRoundOne);
//        rowFourBasePanel.add(categoryPanelRoundOne);
//        categoryPanelRoundOne.add(categoryLabelRoundOne);
//        rowFourBasePanel.add(pointsPanelRightRoundOne);
//        pointsPanelRightRoundOne.add(pointsLabelRightRoundOne);
//
//        //Rad 5
//        waitScreenBasePanel.add(rowFiveBasePanel);
//        rowFiveBasePanel.setBackground(Color.decode("#8D9EFF"));
//        rowFiveBasePanel.setLayout(new GridLayout(0, 3));
//        rowFiveBasePanel.add(pointspanelLeftRoundTwo);
//        pointspanelLeftRoundTwo.add(pointsLabelLeftRoundTwo);
//        rowFiveBasePanel.add(categoryPanelRoundTwo);
//        categoryPanelRoundTwo.add(categoryLabelRoundTwo);
//        rowFiveBasePanel.add(pointsPanelRightRoundTwo);
//        pointsPanelRightRoundTwo.add(pointsLabelRightRoundTwo);
//
//        //Rad 6
//        waitScreenBasePanel.add(rowSixBasePanel);
//        rowSixBasePanel.setBackground(Color.decode("#8D9EFF"));
//        rowSixBasePanel.setLayout(new GridLayout(0, 3));
//        rowSixBasePanel.add(pointspanelLeftRoundThree);
//        pointspanelLeftRoundThree.add(pointsLabelLeftRoundThree);
//        rowSixBasePanel.add(categoryPanelRoundThree);
//        categoryPanelRoundThree.add(categoryLabelRoundThree);
//        rowSixBasePanel.add(pointsPanelRightRoundThree);
//        pointsPanelRightRoundThree.add(pointsLabelRightRoundThree);
//
//        //Rad 7
//        waitScreenBasePanel.add(rowSevenBasePanel);
//        rowSevenBasePanel.setBackground(Color.decode("#8D9EFF"));
//        rowSevenBasePanel.setLayout(new GridLayout(0, 3));
//        rowSevenBasePanel.add(pointspanelLeftRoundFour);
//        pointspanelLeftRoundFour.add(pointsLabelLeftRoundFour);
//        rowSevenBasePanel.add(categoryPanelRoundFour);
//        categoryPanelRoundFour.add(categoryLabelRoundFour);
//        rowSevenBasePanel.add(pointsPanelRightRoundFour);
//        pointsPanelRightRoundFour.add(pointsLabelRightRoundFour);




        //För debugging
//        ClientGUI gui = new ClientGUI();
//        gui.setCurrentPanel(waitScreenBasePanel);
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
