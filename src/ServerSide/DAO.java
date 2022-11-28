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

    List<QuestionPackage> biologyQuestions = new ArrayList<>();

    List<QuestionPackage> computerGamesQuestions = new ArrayList<>();

    List<QuestionPackage> sportsQuestions = new ArrayList<>();

    List<QuestionPackage> tvSeriesQuestions = new ArrayList<>();

    Category animalCategory;
    Category vehicleCategory;
    Category geographyCategory;
    Category foodCategory;
    Category biologyCategory;
    Category sportsCategory;
    Category computerGames;
    Category TVSeriesCategory;

    //TODO: Implementera

    public void generateQuestionList() {
        //VECHICLE
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

        //ANIMAL
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

        //GEOGRAPHY
        String[] geographyAnswersOne = {"Europa", "NordAmerika", "Sydamerika", "Afrika"};
        questionPackage = new QuestionPackage("Var ligger Amazonas", geographyAnswersOne, 2);
        this.geographyQuestions.add(questionPackage);

        String[] geographyAnswersTwo = {"Europa", "NordAmerika", "Sydamerika", "Afrika"};
        questionPackage = new QuestionPackage("Var ligger Paris?", geographyAnswersTwo, 2);
        this.geographyQuestions.add(questionPackage);

        String[] geographyAnswersThree = {"43,51,21,24"};
        questionPackage = new QuestionPackage("Hur många län indelas Sverige i?", geographyAnswersThree, 2);
        this.geographyQuestions.add(questionPackage);

        String[] geographyAnswersFour = {"Island", "Schweiz", "Norge", "Ryssland"};
        questionPackage = new QuestionPackage("Vilket är det nordligaste landet i Europa?", geographyAnswersFour, 2);
        this.geographyQuestions.add(questionPackage);

        //FOOD
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

        //SPORTS
        String[] sportsAnswersOne = {"Black Army", "Änglarna", "Elfsborgs supporterunion", "Guliganerna"};
        questionPackage = new QuestionPackage("Vad brukar fotbollsklubben IF Elfsborgs supportrar kallas?", sportsAnswersOne, 3);
        this.sportsQuestions.add(questionPackage);

        String[] sportAnswersTwo = {"Herrman Maier", "Ingemar Stenmark", "Kjetil André Aarmodt", "Alberto Tomba"};
        questionPackage = new QuestionPackage("Vad heter världen mest framgångsrike alpine skidåkare på herrsidan?", sportAnswersTwo, 2);
        this.sportsQuestions.add(questionPackage);

        //BIOLOGY
        String[] biologyAnswersOne = {"233", "202", "333", "642"};
        questionPackage = new QuestionPackage("Uppskattningsvis hur många skelettmuskler finns i människokroppen?", biologyAnswersOne, 3);
        this.biologyQuestions.add(questionPackage);

        String[] biologyAnswersTwo = {"Katastrofblödning", "Puls", "Angning", "Blodtryck"};
        questionPackage = new QuestionPackage("Vad är det första man kontrollerar enligt omhändertagandemetoden <C>ABCDE?", biologyAnswersTwo, 0);
        this.biologyQuestions.add(questionPackage);

        //COMPUTERGAMES
        String[] computerGamesAnswerOne = {"Counter Strike", "Call of Duty", "Super Mario", "FIFA"};
        questionPackage = new QuestionPackage("I vilket online-spel hittar du banor som dust och assualt?", computerGamesAnswerOne,0 );
        this.computerGamesQuestions.add(questionPackage);

        String[] computerGamesAnswerTwo = {"Zelda", "Half-Life", "Far Cry 2", "Uncharted"};
        questionPackage = new QuestionPackage("I vilket spel, spelar du som karaktären Gordon Freeman?", computerGamesAnswerTwo,1 );
        this.computerGamesQuestions.add(questionPackage);

        String[] computerGamesAnswerThree = {"Janne", "Daisy", "Peach", "Henriette"};
        questionPackage = new QuestionPackage("Vad heter prinsessan i det första Super Mario Bros-spelet till NES?", computerGamesAnswerThree,2 );
        this.computerGamesQuestions.add(questionPackage);

        //TV-SERIES
        String[] tvSeriesAnswersOne = {"John Johnsson", "Peter Parker", "Kevin Garvey", "Jack Carver"}   ;
        questionPackage = new QuestionPackage("Vem spelar huvudrollen i serien \"The Leftovers\"?", tvSeriesAnswersOne, 2);
        this.tvSeriesQuestions.add(questionPackage);

        String [] tvSeriesAnswersTwo = {"Stranger Things", "Game of Thrones", "Breaking Bad", "The Big Bang Theory"};
        questionPackage = new QuestionPackage("Vilken är den mest sedda serien någonsin?", tvSeriesAnswersTwo, 1);
        this.tvSeriesQuestions.add(questionPackage);

        Collections.shuffle(vehicleQuestions);
        vehicleCategory = new Category(vehicleQuestions, "Fordon");
        categories.add(vehicleCategory);

        animalCategory = new Category(animalQuestions, "Djur");
        categories.add(animalCategory);

        geographyCategory = new Category(geographyQuestions, "Geografi");
        categories.add(geographyCategory);

        foodCategory = new Category(foodQuestions, "Mat");
        categories.add(foodCategory);

        Collections.shuffle(biologyQuestions);
        biologyCategory = new Category(biologyQuestions, "Biologi");
        categories.add(biologyCategory);

        Collections.shuffle(sportsQuestions);
        sportsCategory = new Category(sportsQuestions, "Sport");
        categories.add(sportsCategory);

        Collections.shuffle(computerGamesQuestions);
        computerGames = new Category(computerGamesQuestions, "Datorspel");
        categories.add(computerGames);

        Collections.shuffle(tvSeriesQuestions);
        TVSeriesCategory = new Category(tvSeriesQuestions, "TV-serier");
        categories.add(TVSeriesCategory);
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
