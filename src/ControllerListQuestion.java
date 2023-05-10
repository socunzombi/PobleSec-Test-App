import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.MalformedURLException;

public class ControllerListQuestion {

    @FXML
    private Button addQuestionButton;

    @FXML
    private Button turnBackButton;

    @FXML
    private VBox questionBox;

    Questions singleton;

    @FXML
    void OnClickAddQuestionButton(ActionEvent event) {
        try {
            this.start((Stage) addQuestionButton.getScene().getWindow(), "/fxml/editQuestion.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClickDeleteQuestionButton(ActionEvent event, Node toDelete) {
        Alert alert = new Alert(AlertType.WARNING, "¿Seguro que quieres eliminar esta pregunta?", ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            this.singleton.deleteQuestionById(this.singleton.getCurrentQuestionId());
            this.questionBox.getChildren().remove(toDelete);
        }

        this.singleton.setCurrentQuestionId(-1);
    }

    @FXML
    void OnClickEditQuestionButton(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            this.start((Stage) node.getScene().getWindow(), "/fxml/editQuestion.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClickTurnBackButton(ActionEvent event) {
        singleton.SaveQuestions();
        try {
            this.start((Stage) turnBackButton.getScene().getWindow(), "/fxml/main.fxml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert addQuestionButton != null : "fx:id=\"addQuestionButton\"";
        assert turnBackButton != null : "fx:id=\"turnBackButton\"";
        assert questionBox != null : "fx:id=\"questionBox\"";

        singleton = Questions.getInstance();

        for (Question q : singleton.getQuestions()) {
            this.createHBoxQuestion(q);
        }
    }

    private void createHBoxQuestion (Question q) {
        
        TextField tf = new TextField(q.getQuestion());
        tf.setEditable(false);
        tf.setAlignment(Pos.CENTER_LEFT);
        tf.setNodeOrientation(NodeOrientation.INHERIT);
        HBox.setHgrow(tf, Priority.ALWAYS);
        

        Button editButton = new Button("Editar");
        editButton.setId("editQuestionButton" + q.getId());
        editButton.setOnAction(e -> {
            singleton.setCurrentQuestionId(q.getId());
            OnClickEditQuestionButton(e);
        });
        Button deleteButton = new Button("Eliminar");
        deleteButton.setId("deleteQuestionButton" + q.getId());
        
        HBox hBox = new HBox(20, tf, editButton, deleteButton);
        hBox.setId("hBox" + q.getId());
        hBox.setPadding(new Insets(0, 20.0, 0, 20.0));

        deleteButton.setOnAction(e -> {
            singleton.setCurrentQuestionId(q.getId());
            OnClickDeleteQuestionButton(e, hBox);
        });

        questionBox.getChildren().add(hBox);
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
