import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class ControllerEditQuestion {

    @FXML
    private Button addAnswerButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextArea questionTextArea;

    @FXML
    private TextField rightQuestionTextField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField wrongAnswer01TextField;

    @FXML
    private TextField wrongAnswer02TextField;

    private Questions singleton;

    private Question question;

    @FXML
    void OnClickAddAnswerButton(ActionEvent event) {

    }

    @FXML
    void OnClickCancelButton(ActionEvent event) {
        try {
            this.singleton.setCurrentQuestionId(-1);
            this.start((Stage) cancelButton.getScene().getWindow(), "/fxml/listQuestion.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClickSaveButton(ActionEvent event) {
        if (this.singleton.getCurrentQuestionId() == -1) {
            this.addNewQuestion();
        }
        else {
            this.editCurrentQuestion();
        }

        this.singleton.setCurrentQuestionId(-1);
        
        try {
            this.start((Stage) cancelButton.getScene().getWindow(), "/fxml/listQuestion.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void addNewQuestion () {
        this.question = new Question(this.singleton.getNewId(), this.questionTextArea.getText());

        this.question.setQuestion(this.questionTextArea.getText());
        this.question.setCorrectAnswer(this.rightQuestionTextField.getText());
        this.question.setIncorrectAnswers(new ArrayList<String>());
        this.question.setNewIncorrectAnswer(this.wrongAnswer01TextField.getText());
        this.question.setNewIncorrectAnswer(this.wrongAnswer02TextField.getText());

        this.singleton.addQuestion(question);
    }

    private void editCurrentQuestion () {

    }

    @FXML
    void initialize() {
        assert addAnswerButton != null : "fx:id=\"addAnswerButton\"";
        assert cancelButton != null : "fx:id=\"cancelButton\"";
        assert questionTextArea != null : "fx:id=\"questionTextArea\"";
        assert rightQuestionTextField != null : "fx:id=\"rightQuestionTextField\"";
        assert saveButton != null : "fx:id=\"saveButton\"";
        assert wrongAnswer01TextField != null : "fx:id=\"wrongAnswer01TextField\"";
        assert wrongAnswer02TextField != null : "fx:id=\"wrongAnswer02TextField\"";

        this.singleton = Questions.getInstance();

        this.question = this.singleton.getQuestionById(this.singleton.getCurrentQuestionId());

        if (this.question != null) {
            this.questionTextArea.setText(this.question.getQuestion());
            this.rightQuestionTextField.setText(this.question.getCorrectAnswer());
        }
    }

    private void start(Stage stage, String FXMLfile) throws java.net.MalformedURLException {
        try{
            Scene scene = stage.getScene();
            scene.setRoot(FXMLLoader.load(getClass().getResource(FXMLfile)));
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

}
