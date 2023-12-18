package Tests;


    import javafx.animation.*;
    import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
    import javafx.scene.layout.StackPane;
    import javafx.scene.paint.Color;
    import javafx.scene.paint.RadialGradient;
    import javafx.scene.paint.Stop;
    import javafx.scene.shape.Arc;
    import javafx.scene.shape.ArcType;
    import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

    public class PruebaCargaCirculo extends Application {
        @Override
        public void start(Stage primaryStage) {
            // Tamaño del círculo y del borde en píxeles
            double circleRadius = 25;
            double borderWidth = 6;

            Circle outerCircle = new Circle(circleRadius);
            Circle innerCircle = new Circle(circleRadius - borderWidth, Color.WHITE);
            RadialGradient gradient = new RadialGradient(
                    0,    // Foco del degradado (en porcentaje)
                    10,    // Centro del degradado (en porcentaje)
                    0.5,  // Radio del degradado (en porcentaje)
                    0,    // Foco del degradado exterior (en porcentaje)
                    0.5,  // Radio del degradado exterior (en porcentaje)
                    true, // Ciclo del degradado
                    null, // CycleMethod (puede ser null)
                    new Stop(0, Color.web("#156baa")),     // Color en el centro
                    new Stop(1, Color.web("#04417c")) // Color en la mitad
                    //new Stop(1, Color.web(""))     // Color en el exterior
            );

            // Establecer el degradado como relleno del círculo
            outerCircle.setFill(gradient);
            Pane pane = new Pane();
            pane.getChildren().addAll(outerCircle, innerCircle);
            StackPane root = new StackPane(outerCircle, innerCircle);

            // Crear una transición de rotación
            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), root);
            rotateTransition.setByAngle(360); // Gira 360 grados
            rotateTransition.setCycleCount(Animation.INDEFINITE); // Repetir indefinidamente


            primaryStage.setTitle("Hollow Circle");
            primaryStage.setScene(new Scene(root, 300, 250));

            primaryStage.show();
            rotateTransition.play();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }


