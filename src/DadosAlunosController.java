import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DadosAlunosController {
    Fachada fachada = new Fachada();
    String nomeDaDisciplina;

    @FXML
    protected void initialize() {
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                nomeDaDisciplina = (String) userData;
                nomeField.clear();
                respostasField.clear();
            }

        });
    }

    @FXML
    private Button encerrarBtn;

    @FXML
    private TextField nomeField;

    @FXML
    private Button proximoBtn;

    @FXML
    private TextField respostasField;

    @FXML
    void encerrarOnAction(ActionEvent event) {
        App.changeScreen("mainAtualizada");
    }

    @FXML
    void proximoOnAction(ActionEvent event) {
        System.out.println(nomeDaDisciplina);

        String nome = (String) nomeField.getText();
        String respostas = (String) respostasField.getText();
        fachada.criarArquivoFx(nomeDaDisciplina, nome + "\t" + respostas);

        nomeField.clear();
        respostasField.clear();
    }

}
