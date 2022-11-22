package ServerSide;

import Resources.QuestionsWithAnswers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Protocol {
    //Protocolklassen kommer att användas för att hantera logiken i spelet och dela in det i olika sekvenser.
    private enum state{
        // waiting ansvarar för att connection upprättas mellan två spelare INNAN spelet påbörjas
        INIT,
        SEND_QUESTION,
        VALIDATE_ANSWER,
    }

    //Bind till properties
    int numberOfRounds;
    int roundCounter;
    int currentQuestion;
    // bind till action performed så att klienten skickar vilken kategori det ska vara.
    String currentCategory = "vehicleQuestions";

    //TODO: SKAPA
    DAO dao = new DAO();

    private state currentState = state.INIT;

    public Object processStage(Object inputFromServer){
        if (currentState == state.INIT) {
            currentState = state.SEND_QUESTION;
            return new Initiator();
           // displayEnterNamePrompt(inputFromServer);
        }
        if (currentState == state.SEND_QUESTION) {
            currentState = state.VALIDATE_ANSWER;
            return dao.getQuestion(currentQuestion, currentCategory);
        }
        if (currentState == state.VALIDATE_ANSWER) {
            currentState = state.SEND_QUESTION;
            int answerIndex = (Integer)inputFromServer;
            QuestionsWithAnswers question = (QuestionsWithAnswers) dao.getQuestion(currentQuestion, "vehicleQuestions");
            currentQuestion++;
            System.out.println(question.getIndexOfCorrectAnswer());
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
