import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class mostrarAlunosController {

    Fachada fachada = new Fachada();
    ArrayList<String> alunos = new ArrayList<>();
    ArrayList<Aluno> alunosObj = new ArrayList<>();
    String disciplina = new String();
    private int paginaAtual = 1;

    @FXML
    protected void initialize() {
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                disciplina = (String) userData;
                alunos = fachada.lerDisciplinaJavaFx(disciplina);
                alunosObj = fachada.transformarParaObjeto(alunos, disciplina);
                for (Aluno x : alunosObj) {
                    System.out.println(x.toString());
                }
                double mediaTurma = fachada.pegarMediaDaTurma(disciplina, alunosObj);
                mediaTurmaLabel.setText("Media da turma: " + String.format("%.2f", mediaTurma));
                organizarLabels(alunosObj);

            }

        });
    }

    @FXML
    private Label gabaritoLabel;

    public void organizarLabels(ArrayList<Aluno> alunos) {
        alunoLabel1.setText("");
        alunoLabel2.setText("");
        alunoLabel3.setText("");
        alunoLabel4.setText("");
        alunoLabel5.setText("");
        alunoLabel6.setText("");
        alunoLabel7.setText("");
        alunoLabel8.setText("");
        alunoLabel9.setText("");
        alunoLabel10.setText("");
        alunoLabel11.setText("");
        alunoLabel12.setText("");
        alunoLabel13.setText("");
        alunoLabel14.setText("");

        int totalAlunos = alunos.size();
        int totalPaginas = (int) Math.ceil((double) totalAlunos / 14);

        if (paginaAtual == 1) {
            voltarBtn.setDisable(true);
        } else {
            voltarBtn.setDisable(false);
        }

        if (paginaAtual == totalPaginas) {
            proximoBtn.setDisable(true);
        } else {
            proximoBtn.setDisable(false);
        }

        int inicio = (paginaAtual - 1) * 14;
        int fim = Math.min(inicio + 14, totalAlunos);

        for (int i = inicio; i < fim; i++) {
            Aluno aluno = alunos.get(i);
            int posicao = i - inicio + 1;

            switch (posicao) {
                case 1:
                    alunoLabel1.setText(aluno.toString());
                    break;
                case 2:
                    alunoLabel2.setText(aluno.toString());
                    break;
                case 3:
                    alunoLabel3.setText(aluno.toString());
                    break;
                case 4:
                    alunoLabel4.setText(aluno.toString());
                    break;
                case 5:
                    alunoLabel5.setText(aluno.toString());
                    break;
                case 6:
                    alunoLabel6.setText(aluno.toString());
                    break;
                case 7:
                    alunoLabel7.setText(aluno.toString());
                    break;
                case 8:
                    alunoLabel8.setText(aluno.toString());
                    break;
                case 9:
                    alunoLabel9.setText(aluno.toString());
                    break;
                case 10:
                    alunoLabel10.setText(aluno.toString());
                    break;
                case 11:
                    alunoLabel11.setText(aluno.toString());
                    break;
                case 12:
                    alunoLabel12.setText(aluno.toString());
                    break;
                case 13:
                    alunoLabel13.setText(aluno.toString());
                    break;
                case 14:
                    alunoLabel14.setText(aluno.toString());
                    break;
                default:
                    break;
            }

        }
        String gabaritoOficial = fachada.lerAlgumDadoDoArquivoJavaFx(disciplina + "GABARITO");
        gabaritoLabel.setText("Gabarito: " + gabaritoOficial);

    }

    @FXML
    private Label alunoLabel1;

    @FXML
    private Label alunoLabel2;

    @FXML
    private Label alunoLabel3;

    @FXML
    private Label alunoLabel4;

    @FXML
    private Label alunoLabel5;

    @FXML
    private Label alunoLabel6;

    @FXML
    private Label alunoLabel7;

    @FXML
    private Label alunoLabel8;

    @FXML
    private Label alunoLabel9;
    @FXML
    private Label alunoLabel10;

    @FXML
    private Label alunoLabel11;

    @FXML
    private Label alunoLabel12;

    @FXML
    private Label alunoLabel13;

    @FXML
    private Label alunoLabel14;

    @FXML
    private Label mediaTurmaLabel;

    @FXML
    private Button proximoBtn;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button ordenarAlfabeticaBtn;

    @FXML
    private Button ordernarNotasDecrescentesBtn;

    @FXML
    private Button sairBtn;

    @FXML
    private Button masiAlunosBtn;

    @FXML
    void proximoOnAction(ActionEvent event) {
        paginaAtual++;
        organizarLabels(alunosObj);
    }

    @FXML
    void voltarOnAction(ActionEvent event) {
        paginaAtual--;
        organizarLabels(alunosObj);
    }

    @FXML
    void ordenarAlfabeticaOnAction(ActionEvent event) {
        alunosObj.sort((x, y) -> x.getNome().compareTo(y.getNome()));
        String conteudo = new String();
        for (Aluno x : alunosObj) {
            conteudo += x.toString() + "\n";
        }
        fachada.atualizarArquivoFx(disciplina + "ALFABETICA", conteudo);
        organizarLabels(alunosObj);
    }

    @FXML
    void ordenarNotasDecrescentesOnAction(ActionEvent event) {
        alunosObj.sort((x, y) -> Integer.compare(y.getNota(), x.getNota()));
        String conteudo = new String();
        for (Aluno x : alunosObj) {
            conteudo += x.toString() + "\n";
        }
        fachada.atualizarArquivoFx(disciplina + "DECRESCENTE", conteudo);
        organizarLabels(alunosObj);
    }

    @FXML
    void maisAlunosOnAction(ActionEvent event) {
        App.changeScreen("dadosAlunos", disciplina);
    }

    @FXML
    void sairOnAction(ActionEvent event) {
        App.changeScreen("main", null);
    }

}
