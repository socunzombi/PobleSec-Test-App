import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
 
public class View extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PS Test");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icon.png")));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch();
    }
}
