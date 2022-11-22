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
                playerTwo.protocol.setCurrentState(Protocol.state.INIT);
                playerOne.protocol.setCurrentState(Protocol.state.WAIT);
                playerOne.protocolNextStage();
                playerTwo.protocolNextStage();

                while (!isPlayerTwoDone()) {
                        System.out.println("Player two is not done");
                }

                System.out.println("Player Two is Done");
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
}
