package ServerSide;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    int rounds;
    int questionsInRound;

    int timePerQuestions;
    Properties p;

    public ReadProperties() throws IOException {
        p = new Properties();

        try {
            p.load(new FileInputStream("src/ServerSide/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // questionsInRound = Integer.parseInt(p.getProperty("numberOfRounds", String.valueOf(2)));

    }

    public int getRounds() {
        String in = p.getProperty("numberOfRounds", "2");
        rounds = Integer.parseInt(in);
        return rounds;
    }

    public int getQuestionsInRound() {
        String in = p.getProperty("numberOfQuestion", "2");
        questionsInRound = Integer.parseInt(in);
        return questionsInRound;
    }

}
