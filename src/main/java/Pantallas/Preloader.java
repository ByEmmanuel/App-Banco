package Pantallas;


import Interfaces.MetodosAB;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Preloader extends javafx.application.Preloader implements MetodosAB {

    public Preloader() {
        // Constructor vacío
    }

    @Override
    public void start(Stage stage) throws Exception {

        //StackPane root = new StackPane(new Label("Cargando..."));
        VentanaDeCarga app = new VentanaDeCarga();
        mainLayout.getChildren().addAll(app.getRoot());
        Scene scene = new Scene(mainLayout, 328, 636);
        primaryStage.setScene(scene);
        primaryStage.show();

        /*mainLayout.getChildren().addAll(BckImg,exitButton,greetingLabel,BienvenidaLogo, cargarLogin.getRoot());
        Scene scene = new Scene(mainLayout, 750, 480);

        String CSS = String.valueOf(getClass().getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        SecundaryStage.setScene(scene);
        SecundaryStage.show();*/

        waitForSomeTimeAndLoadApp();
    }

    private void waitForSomeTimeAndLoadApp() {
        // Agrega un tiempo de espera en milisegundos (por ejemplo, 3000 ms = 3 segundos)
        new Thread(() -> {
            try {
                Thread.sleep(800); // Espera durante el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                mainLayout.getChildren().clear();

                try {
                cargarPaginaMain();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();
    }
}
