import java.util.List;

public class Question {

    //region variables
    int id;
    String question;
    Answer correctAnswer;
    List<Answer> incorrectAnswers;
    //endregion

    //region constructor
    public Question(int id, String question, Answer correctAnswer, List<Answer> incorrectAnswers) {
        this.setId(id);
        this.setQuestion(question);
        this.setCorrectAnswer(correctAnswer);
        this.setIncorrectAnswers(incorrectAnswers);
    }
    //endregion

    //region getters
    public int getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public List<Answer> getIncorrectAnswers() {
        return this.incorrectAnswers;
    }

    public Answer getIncorrectAnswerById(int id) {
        return this.incorrectAnswers.stream().filter(ans -> ans.getId() == id).findFirst().orElse(null);
    }
    //endregion

    //region setters
    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setIncorrectAnswers(List<Answer> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setNewIncorrectAnswer (Answer incorrectAnswer) {
        this.incorrectAnswers.add(incorrectAnswer);
    }

    public void deleteIncorrectAnswer(int id){
        this.incorrectAnswers.remove(this.getIncorrectAnswerById(id));
    }
    // endregion
}
