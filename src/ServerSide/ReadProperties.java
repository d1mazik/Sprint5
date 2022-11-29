package ServerSide;

import java.io.FileInputStream;;
import java.util.Properties;

public class ReadProperties {
    int rounds;
    int questionsInRound;

    Properties p;

    public ReadProperties() {
        p = new Properties();

        try {
            p.load(new FileInputStream("src/ServerSide/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRounds() {
        String in = p.getProperty("numberOfRounds", "2");
        rounds = Integer.parseInt(in);
        return rounds;
    }

    public int getQuestionsInRound() {
        String in = p.getProperty("numberOfQuestions", "2");
        questionsInRound = Integer.parseInt(in);
        return questionsInRound;
    }

}
