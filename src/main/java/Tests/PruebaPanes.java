package Tests;

import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.Background;
        import javafx.scene.layout.BackgroundFill;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.stage.Stage;

public class PruebaPanes extends Application {

    Pane bluePane = new Pane();
    @Override
    public void start(Stage primaryStage) {
        // Crear el Pane blanco (fondo blanco)
        Pane whitePane = new Pane();
        whitePane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        // Crear el Pane azul (fondo azul) con un botón de salida

        bluePane.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));

        Button exitButton = new Button("Salir");
        exitButton.setOnAction(event -> {
            // Cerrar el pane azul y mostrar solo el blanco
            bluePane.setVisible(false);
        });
        bluePane.getChildren().add(exitButton);

        // Colocar los panes en un BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(whitePane);
        root.setBottom(bluePane);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Pane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Pane getRoot() {
        return bluePane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

