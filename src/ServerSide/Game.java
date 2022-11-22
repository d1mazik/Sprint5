package ServerSide;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class Game {

    DAO dao = new DAO();
    ServerSidePlayer playerOne, playerTwo;
    ServerSidePlayer currentPlayer;

    int currentRound;
    int scoreCounter;

    public Game(ServerSidePlayer playerOne, ServerSidePlayer playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.setCurrentPlayer(playerOne);
    }

    public void initPlayerOneFirstRound() throws IOException {
        currentPlayer = playerTwo;
        playerTwo.protocol.setCurrentState(Protocol.state.INIT);
        playerOne.protocol.setCurrentState(Protocol.state.WAIT);
        playerOne.protocolNextStage();
        playerTwo.protocolNextStage();
    }

    public boolean isPlayerTwoDone() {
        return playerTwo.protocol.getCurrentState().equals(Protocol.state.WAIT);
    }

    public void setCurrentPlayer(ServerSidePlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setCurrentRound(){

    }

    public void getPlayerScore(){

    }

    public void setTotalResult(){

    }

    public void generateWinScreenData(){

    }

    public void addPlayer(ServerSidePlayer playerOne) {
    }

    public void swapCurrentPlayer() throws IOException {
        currentPlayer.protocol.setCurrentState(Protocol.state.WAIT);

        if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }

        currentPlayer.protocol.setCurrentState(Protocol.state.SEND_QUESTION);
        currentPlayer.protocolNextStage();
    }
}
