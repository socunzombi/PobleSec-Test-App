import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class ControllerEditQuestion {

    @FXML
    private Button addAnswerButton;

    @FXML
    private VBox answersHBox;

    @FXML
    private Button cancelButton;

    @FXML
    private TextArea questionTextArea;

    @FXML
    private TextField rightQuestionTextField;

    @FXML
    private Button saveButton;

    private Questions singleton;

    private Question question;

    private int numberOfAnswers;

    @FXML
    void OnClickAddAnswerButton(ActionEvent event) {
        this.createHBoxNewWrongAnswer("");
    }

    @FXML
    void OnClickCancelButton(ActionEvent event) {
        try {
            this.singleton.setCurrentQuestionId(-1);
            this.start((Stage) cancelButton.getScene().getWindow(), "/fxml/listQuestion.fxml");
        } 
        catch (MalformedURLException e) {
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
        this.completeQuestion();
        this.singleton.addQuestion(question);
    }

    private void editCurrentQuestion () {
        this.question = new Question(this.singleton.getCurrentQuestionId(), this.questionTextArea.getText());
        this.completeQuestion();
        this.singleton.getQuestionById(this.singleton.getCurrentQuestionId()).setNewValues(this.question);
    }

    private void completeQuestion() {
        this.question.setQuestion(this.questionTextArea.getText());
        this.question.setCorrectAnswer(this.rightQuestionTextField.getText());
        this.question.setIncorrectAnswers(new ArrayList<String>());
        
        for (int i = 1; i <= this.numberOfAnswers; i++) {
            Node node = this.answersHBox.getScene().lookup("#wrongAnswerTextField" + i);
            if (node instanceof TextField) {
                this.question.setNewIncorrectAnswer(((TextField) node).getText());
            }
        }
    }

    @FXML
    void initialize() {
        assert addAnswerButton != null : "fx:id=\"addAnswerButton\"";
        assert cancelButton != null : "fx:id=\"cancelButton\"";
        assert questionTextArea != null : "fx:id=\"questionTextArea\"";
        assert rightQuestionTextField != null : "fx:id=\"rightQuestionTextField\"";
        assert saveButton != null : "fx:id=\"saveButton\"";
        assert answersHBox != null : "fx:id=\"answersHBox\"";

        this.singleton = Questions.getInstance();

        this.question = this.singleton.getQuestionById(this.singleton.getCurrentQuestionId());
        this.numberOfAnswers = 0;

        if (this.question != null) {
            this.questionTextArea.setText(this.question.getQuestion());
            this.rightQuestionTextField.setText(this.question.getCorrectAnswer());

            for (String answer : this.question.getIncorrectAnswers()) {
                this.createHBoxNewWrongAnswer(answer);
            }
        }
        else {
            this.createHBoxNewWrongAnswer("");
            this.createHBoxNewWrongAnswer("");
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

    private void createHBoxNewWrongAnswer (String answer) {
        this.numberOfAnswers++;

        TextField tf = new TextField(answer);
        tf.setId("wrongAnswerTextField" + this.numberOfAnswers);
        tf.setEditable(true);
        tf.setAlignment(Pos.CENTER_LEFT);
        tf.setNodeOrientation(NodeOrientation.INHERIT);
        HBox.setHgrow(tf, Priority.ALWAYS);

        Text text = new Text("RESPUESTA INCORRECTA " + this.numberOfAnswers);
        
        HBox hBox = new HBox(20, text, tf);
        hBox.setId("hBox" + this.numberOfAnswers);
        hBox.setPadding(new Insets(0, 20.0, 0, 20.0));
        hBox.setAlignment(Pos.CENTER_LEFT);

        answersHBox.getChildren().add(hBox);
    }

}
