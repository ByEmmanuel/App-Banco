package Pantallas;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SuperponerElementos extends Application {


    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

    Circle circulo = new Circle(50, Color.BLUE);
    Rectangle cuadrado = new Rectangle(200, 200, Color.RED);
        cuadrado.setOpacity(1); // Establecer la opacidad inicial del cuadrado

        root.getChildren().addAll(cuadrado, circulo);

    Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    // Definir una animación para cambiar la opacidad del cuadrado después de 1 segundo
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), new KeyValue(circulo.opacityProperty(), 1)),
            new KeyFrame(Duration.seconds(2), new KeyValue(circulo.opacityProperty(), 0))
    );

        timeline.play();
}
    public static void main(String[] args) {
        launch(args);
    }
}