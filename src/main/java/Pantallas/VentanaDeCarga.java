package Pantallas;

import Interfaces.MetodosRegistro;
import Interfaces.MetodosUserDashBoard;
import UserRegistration.Animaciones;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import static Interfaces.MainInterfaceLogin.primaryStage;
/*
 * Esta es la ventana de carga dentro de la aplicacion
 * para disimular la carga de elementos
 */
public class VentanaDeCarga {

    /*
     * Esta ventana simula ser una ventana de carga, que realmente 
     * no tiene finalidad y de momento solo 
     * se ve al querer cargar algunas cosas
     */
    private Pane mainLayoutCarga;
    double circleRadius = 25;
    double borderWidth = 6;

    public VentanaDeCarga(){

        setupUI();

    }

    private void setupUI(){
        this.mainLayoutCarga = new Pane();
        mainLayoutCarga.setMaxSize(50,50);
        mainLayoutCarga.setLayoutX(140);
        mainLayoutCarga.setLayoutY(238);
        mainLayoutCarga.setId("PanelCarga");
        mainLayoutCarga.getChildren().addAll(circuloInterno(),circuloExterno());
        this.mainLayoutCarga.setVisible(true);
        cargarAnimacion();
    }

    private Circle circuloInterno(){
        Circle circuloInterno = new Circle(circleRadius);
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

                    //esto es para fines de testeo
                    //new Stop(0, Color.web("red")),     // Color en el exterior
                    //new Stop(1, Color.web("blue"))     // Color en el exterior
            );
        circuloInterno.setFill(gradient);


        circuloInterno.setId("CirculoInterno");
        // Centrar el círculo interno en el centro del Pane

        circuloInterno.centerXProperty().bind(mainLayoutCarga.widthProperty().divide(2));
        circuloInterno.centerYProperty().bind(mainLayoutCarga.heightProperty().divide(2));


        return circuloInterno;
    }

    private Circle circuloExterno(){
        Circle circuloExterno = new Circle(circleRadius - borderWidth, Color.WHITE);
        circuloExterno.centerXProperty().bind(mainLayoutCarga.widthProperty().divide(2));
        circuloExterno.centerYProperty().bind(mainLayoutCarga.heightProperty().divide(2));

        circuloExterno.setId("CirculoExterno");
        return circuloExterno;
    }
    private void cargarAnimacion(){
       // Crear una transición de rotación
            RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), mainLayoutCarga);
            rotateTransition.setFromAngle(0);

            rotateTransition.setByAngle(360); // Gira 360 grados
            rotateTransition.setCycleCount(Animation.INDEFINITE); // Repetir indefinidamente
            rotateTransition.play();
            //cerrarVentanaDeCarga();
    }

    /*
     * Este método oculta la ventana, y esto ocasiona que no se pueda seguir viendo mas al
     * momento de llamar a esta clase (VentanaDeCarga)
     */
    private void cerrarVentanaDeCarga(){
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Espera durante el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                try {
                    //this.mainLayoutCarga.setVisible(false);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();
    }
    public void rapida(){

    }


    public Pane getRoot(){
        return mainLayoutCarga;
    }
}
