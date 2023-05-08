public class Answer {
    
    //region values
    int id;
    String answer;
    //endregion

    //region constructor
    public Answer(int id, String answer, Boolean correctAnswer) {
        this.setId(id);
        this.setAnswer(answer);
    }
    //endregion

    //region getters
    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }
    //endregion

    //region setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    //endregion
}
