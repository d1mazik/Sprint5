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

    }

    //Bind till properties
    int numberOfRounds;
    int roundCounter;
    int questionsAnswered = 0;
    // bind till action performed så att klienten skickar vilken kategori det ska vara.
    int amountOfQuestionsPerCategory = 2;
    int correctAnswerCounter;

    //TODO: SKAPA
    DAO dao = new DAO();

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
            return ServerListener.game.getShuffledCategoriesArray(3);
        }
        if (currentState == state.LOAD_CATEGORY_QUESTIONS) {
            currentCategory = (Category) inputFromServer;
            currentState = state.SEND_QUESTION;
            return "loadingQuestions";
        }
        if (currentState == state.WAIT) {
            //Gör inget
            return "wait";
        }
        if (currentState == state.SEND_QUESTION) {
            currentState = state.VALIDATE_ANSWER;
            return currentCategory.getQuestionPackage().get(0);
            //return dao.getQuestion(0, "vehicleQuestions");
        }
        if (currentState == state.VALIDATE_ANSWER) {
            currentState = state.SEND_QUESTION;
            //int answerIndex = (Integer)inputFromServer;
            QuestionsWithAnswers question = (QuestionsWithAnswers) dao.getQuestion(questionsAnswered, "vehicleQuestions");
            questionsAnswered++;
            System.out.println(question.getIndexOfCorrectAnswer());
            if(questionsAnswered == amountOfQuestionsPerCategory){
                currentState = state.WAIT;
                ServerListener.game.swapCurrentPlayer();
                //ServerListener.game.playerOne.protocol.setCurrentState(state.SEND_QUESTION);
                //ServerListener.game.playerOne.protocolNextStage();
            }
            return question.getIndexOfCorrectAnswer();
//            boolean isCorrect = dao.validateAnswer(currentQuestion, answerIndex, currentCategory);
//            System.out.println(isCorrect);
//            return isCorrect;
        }
        return null;
    }


    //    public String displayEnterNamePrompt(Object inputFromServer){
//        return "Enter your name: ";
//    }
}
