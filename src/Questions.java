import java.util.List;

public class Questions {

    private static Questions singleton;
    List<Question> questions;

    private Questions() {
        this.StartQuestions();
    }

    public static Questions getInstance() {
        if (singleton == null) {
            singleton = new Questions();
        }

        return singleton;
    }

    private void StartQuestions() {
        // TODO: Cargar preguntas de los ficheros
    }

    public void SaveQuestions() {
        // TODO: Guardar en los ficheros las preguntas
    }
}
