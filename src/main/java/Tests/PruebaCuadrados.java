package Tests;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PruebaCuadrados extends Application {
    private Rectangle square;
    private boolean haciaIzquierda = false;
    private TranslateTransition moveTransition;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        // Crear un contenedor
        Pane root = new Pane();

        // Crear un cuadrado y agregarlo al contenedor
        square = new Rectangle(50, 50, 100, 100);
        square.setFill(Color.BLUE);
        root.getChildren().add(square);

        Button resetButton = new Button("Reiniciar");
        Button moveButton = new Button("Mover Derecha");
        moveButton.setLayoutX(10);
        moveButton.setLayoutY(10);

        // Configurar el evento del botón "Mover Derecha"
        moveButton.setOnAction(event -> {
            if (haciaIzquierda) {
                // Mover hacia la derecha
                moveTransition.setByX(40); // Mover 40 píxeles hacia la derecha
            } else {
                // Mover hacia la izquierda
                moveTransition.setByX(-40); // Mover 40 píxeles hacia la izquierda
            }
            haciaIzquierda = !haciaIzquierda; // Cambiar la dirección
            moveTransition.play();
        });

        // Configurar el evento del botón "Reiniciar"
        resetButton.setLayoutX(10);
        resetButton.setLayoutY(40);
        resetButton.setOnAction(event -> {
            // Restablecer la posición original sin animación
            square.setTranslateX(50);
            haciaIzquierda = false; // Asegurarse de que esté en la dirección correcta
        });

        root.getChildren().addAll(moveButton, resetButton);

        // Configurar la animación de movimiento hacia la derecha
        moveTransition = new TranslateTransition(Duration.seconds(0.3), square);
        moveTransition.setByX(40);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
