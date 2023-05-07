import java.net.MalformedURLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ControllerMain {

    @FXML
    private Button EditQuestionsButton;

    @FXML
    private Button StartTestButton;

    @FXML
    void OnClickEditQuestionsButton(ActionEvent event) {
        try {
            this.start((Stage) StartTestButton.getScene().getWindow(), "/fxml/listQuestion.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClickStartTestButton(ActionEvent event) {
        try {
            this.start((Stage) StartTestButton.getScene().getWindow(), "/fxml/question.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert EditQuestionsButton != null : "fx:id=\"EditQuestionsButton\"";
        assert StartTestButton != null : "fx:id=\"StartTestButton\"";
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
