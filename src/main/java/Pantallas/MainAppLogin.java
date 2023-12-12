package Pantallas;

import Interfaces.MetodosRegistro;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainAppLogin extends Application implements MetodosRegistro {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Preloader preloader = new Preloader();
        preloader.start(primaryStage);
    }
}
