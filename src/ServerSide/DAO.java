package ServerSide;

import Resources.QuestionsWithAnswers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAO {
    List<QuestionsWithAnswers> vehicleQuestions = new ArrayList<>();

    List<QuestionsWithAnswers> animalQuestions = new ArrayList<>();

    public void generateQuestionList() {
        String[] alternatives1 = {"1", "2", "3", "4"};
        QuestionsWithAnswers question = new QuestionsWithAnswers("Hur många däck brukar en bil ha?", alternatives1,3);
        this.vehicleQuestions.add(question);

        String[] alternatives2 = {"Datormöss", "Flygplan", "Torktumlare", "Godis"};
        question = new QuestionsWithAnswers("Vad tillverkar Airbus?", alternatives2, 1);
        this.vehicleQuestions.add(question);

        String[] alternatives3 = {"Bondkatt", "Norsk skogskatt", "Råttor", "Siamesiska kattråttor"};
        question = new QuestionsWithAnswers("Vilken är den vanligaste kattrasen?", alternatives3,0);
        this.animalQuestions.add(question);

        String[] alternatives4 = {"quack quack","muuuuu","voff voff", "vrooooom"};
        question = new QuestionsWithAnswers("Hur låter en ko?",alternatives4,1);
        this.animalQuestions.add(question);
    }
    
    public DAO(){
        this.generateQuestionList();


    }

//    public List<QuestionsWithAnswers> getQuestionCategoryIdentifier(String identifier,List<QuestionsWithAnswers> list){
//        if (identifier.equals(list))
//    }


// Är tänkt att användas för poängräkning. 
    public boolean validateAnswer(int indexOfQuestion, int indexOfAnswer, String identifier) {
        if (identifier.equals("vehicleQuestions")) {
            return indexOfAnswer == vehicleQuestions.get(indexOfQuestion).getIndexOfCorrectAnswer();
        }
        return indexOfAnswer == animalQuestions.get(indexOfQuestion).getIndexOfCorrectAnswer();
    }


    // FIXME: 2022-11-21 KATEGORI HÅRDKODAT
    public Object getQuestion(int index, String identifier) {
        if (identifier.equals("vehicleQuestions")) {
            return vehicleQuestions.get(index);
        }
        return animalQuestions.get(index);
    }
}
