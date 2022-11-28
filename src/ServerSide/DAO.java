package ServerSide;

import Resources.QuestionPackage;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    List<Category> categories = new ArrayList<>();
    List<QuestionPackage> vehicleQuestions = new ArrayList<>();

    List<QuestionPackage> animalQuestions = new ArrayList<>();

    List<QuestionPackage> geographyQuestions = new ArrayList<>();

    List<QuestionPackage> foodQuestions = new ArrayList<>();

    Category animalCategory;
    Category vehicleCategory;
    Category geographyCategory;
    Category foodCategory;


    //TODO: Implementera

    public void generateQuestionList() {

        String[] vehicleAnswersOne = {"1", "2", "3", "4"};
        QuestionPackage questionPackage = new QuestionPackage("Hur många däck brukar en bil ha?", vehicleAnswersOne, 3);
        this.vehicleQuestions.add(questionPackage);

        String[] vehicleAnswersTwo = {"Datormöss", "Flygplan", "Torktumlare", "Godis"};
        questionPackage = new QuestionPackage("Vad tillverkar Airbus?", vehicleAnswersTwo, 1);
        this.vehicleQuestions.add(questionPackage);

        String[] vehicleAnswersThree = {"Kattsand", "Flygplan", "Granatgevär", "Simulatorsystem"};
        questionPackage = new QuestionPackage("Vilket av följande tillverkar INTE Saab?", vehicleAnswersThree, 0);
        this.vehicleQuestions.add(questionPackage);

        String[] vehicleAnswersFour = {"Taurus", "Mustang", "F-serie lastbilar", "Focus"};
        questionPackage = new QuestionPackage("Vilken fordmodell producerades under mest antal år?", vehicleAnswersFour, 2);
        this.vehicleQuestions.add(questionPackage);

        String[] animalAnswersOne = {"Bondkatt", "Norsk skogskatt", "Råttor", "Siamesiska kattråttor"};
        questionPackage = new QuestionPackage("Vilken är den vanligaste kattrasen?", animalAnswersOne, 0);
        this.animalQuestions.add(questionPackage);

        String[] animalAnswersTwo = {"quack quack", "muuuuu", "voff voff", "vrooooom"};
        questionPackage = new QuestionPackage("Hur låter en ko?", animalAnswersTwo, 1);
        this.animalQuestions.add(questionPackage);

        String[] animalAnswersThree = {"Babian", "Koala", "Panda", "Hyena"};
        questionPackage = new QuestionPackage("Vilket djurs \"skratt\" är en reaktion till att den känner sig hotad?", animalAnswersThree, 3);
        this.animalQuestions.add(questionPackage);

        String[] animalAnswersFour = {"Babian", "Lejon", "Hund", "Zebra"};
        questionPackage = new QuestionPackage("Vilket djur klättrar i träd?", animalAnswersFour, 0);
        this.animalQuestions.add(questionPackage);

        String[] geographyAnswersOne = {"Europa", "NordAmerika", "Sydamerika", "Afrika"};
        questionPackage = new QuestionPackage("Var ligger Amazonas", geographyAnswersOne, 2);
        this.geographyQuestions.add(questionPackage);

        String[] geographyAnswersTwo = {"Europa", "NordAmerika", "Sydamerika", "Afrika"};
        questionPackage = new QuestionPackage("Var ligger Paris?", geographyAnswersTwo, 2);
        this.geographyQuestions.add(questionPackage);

        String[] geographyAnswersThree = {"43,51,21,24"};
        questionPackage = new QuestionPackage("Hur många län indelas Sverige i?", geographyAnswersThree, 2);
        this.geographyQuestions.add(questionPackage);

        String[] geographyAnswersFour = {"Island","Schweiz","Norge","Ryssland"};
        questionPackage = new QuestionPackage("Vilket är det nordligaste landet i Europa?", geographyAnswersFour, 2);
        this.geographyQuestions.add(questionPackage);

        String[] foodAnswersOne = {"Kolhydrat", "Fett", "Protein", "Vatten"};
        questionPackage = new QuestionPackage("Vilket av följande är INTE en makronutrient?", foodAnswersOne, 3);
        this.foodQuestions.add(questionPackage);

        String[] foodAnswersTwo = {"2", "3", "7", "12"};
        questionPackage = new QuestionPackage("Hur många kalorier innehåller ett gram alkohol?", foodAnswersTwo, 2);
        this.foodQuestions.add(questionPackage);

        String[] foodAnswersThree = {"Europa", "Asien", "Afrika", "Sydamerika"};
        questionPackage = new QuestionPackage("Var kommer ris ifrån?", foodAnswersThree, 1);
        this.foodQuestions.add(questionPackage);

        String[] foodAnswersFour = {"Svampar och morötter", "Lök och rödbetor", "Vitkol och purjolök", "Äpplen och morötter"};
        questionPackage = new QuestionPackage("vad är huvudingrediensen i boeuf bourguignon?", foodAnswersFour, 0);
        this.foodQuestions.add(questionPackage);

        vehicleCategory = new Category(vehicleQuestions, "Fordon");
        categories.add(vehicleCategory);

        animalCategory = new Category(animalQuestions, "Djur");
        categories.add(animalCategory);

        geographyCategory = new Category(geographyQuestions, "Geografi");
        categories.add(geographyCategory);

        foodCategory = new Category(foodQuestions, "Mat");
        categories.add(foodCategory);
    }

    public DAO() {
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

    //TODO: Metod ämnad att kunna ta bort frågepaket från ett pågående spel. Återkom till detta senare i mån av tid.

//    public void removeUsedQuestionPackageFromCategory(Category currentCategory, int questionsPerRound) {
//        for (Category category : categories) {
//            if (category.getName().equals(currentCategory.getName())) {
//                currentCategory = category;
//            }
//        }
//
//        for (int i = 0; i < questionsPerRound; i++) {
//            currentCategory.getQuestionPackage().remove(0);
//        }
//    }


    public void deleteCategoryByName(String name) {
        categories.removeIf(category -> category.getName().equals(name));
    }
}
