import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch(args);
    }

    private static Stage stage;

    private static Scene mainScene;
    private static Scene gabaritoScene;
    private static Scene dadosAlunosScene;
    private static Scene mostrarAlunosScene;
    private static Scene mainAtualizadaScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent fxmlMainAtualizada = FXMLLoader.load(getClass().getResource("fxml/mainAtualizada.fxml"));
        mainAtualizadaScene = new Scene(fxmlMainAtualizada);

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        mainScene = new Scene(fxmlMain);

        Parent fxmlGabarito = FXMLLoader.load(getClass().getResource("fxml/gabarito.fxml"));
        gabaritoScene = new Scene(fxmlGabarito);

        Parent fxmlDadosAlunos = FXMLLoader.load(getClass().getResource("fxml/dadosAlunos.fxml"));
        dadosAlunosScene = new Scene(fxmlDadosAlunos);

        Parent fxmlMostrarAlunos = FXMLLoader.load(getClass().getResource("fxml/mostrarAlunos.fxml"));
        mostrarAlunosScene = new Scene(fxmlMostrarAlunos);

        primaryStage.setScene(mainAtualizadaScene);
        primaryStage.setTitle("Bem-vindo");
        primaryStage.show();
    }

    public static void changeScreen(String scr, Object userData) {
        switch (scr) {
            case "mainAtualizada":
                stage.setScene(mainAtualizadaScene);
                notifyAllListeners("mainAtualizada", userData);
                break;
            case "main":
                stage.setScene(mainScene);
                notifyAllListeners("main", userData);
                break;
            case "gabarito":
                stage.setScene(gabaritoScene);
                notifyAllListeners("gabarito", userData);
                break;
            case "dadosAlunos":
                stage.setScene(dadosAlunosScene);
                notifyAllListeners("dadosAlunos", userData);
                break;
            case "mostrarAlunos":
                stage.setScene(mostrarAlunosScene);
                notifyAllListeners("mostrarAlunos", userData);
                break;

            default:
                break;
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void changeScreen(String scr) {

        changeScreen(scr, null);
    }

    // ------------------------------------------------------------
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen {
        void onScreenChanged(String newScreen, Object userData);

    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener) {
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData) {
        for (OnChangeScreen l : listeners) {
            l.onScreenChanged(newScreen, userData);
        }
    }
}
