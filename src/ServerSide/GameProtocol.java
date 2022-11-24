package ServerSide;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;

public class GameProtocol {

    private enum state {
        WAITING_FOR_PLAYERS,
        START_GAME,
        SEND_CATEGORIES,
        SEND_QUESTIONS,
        RECEIVE_ANSWERS,
        SWAP_PLAYER,
    }

    DAO database = new DAO();

    ServerSidePlayer player1, player2;
    ServerSidePlayer currentPlayer, notCurrentPlayer;
    state currentState = state.WAITING_FOR_PLAYERS;
    Category currentCategory;

    public void receive(Object fromUser) {
        if (fromUser instanceof Category chosenCategory) {
            //RECEIVE CATEGORIES
            this.currentCategory = chosenCategory;
        }

        try {
            processState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPlayer1(ServerSidePlayer player1) throws IOException {
        this.player1 = player1;
        player1.start();
    }

    public void setPlayer2(ServerSidePlayer player2) throws IOException {
        this.player2 = player2;
        player2.start();
    }

    public void processState() throws IOException {
        if (currentState == state.WAITING_FOR_PLAYERS) {
            waitForPlayers();
            //waitForPlayers();
        } else if (currentState == state.START_GAME) {
            startGame();
        } else if (currentState == state.SEND_CATEGORIES) {
            sendCategories();
        }
    }

    private void waitForPlayers() throws IOException {
        System.out.println("Entered waitForPlayers");
        if (player1 == null) {
            System.out.println("Player one is null");
            return;
        }
        System.out.println("Sent: 'waitForPlayers'");
        player1.oos.writeObject("waitForPlayers");
        if (player2 == null) {
            return;
        }
        player2.oos.writeObject("waitForPlayers");
        System.out.println("SENT WAIT FOR PLAYERS");
        currentState = state.START_GAME;
    }

    private void startGame(){
        currentPlayer = player1;
        notCurrentPlayer = player2;
    }

    private void sendCategories() throws IOException {
        List<Category> categoryList = database.categories;
        Collections.shuffle(categoryList);

        Category[] randomCategories = new Category[3];
        for (int i = 0; i < 3; i++) {
            randomCategories[i] = categoryList.get(i);
        }

        currentPlayer.oos.writeObject(randomCategories);
        notCurrentPlayer.oos.writeObject("wait");
    }
}
