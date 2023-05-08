import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Questions {

    private static Questions singleton;
    List<Question> questions;

    private Questions() {
        this.questions = new ArrayList<Question>();
    }

    public static Questions getInstance() {
        if (singleton == null) {
            singleton = new Questions();

            try {
                StartQuestions();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return singleton;
    }

    private static void StartQuestions() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/bin/docs/questions.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                singleton.questions.add(new Question(Integer.parseInt(values[0]), values[1]));
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/bin/docs/answers.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                if(values[2].equals("true")) {
                    singleton.questions.stream()
                                       .filter(q -> q.getId() == Integer.parseInt(values[0]))
                                       .findFirst()
                                       .orElse(null)
                                       .setCorrectAnswer(values[1]);
                }
                else {
                    singleton.questions.stream()
                                       .filter(q -> q.getId() == Integer.parseInt(values[0]))
                                       .findFirst()
                                       .orElse(null)
                                       .setNewIncorrectAnswer(values[1]);
                }
            }
        }
    }

    public void SaveQuestions() {
        try {
            this.QuestionsToCSV();
            this.AnswersToCSV();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void QuestionsToCSV() throws IOException {
        
        PrintWriter csvFile = new PrintWriter("./docs/questions.csv");

        for(Question q : questions) {
            csvFile.println(q.convertToCSV());
        }

        csvFile.close();
    }

    private void AnswersToCSV() throws IOException {
        
        PrintWriter csvFile = new PrintWriter("./docs/answers.csv");

        for(Question q : questions) {
            csvFile.println(q.getId() + ";" + q.getCorrectAnswer() + ";true");
            for (String a : q.getIncorrectAnswers()) {
                csvFile.println(q.getId() + ";" + a + ";false");
            }
        }
        csvFile.close();
    }
}
