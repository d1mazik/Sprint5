package Resources;

import ServerSide.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameResults implements Serializable {
    List<Integer> playerOneScores = new ArrayList<>();
    List<Integer> playerTwoScores = new ArrayList<>();
    List<String> categoryNames = new ArrayList<>();

    private int getCategoryIndex(String categoryName) {
        System.out.println("Categories" + categoryNames.toString());
        int categoryIndex = -1;

        for (int i = 0; i < categoryNames.size(); i++) {
            String existingCategory = categoryNames.get(i);
            if (categoryName.equals(existingCategory)) {
                categoryIndex = i;
            }
        }

        if (categoryIndex == -1) {
            categoryNames.add(categoryName);
            categoryIndex = categoryNames.size() - 1;
        }
        return categoryIndex;
    }

    public List<Integer> getPlayerOneScores() {
        return playerOneScores;
    }

    public List<Integer> getPlayerTwoScores() {
        return playerTwoScores;
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public int playerOneTotalScore() {
        int totalScore = 0;
        for (Integer score : playerOneScores) {
            totalScore += score;
        }
        return totalScore;
    }

    public int playerTwoTotalScore() {
        int totalScore = 0;
        for (Integer score : playerTwoScores) {
            totalScore += score;
        }
        return totalScore;
    }

    public void addPlayerOneResult(String categoryName, int score) {
        int categoryIndex = getCategoryIndex(categoryName);
        playerOneScores.add(categoryIndex, score);
        System.out.println("Player One Results" + playerOneScores.toString());
    }

    public void addPlayerTwoResult(String categoryName, int score) {
        int categoryIndex = getCategoryIndex(categoryName);
        playerTwoScores.add(categoryIndex, score);
        System.out.println("Player Two Results" + playerTwoScores.toString());
    }
}
