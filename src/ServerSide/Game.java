//package ServerSide;
//
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Game {
//
//    DAO dao = new DAO();
//
//    List<Category> categories = dao.categories;
//    Category animalPackageOne = dao.getPackage(1);
//    Category vehiclePackageOne = dao.getPackage(0);
//    ServerSidePlayer playerOne, playerTwo;
//    ServerSidePlayer currentPlayer;
//    int playerOneCorrectAnswers;
//    int playerTwoCorrectAnswers;
//
//    Category currentCategory;
//
//    int playerOneRoundsPlayed;
//    int playerTwoRoundsPlayed;
//
//    int totalRoundsPlayed;
//
//    int numberOfAllowedRounds;
//
//
//    int currentRound;
//    int scoreCounter;
//
//    public void incrementTotalRoundsPlayed(){
//        totalRoundsPlayed++;
//        System.out.println("Rounds played: " + totalRoundsPlayed);
//    }
//
//    public int[] getFinalScores(){
//        return new int[]{playerOneCorrectAnswers, playerTwoCorrectAnswers};
//    }
//
//    public void increaseScoreForCurrentPlayer() {
//        if (currentPlayer.equals(playerOne)) {
//            playerOneCorrectAnswers++;
//        } else if (currentPlayer.equals(playerTwo)) {
//            playerTwoCorrectAnswers++;
//        }
//        System.out.println("Spelare 1: " + playerOneCorrectAnswers);
//        System.out.println("Spelare 2: " + playerTwoCorrectAnswers);
//    }
//
//    public Game(ServerSidePlayer playerOne, ServerSidePlayer playerTwo) {
//        this.playerOne = playerOne;
//        this.playerTwo = playerTwo;
//        this.setCurrentPlayer(playerOne);
//    }
//
//    public void initPlayerOneFirstRound() throws IOException {
//        currentPlayer = playerTwo;
//        playerTwo.protocol.setCurrentState(Protocol.state.CHOOSE_CATEGORY);
//        playerOne.protocol.setCurrentState(Protocol.state.WAIT);
////        playerOne.protocolNextStage();
//    }
//
//    public void endGame() throws IOException {
//        playerOne.protocol.setCurrentState(Protocol.state.END_GAME);
//        playerTwo.protocol.setCurrentState(Protocol.state.END_GAME);
////        playerOne.protocolNextStage();
////        playerTwo.protocolNextStage();
//    }
//
//    public boolean isPlayerTwoDone() {
//        return playerTwo.protocol.getCurrentState().equals(Protocol.state.WAIT);
//    }
//
//    public void setCurrentPlayer(ServerSidePlayer currentPlayer) {
//        this.currentPlayer = currentPlayer;
//    }
//
//    public Category getAnimalPackage(){
//        return animalPackageOne;
//    }
//
//    public Category getVehiclePackageOne(){
//        return vehiclePackageOne;
//    }
//
//    public Category[] getShuffledCategoriesArray(int size){
//        Collections.shuffle(categories);
//        Category[] shuffledCategories = new Category[size];
//        for (int i = 0; i < size; i++) {
//            shuffledCategories[i] = categories.get(i);
//        }
//        return shuffledCategories;
//    }
//
//    public void setCurrentRound(){
//
//    }
//
//    public void getPlayerScore(){
//
//    }
//
//    public void setTotalResult(){
//
//    }
//
//    public void generateWinScreenData(){
//
//    }
//
//    public void addPlayer(ServerSidePlayer playerOne) {
//    }
//
//    public void swapCurrentPlayer() throws IOException {
//        currentPlayer.protocol.setCurrentState(Protocol.state.WAIT);
//
//        if (currentPlayer.equals(playerOne)) {
//            currentPlayer = playerTwo;
//        } else {
//            currentPlayer = playerOne;
//        }
//
//        currentPlayer.protocol.setCurrentState(Protocol.state.SEND_QUESTION);
////        currentPlayer.protocolNextStage();
//    }
//}
