package Resources;

import java.io.Serializable;


//Klassen är till för att kunna skapa upp hela objekt av frågor och svar som vi sedan kan skicka genom ObjeckIOstreams.
//Objekten skapas upp i klassen QuestionsAnswersList
public class QuestionsWithAnswers implements Serializable {
    private String question;
    private String[] answerAlternatives = new String[4];
    private int indexOfCorrectAnswer;


    public QuestionsWithAnswers(String question, String[] answerAlternatives, int indexOfCorrectAnswer) {
        this.question = question;
        this.answerAlternatives = answerAlternatives;
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswerAlternatives() {
        return answerAlternatives;
    }


    public int getIndexOfCorrectAnswer() {
        return indexOfCorrectAnswer;
    }

    public void setIndexOfCorrectAnswer(int indexOfCorrectAnswer) {
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
    }


    //TODO enum category

}