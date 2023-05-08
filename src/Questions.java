import java.util.List;

public class Questions {

    private Questions singleton;
    List<Question> questions;

    private Questions() {
        this.StartQuestions();
    }

    public Questions getInstance() {
        if (this.singleton == null) {
            this.singleton = new Questions();
        }

        return this.singleton;
    }

    private void StartQuestions() {
        // TODO: Cargar preguntas de los ficheros
    }

    public void SaveQuestions() {
        // TODO: Guardar en los ficheros las preguntas
    }
}
