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

    public ChooseCategoryScreen(Category[] categories) {
        categoryScreen.setLayout(new GridLayout(4, 0));

        categoryScreen.add(pickCategoryPanel);
        pickCategoryPanel.setLayout(new GridBagLayout());
        pickCategoryPrompt.setFont(new Font("Serif", Font.PLAIN, 20));
        pickCategoryPanel.add(pickCategoryPrompt);
        pickCategoryPanel.setBackground(Color.decode("#EEF2E6"));
        pickCategoryPanel.setOpaque(true);

        categoryScreen.setBackground(Color.decode("#3B9AE1"));
        categoryScreen.setOpaque(true);
//        categoryScreen.add(startRoundButton);
//        startRoundButton.addActionListener(this);
//        startRoundButton.setEnabled(false);

        for (JButton button : categoryButtons) {
            categoryScreen.add(button);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button.setBackground(Color.decode("#3B9AE1"));
            button.setFont(new Font("Serif", Font.PLAIN, 20));
            button.addActionListener(this);
            button.setOpaque(true);
        }

        this.categories = categories;
        loadCategories(categories);
    }
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
                buttonSelected.setOpaque(true);
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
