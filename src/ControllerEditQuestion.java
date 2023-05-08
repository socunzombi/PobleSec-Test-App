import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.MalformedURLException;

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

    @FXML
    void OnClickAddAnswerButton(ActionEvent event) {

    }

    @FXML
    void OnClickCancelButton(ActionEvent event) {
        try {
            this.start((Stage) cancelButton.getScene().getWindow(), "/fxml/listQuestion.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClickSaveButton(ActionEvent event) {

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
