import java.util.ArrayList;
import java.util.List;

public class Question {

    //region variables
    private int id;
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;
    //endregion

    //region constructor
    public Question(int id, String question) {
        this.setId(id);
        this.setQuestion(question);
        this.setIncorrectAnswers(new ArrayList<String>());
    }
    //endregion

    //region getters
    public int getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return this.incorrectAnswers;
    }
    //endregion

    //region setters
    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setNewIncorrectAnswer (String incorrectAnswer) {
        this.incorrectAnswers.add(incorrectAnswer);
    }
    // endregion

    public void deleteIncorrectAnswer(String answer){
        this.incorrectAnswers.remove(answer);
    }

    public String convertToCSV() {
        return this.getId() + ";" + this.getQuestion();
    }
}
