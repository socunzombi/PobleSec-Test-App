import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Questions {

    private static Questions singleton;
    private List<Question> questions;
    private int currentQuestionId;

    private Questions() {
        this.questions = new ArrayList<Question>();
        this.setCurrentQuestionId(-1);
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

    public void setCurrentQuestionId(int currentQuestionId) {
        this.currentQuestionId = currentQuestionId;
    }

    public int getCurrentQuestionId() {
        return currentQuestionId;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getQuestionById (int id) {
        return this.questions.stream().filter(q -> q.getId() == id).findFirst().orElse(null);
    }

    public void addQuestion (Question question) {
        this.questions.add(question);
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
        
        PrintWriter csvFile = new PrintWriter(System.getProperty("user.dir") + "/bin/docs/questions.csv");

        for(Question q : questions) {
            csvFile.println(q.convertToCSV());
        }

        csvFile.close();
    }

    private void AnswersToCSV() throws IOException {
        
        PrintWriter csvFile = new PrintWriter(System.getProperty("user.dir") + "/bin/docs/answers.csv");

        for(Question q : questions) {
            csvFile.println(q.getId() + ";" + q.getCorrectAnswer() + ";true");
            for (String a : q.getIncorrectAnswers()) {
                csvFile.println(q.getId() + ";" + a + ";false");
            }
        }
        csvFile.close();
    }

    public int getNewId() {
        return singleton.getQuestions().size() > 0 ? 
               singleton.getQuestions()
                        .stream()
                        .max(Comparator.comparingInt(Question::getId))
                        .get().getId() + 1 : 
                        1;
    }

    public void deleteQuestionById(int id) {
        this.questions.remove(this.getQuestionById(id));
    }
}
