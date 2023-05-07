import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.MalformedURLException;

public class ControllerListQuestion {

    @FXML
    private Button addQuestionButton;

    @FXML
    private Button deleteQuestionButton;

    @FXML
    private Button editQuestionButton;

    @FXML
    private TextField questionTextField;

    @FXML
    private Button turnBackButton;

    @FXML
    void OnClickAddQuestionButton(ActionEvent event) {

    }

    @FXML
    void OnClickDeleteQuestionButton(ActionEvent event) {

    }

    @FXML
    void OnClickEditQuestionButton(ActionEvent event) {
        try {
            this.start((Stage) editQuestionButton.getScene().getWindow(), "/fxml/editQuestion.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClickTurnBackButton(ActionEvent event) {
        try {
            this.start((Stage) editQuestionButton.getScene().getWindow(), "/fxml/main.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert addQuestionButton != null : "fx:id=\"addQuestionButton\"";
        assert deleteQuestionButton != null : "fx:id=\"deleteQuestionButton\"";
        assert editQuestionButton != null : "fx:id=\"editQuestionButton\"";
        assert questionTextField != null : "fx:id=\"questionTextField\"";
        assert turnBackButton != null : "fx:id=\"turnBackButton\"";
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
