import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GabaritoController {
    String nomeDaDisciplina;
    Fachada fachada = new Fachada();

    @FXML
    protected void initialize() {
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                nomeDaDisciplina = (String) userData;
            }

        });
    }

    @FXML
    private Button continuarBtn;

    @FXML
    private TextField gabaritoField;

    @FXML
    void continuarOnAction(ActionEvent event) {
        String respostas = (String) gabaritoField.getText();
        fachada.criarArquivoFx(nomeDaDisciplina + "GABARITO", respostas);
        App.changeScreen("dadosAlunos", (Object) nomeDaDisciplina);
    }

}
