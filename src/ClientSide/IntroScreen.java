package ClientSide;

import javax.swing.*;
import java.awt.*;

public class IntroScreen extends JFrame {

    //INTROSCREEN
//    JPanel introBasePanel = new JPanel();
    JLabel introTitelLabel = new JLabel("Quizkampen",SwingConstants.CENTER);
    JLabel introTextLabel = new JLabel("Waiting for another player to connect...",SwingConstants.CENTER);

    public IntroScreen() {

        Container cp = this.getContentPane();


        this.add(introTitelLabel, BorderLayout.NORTH);
        this.add(introTextLabel, BorderLayout.CENTER);
        setBackground(Color.decode("#8D9EFF"));

        this.setVisible(true);
        this.setSize(800, 840);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("QuizKampen");

    }

    public static void main(String[] args) {
        IntroScreen is = new IntroScreen();
    }
}
