package ClientSide;

import Resources.QuestionsWithAnswers;
import ServerSide.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChooseCategoryScreen implements ActionListener {
    JPanel categoryScreen = new JPanel();

    JLabel pickCategoryPrompt = new JLabel("Välj kategori för nästa rond: ");
    JButton startRoundButton = new JButton("Börja!");
    JButton categoryOne = new JButton("Category 1");
    JButton categoryTwo = new JButton("Category 2");
    JButton categoryThree = new JButton("Category 3");
    //    JButton categoryFour = new JButton("Category 4");
    List<JButton> categoryButtons = Arrays.asList(categoryOne, categoryTwo, categoryThree);

    //TODO: Implementera getCategoriesfunktion i QuestionsWithAnswers och ordna i DAO
    public ChooseCategoryScreen(QuestionsWithAnswers categories) {
        categoryScreen.setLayout(new GridLayout(5, 0));

        categoryScreen.add(pickCategoryPrompt);
        categoryScreen.add(startRoundButton);

        for (JButton button : categoryButtons) {
            categoryScreen.add(button);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button.setBackground(Color.decode("#8D9EFF"));
            button.addActionListener(this);
        }
        startRoundButton.addActionListener(this);
        startRoundButton.setVisible(false);

        loadCategories(categories);
    }

    // Eftersom att vi lägger allting i panels kan vi returnera hela paneler tillbaka till Client.
    public JPanel getCategoryScreen() {
        return categoryScreen;
    }

    public void loadCategories(QuestionsWithAnswers question) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
