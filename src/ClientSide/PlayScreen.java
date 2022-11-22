package ClientSide;

import Resources.QuestionsWithAnswers;
import ServerSide.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PlayScreen extends JFrame implements ActionListener {
    //Main panels
    JPanel northMainPanel = new JPanel();
    JPanel southMainPanel = new JPanel();


    //Northmain
    JPanel scoreCounterPanel = new JPanel();
    JPanel questionPanel = new JPanel();

    JLabel questionLabel = new JLabel("Skiter björnen i skogen?");
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

    public PlayScreen(QuestionsWithAnswers question) {

//        Container cp = this.getContentPane();

        setLayout(new GridLayout(2, 0));

        add(northMainPanel);
        add(southMainPanel);
        southMainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        northMainPanel.setLayout(new GridLayout(4, 0));
        northMainPanel.add(scoreCounterPanel);
        northMainPanel.add(questionPanel);
        questionPanel.add(questionLabel);
        northMainPanel.add(countDownPanel);
        countDownPanel.add(countDown, BorderLayout.SOUTH);
        northMainPanel.add(nextQuestionButton);

        southMainPanel.setLayout(new GridLayout(2, 2));

        for (JButton button : buttons) {
            southMainPanel.add(button);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button.setBackground(Color.decode("#8D9EFF"));
            button.addActionListener(this);
        }

        //southMainPanel.add(answerButtonOne);
        //answerButtonOne.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //answerButtonOne.setBackground(Color.decode("#8D9EFF"));
        //southMainPanel.add(answerButtonTwo);
        //answerButtonTwo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //answerButtonTwo.setBackground(Color.decode("#8D9EFF"));
        //southMainPanel.add(answerButtonThree);
        //answerButtonThree.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //answerButtonThree.setBackground(Color.decode("#8D9EFF"));
        //southMainPanel.add(answerButtonFour);
        //answerButtonFour.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //answerButtonFour.setBackground(Color.decode("#8D9EFF"));


        this.setVisible(true);
        this.setSize(800, 839);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("QuizKampen");

        loadQuestion(question);
    }

    public void loadQuestion(QuestionsWithAnswers question) {
        questionLabel.setText(question.getQuestion());
        String[] alternatives = question.getAnswerAlternatives();

        answerButtonOne.setText(alternatives[0]);
        answerButtonTwo.setText(alternatives[1]);
        answerButtonThree.setText(alternatives[2]);
        answerButtonFour.setText(alternatives[3]);
    }

    public int getSelectedAnswerIndex(JButton selectedButton){
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
            //Lägg till funktionalitet för att den INTE ska kunna gå att trycka på innan man har svarat på frågan.
            try {
                Client.oos.writeObject(new Response());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return;
        }

        int selectedAnswerIndex = getSelectedAnswerIndex((JButton) e.getSource());
        System.out.println("Selected Answer: " + selectedAnswerIndex);
        buttons.get(selectedAnswerIndex).setBackground(Color.red);

        try {
            Client.oos.writeObject(selectedAnswerIndex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void revealAnswer(int answerIndex) {
        buttons.get(answerIndex).setBackground(Color.green);
    }
}
