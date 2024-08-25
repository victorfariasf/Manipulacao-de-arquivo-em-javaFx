
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MainController {

    @FXML
    protected void initialize() {
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                disciplinaField.clear();
            }

        });
    }

    @FXML
    private Button continuarBtn;

    @FXML
    private TextField disciplinaField;
    Fachada fachada = new Fachada();

    @FXML
    void continuarOnAction(ActionEvent event) {
        String disciplina = disciplinaField.getText();
        boolean existeDisciplina = fachada.verificaExistenciaDeArquivo(disciplina);
        if (existeDisciplina == true) {
            App.changeScreen("mostrarAlunos", disciplina);
        } else {
            App.changeScreen("gabarito", disciplina);
        }

    }

    @FXML
    private Button voltarBtn;

    @FXML
    void voltarOnAction(ActionEvent event) {
        App.changeScreen("mainAtualizada");
    }

}
