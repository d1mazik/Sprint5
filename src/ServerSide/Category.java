package ServerSide;

import Resources.QuestionsWithAnswers;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

    String name;
    List<QuestionsWithAnswers> questionPackage;

    public Category(List<QuestionsWithAnswers> questionPackage, String name){
        this.questionPackage = questionPackage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionsWithAnswers> getQuestionPackage() {
        return questionPackage;
    }

    public void setQuestionPackage(List<QuestionsWithAnswers> questionPackage) {
        this.questionPackage = questionPackage;
    }
}
