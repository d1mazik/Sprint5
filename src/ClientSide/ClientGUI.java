package ClientSide;

import javax.swing.*;

// Kallas på för att skapa upp nya skärmar i spelets respektive steg.
// Den tar bort föregående skärm och ersätter den med en ny, utifrån klientens instruktioner.
public class ClientGUI extends JFrame {
    private JPanel currentPanel = new JPanel();

    ClientGUI() {
        this.add(currentPanel);
        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("QuizKampen");
    }

    public void setCurrentPanel(JPanel panel) {
        this.remove(currentPanel);
        currentPanel = panel;
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
    }
}
