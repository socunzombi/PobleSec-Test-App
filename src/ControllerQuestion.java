import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import java.net.MalformedURLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ControllerQuestion {

    @FXML
    private ToggleGroup QuestionGroup;

    @FXML
    private RadioButton answerRB1;

    @FXML
    private RadioButton answerRB2;

    @FXML
    private RadioButton answerRB3;

    @FXML
    private Button endButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button previousButton;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Text questionText;

    @FXML
    void OnClickAnswerRB1(ActionEvent event) {

    }

    @FXML
    void OnClickAnswerRB2(ActionEvent event) {

    }

    @FXML
    void OnClickAnswerRB3(ActionEvent event) {

    }

    @FXML
    void OnClickEndButton(ActionEvent event) {
        try {
            this.start((Stage) endButton.getScene().getWindow(), "/fxml/main.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClickNextButton(ActionEvent event) {

    }

    @FXML
    void OnClickPreviousButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert QuestionGroup != null : "fx:id=\"QuestionGroup\"";
        assert answerRB1 != null : "fx:id=\"answerRB1\"";
        assert answerRB2 != null : "fx:id=\"answerRB2\"";
        assert answerRB3 != null : "fx:id=\"answerRB3\"";
        assert endButton != null : "fx:id=\"endButton\"";
        assert nextButton != null : "fx:id=\"nextButton\"";
        assert previousButton != null : "fx:id=\"previousButton\"";
        assert progressBar != null : "fx:id=\"progressBar\"";
        assert questionText != null : "fx:id=\"questionText\"";
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
