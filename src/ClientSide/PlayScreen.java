package ClientSide;

import Resources.QuestionPackage;
import ServerSide.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PlayScreen implements ActionListener {
    JPanel playScreen = new JPanel();
    //Main panels
    JPanel northMainPanel = new JPanel();
    JPanel southMainPanel = new JPanel();


    //Northmain
    JPanel scoreCounterPanel = new JPanel();
    JPanel questionPanel = new JPanel();

    JLabel questionLabel = new JLabel("Test");
    // countdown bar
    JPanel countDownPanel = new JPanel();
    JLabel countDown = new JLabel("...Placeholder countdown...");
    JButton nextQuestionButton = new JButton("Nästa fråga");


    //Southmain
    JButton answerButtonOne = new JButton("Test1");
    JButton answerButtonTwo = new JButton("Test2");
    JButton answerButtonThree = new JButton("Test3");
    JButton answerButtonFour = new JButton("Test4");

    List<JButton> buttons = Arrays.asList(answerButtonOne, answerButtonTwo, answerButtonThree, answerButtonFour);

    public JPanel getPlayScreen() {
        return playScreen;
    }

    public PlayScreen(QuestionPackage question) {
        playScreen.setLayout(new GridLayout(2, 0));

        playScreen.add(northMainPanel);
        playScreen.add(southMainPanel);
        southMainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        southMainPanel.setOpaque(true);

        northMainPanel.setLayout(new GridLayout(4, 0));
        northMainPanel.add(scoreCounterPanel);
        northMainPanel.add(questionPanel);
        questionPanel.add(questionLabel);
        questionPanel.setBackground(Color.decode("#EEF2E6"));
        questionPanel.setOpaque(true);
        questionLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        northMainPanel.add(countDownPanel);
        countDownPanel.add(countDown, BorderLayout.SOUTH);
        northMainPanel.add(nextQuestionButton);

        southMainPanel.setLayout(new GridLayout(2, 2));

        for (JButton button : buttons) {
            southMainPanel.add(button);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button.setBackground(Color.decode("#3B9AE1"));
            button.setFont(new Font("Serif", Font.PLAIN, 20));
            button.setOpaque(true);
            button.addActionListener(this);
        }
        nextQuestionButton.addActionListener(this);
        nextQuestionButton.setVisible(false);

        loadQuestion(question);
    }

    public void loadQuestion(QuestionPackage question) {
        questionLabel.setText(question.getQuestion());
        String[] alternatives = question.getAnswerAlternatives();

        answerButtonOne.setText(alternatives[0]);
        answerButtonTwo.setText(alternatives[1]);
        answerButtonThree.setText(alternatives[2]);
        answerButtonFour.setText(alternatives[3]);
    }

    public Integer getSelectedAnswerIndex(JButton selectedButton) {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).equals(selectedButton)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nextQuestionButton)) {
            try {
                Client.oos.writeObject(new Response());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return;
        }

        int selectedAnswerIndex = getSelectedAnswerIndex((JButton) e.getSource());
        System.out.println("Selected Answer: " + selectedAnswerIndex);
        buttons.get(selectedAnswerIndex).setBackground(Color.decode("#EB1D36"));
        buttons.get(selectedAnswerIndex).setOpaque(true);
        nextQuestionButton.setVisible(true);

        for (JButton button : buttons){
            button.setEnabled(false);
        }

        try {
            Client.oos.writeObject(selectedAnswerIndex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void revealAnswer(int answerIndex) {

        buttons.get(answerIndex).setBackground(Color.decode("#ADE792"));
        buttons.get(answerIndex).setOpaque(true);
    }
}
