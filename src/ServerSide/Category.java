package ServerSide;

import Resources.QuestionPackage;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

    String name;
    List<QuestionPackage> questionPackage;

    public Category(List<QuestionPackage> questionPackage, String name){
        this.questionPackage = questionPackage;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionPackage> getQuestionPackage() {
        return questionPackage;
    }

    public void setQuestionPackage(List<QuestionPackage> questionPackage) {
        this.questionPackage = questionPackage;
    }
}
