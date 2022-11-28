package ClientSide;

import ServerSide.Category;
import ServerSide.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ChooseCategoryScreen implements ActionListener {
    JPanel categoryScreen = new JPanel();
    JPanel pickCategoryPanel = new JPanel();

    JLabel pickCategoryPrompt = new JLabel("Välj kategori för nästa rond: ");
//    JButton startRoundButton = new JButton("Påbörja runda");
    JButton categoryOne = new JButton("Category 1");
    JButton categoryTwo = new JButton("Category 2");
    JButton categoryThree = new JButton("Category 3");
    List<JButton> categoryButtons = Arrays.asList(categoryOne, categoryTwo, categoryThree);
    Category[] categories;

    //TODO: Implementera getCategoriesfunktion i QuestionsWithAnswers och ordna i DAO
    public ChooseCategoryScreen(Category[] categories) {
        categoryScreen.setLayout(new GridLayout(5, 0));

        categoryScreen.add(pickCategoryPanel);
        pickCategoryPanel.setLayout(new GridBagLayout());
        pickCategoryPanel.add(pickCategoryPrompt);
        pickCategoryPanel.setBackground(Color.decode("#8D9EFF"));

        categoryScreen.setBackground(Color.decode("#8D9EFF"));
//        categoryScreen.add(startRoundButton);
//        startRoundButton.addActionListener(this);
//        startRoundButton.setEnabled(false);

        for (JButton button : categoryButtons) {
            categoryScreen.add(button);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button.setBackground(Color.decode("#8D9EFF"));
            button.addActionListener(this);
            button.setOpaque(true); //för att kunna se färg(Mac)
        }

        this.categories = categories;
        loadCategories(categories);
    }

    // Eftersom att vi lägger allting i panels kan vi returnera hela paneler tillbaka till Client.
    public JPanel getCategoryScreen() {
        return categoryScreen;
    }

    public void loadCategories(Category[] categories) {

        for (int i = 0; i < categories.length; i++) {
            categoryButtons.get(i).setText(categories[i].getName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(startRoundButton)) {
//            try {
//                Client.oos.writeObject(new Response());
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//            return;
//        }
//
//        startRoundButton.setEnabled(true);

        Category chosenCategory = null;
        JButton buttonSelected = (JButton) e.getSource();
        for (int i = 0; i < categoryButtons.size(); i++) {
            if (buttonSelected.getText().equals(categories[i].getName())) {
                chosenCategory = categories[i];
                buttonSelected.setBackground(Color.blue);
                buttonSelected.setOpaque(true); // för att kunna se färgen(Mac)
            }
            categoryButtons.get(i).setEnabled(false);
        }
        try {
            Client.oos.writeObject(chosenCategory);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
