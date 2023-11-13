package Pantallas;

import Interfaces.MetodosAB;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application implements MetodosAB {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Preloader preloader = new Preloader();
        preloader.start(primaryStage);
    }
}
