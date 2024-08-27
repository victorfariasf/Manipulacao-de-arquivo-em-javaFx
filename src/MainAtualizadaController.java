import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;

public class MainAtualizadaController {
    Fachada fachada = new Fachada();
    private ArrayList<String> listaMaterias = new ArrayList<>();
    private int paginaAtual = 0;
    private final int MAX_POR_PAGINA = 5;

    @FXML
    protected void initialize() {
        listaMaterias = fachada.acessoAsDisciplinas();
        organizarBtn();
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("mainAtualizada")) {
                    System.out.println("oi");
                    listaMaterias = fachada.acessoAsDisciplinas();
                    organizarBtn();
                }

            }

        });
    }

    @FXML
    private Label materiasLabel;

    public void organizarBtn() {

        int inicio = paginaAtual * MAX_POR_PAGINA;
        int fim = Math.min(inicio + MAX_POR_PAGINA, listaMaterias.size());

        // Lista de botões para facilitar a iteração
        List<Button> botoes = List.of(btn1, btn2, btn3, btn4, btn5);

        // Limpar todos os botões
        botoes.forEach(btn -> {
            btn.setText("");
            btn.setDisable(true);
        });

        // Colocar os nomes dos arquivos nos botões
        for (int i = 0; i < fim - inicio; i++) {
            Button botaoAtual = botoes.get(i);
            botaoAtual.setText(listaMaterias.get(inicio + i));
            botaoAtual.setDisable(false);
            // botoes.get(i).setText(listaMaterias.get(inicio + i));
        }

        // Habilitar/desabilitar botões de navegação
        proximoBtn.setDisable(fim >= listaMaterias.size());
        voltarBtn.setDisable(paginaAtual == 0);
    }

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button proximoBtn;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button adicionarDisciplinaBtn;

    @FXML
    void adicionarDisciplinaOnAction(ActionEvent event) {
        App.changeScreen("main");
    }

    @FXML
    void btn1OnAction(ActionEvent event) {
        Button clickedBtn = (Button) event.getSource();
        String buttonText = clickedBtn.getText();
        App.changeScreen("mostrarAlunos", buttonText);
    }

    @FXML
    void btn2OnAction(ActionEvent event) {
        Button clickedBtn = (Button) event.getSource();
        String buttonText = clickedBtn.getText();
        App.changeScreen("mostrarAlunos", buttonText);
    }

    @FXML
    void btn3OnAction(ActionEvent event) {
        Button clickedBtn = (Button) event.getSource();
        String buttonText = clickedBtn.getText();
        App.changeScreen("mostrarAlunos", buttonText);
    }

    @FXML
    void btn4OnAction(ActionEvent event) {
        Button clickedBtn = (Button) event.getSource();
        String buttonText = clickedBtn.getText();
        App.changeScreen("mostrarAlunos", buttonText);
    }

    @FXML
    void btn5OnAction(ActionEvent event) {
        Button clickedBtn = (Button) event.getSource();
        String buttonText = clickedBtn.getText();
        App.changeScreen("mostrarAlunos", buttonText);
    }

    @FXML
    void proximoOnAction(ActionEvent event) {
        if ((paginaAtual + 1) * MAX_POR_PAGINA < listaMaterias.size()) {
            paginaAtual++;
            organizarBtn();
        }
    }

    @FXML
    void voltarOnAction(ActionEvent event) {
        if (paginaAtual > 0) {
            paginaAtual--;
            organizarBtn();
        }
    }

}
