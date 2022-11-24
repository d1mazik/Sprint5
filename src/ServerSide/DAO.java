package ServerSide;

import Resources.QuestionsWithAnswers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DAO {
    List<Category> categories = new ArrayList<>();
    List<QuestionsWithAnswers> vehicleQuestions = new ArrayList<>();

    List<QuestionsWithAnswers> animalQuestions = new ArrayList<>();

    List<QuestionsWithAnswers> geographyQuestions = new ArrayList<>();

    List<QuestionsWithAnswers> foodQuestions = new ArrayList<>();

    Category animalPackageOne;
    Category vehiclePackageOne;
    Category geographyPackageOne;
    Category foodPackageOne;



    //TODO: Implementera

    public void generateQuestionList() {
        String[] alternatives1 = {"1", "2", "3", "4"};
        QuestionsWithAnswers question = new QuestionsWithAnswers("Hur många däck brukar en bil ha?", alternatives1,3);
        this.vehicleQuestions.add(question);

        String[] alternatives2 = {"Datormöss", "Flygplan", "Torktumlare", "Godis"};
        question = new QuestionsWithAnswers("Vad tillverkar Airbus?", alternatives2, 1);
        this.vehicleQuestions.add(question);

        vehiclePackageOne = new Category(vehicleQuestions, "Fordon");
        categories.add(vehiclePackageOne);

        String[] animalOne = {"Bondkatt", "Norsk skogskatt", "Råttor", "Siamesiska kattråttor"};
        question = new QuestionsWithAnswers("Vilken är den vanligaste kattrasen?", animalOne,0);
        this.animalQuestions.add(question);


        String[] alternatives4 = {"quack quack","muuuuu","voff voff", "vrooooom"};
        question = new QuestionsWithAnswers("Hur låter en ko?",alternatives4,1);
        this.animalQuestions.add(question);

        animalPackageOne = new Category(animalQuestions, "Djur");
        categories.add(animalPackageOne);

        String[] geographyOne = {"Europa", "NordAmerika", "Sydamerika", "Afrika"};
        question = new QuestionsWithAnswers("Var ligger Amazonas", geographyOne, 2);
        this.geographyQuestions.add(question);
        geographyPackageOne = new Category(geographyQuestions, "Geografi");
//        categories.add(geographyPackageOne);

        String[] geographyTwo = {"Europa", "NordAmerika", "Sydamerika", "Afrika"};
        question = new QuestionsWithAnswers("Var ligger Paris?", geographyTwo, 2);
        this.geographyQuestions.add(question);
        geographyPackageOne = new Category(geographyQuestions, "Geografi");
        categories.add(geographyPackageOne);
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

    public Category getPackage(int i) {
        return categories.get(i);
    }
}
