package ServerSide;

import Resources.QuestionsWithAnswers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Protocol {
    //Protocolklassen kommer att användas för att hantera logiken i spelet och dela in det i olika sekvenser.
    enum state{
        // waiting ansvarar för att connection upprättas mellan två spelare INNAN spelet påbörjas
        INIT,
        CHOOSE_CATEGORY,
        LOAD_CATEGORY_QUESTIONS,
        SEND_QUESTION,
        WAIT,
        VALIDATE_ANSWER,
        END_GAME
    }

    Game game;
    //Bind till properties
    int numberOfRounds;
    int roundCounter;
    int questionsAnswered = 0;
    // bind till action performed så att klienten skickar vilken kategori det ska vara.
    int amountOfQuestionsPerCategory = 2;
    int correctAnswerCounter;

    Protocol(int gameIndexInList) {
        //game = ServerListener.games.get(gameIndexInList);
    }

    private state currentState = state.INIT;
    public void setCurrentState(state state) {
        this.currentState = state;
    }
    public state getCurrentState() {
        return this.currentState;
    }

    public Object processStage(Object inputFromServer) throws IOException {
        if (currentState == state.INIT) {
            currentState = state.CHOOSE_CATEGORY;
            return new Initiator();
           // displayEnterNamePrompt(inputFromServer);
        }
        if (currentState == state.CHOOSE_CATEGORY) {
            currentState = state.LOAD_CATEGORY_QUESTIONS;
            return game.getShuffledCategoriesArray(3);
        }
        if (currentState == state.LOAD_CATEGORY_QUESTIONS) {
            currentState = state.SEND_QUESTION;
            game.currentCategory = (Category) inputFromServer;
            return "loadingQuestions";
        }
        if (currentState == state.WAIT) {
            //Gör inget
            return "wait";
        }
        if (currentState == state.SEND_QUESTION) {
            currentState = state.VALIDATE_ANSWER;
            return game.currentCategory.getQuestionPackage().get(questionsAnswered);
            //return dao.getQuestion(0, "vehicleQuestions");
        }
        if (currentState == state.VALIDATE_ANSWER) {
            currentState = state.SEND_QUESTION;
            int answerIndex = (Integer)inputFromServer;
            QuestionsWithAnswers question = game.currentCategory.getQuestionPackage().get(questionsAnswered);
            if (answerIndex == question.getIndexOfCorrectAnswer()) {
                game.increaseScoreForCurrentPlayer();
            }
            questionsAnswered++;
            System.out.println(question.getIndexOfCorrectAnswer());
            if(questionsAnswered == 2){
                game.incrementTotalRoundsPlayed();
                questionsAnswered = 0;
                currentState = state.WAIT;
                game.swapCurrentPlayer();
                //AVSLUTA SPELET OM BÅDA SPELARNA ÄR KLARA
                if (game.totalRoundsPlayed == 2) {
                    game.endGame();
                }
            }
            return question.getIndexOfCorrectAnswer();

        }
        if (currentState == state.END_GAME) {
            return game.getFinalScores();
        }
        return null;
    }


    //    public String displayEnterNamePrompt(Object inputFromServer){
//        return "Enter your name: ";
//    }
}
