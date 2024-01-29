package Pantallas;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/*
 * Esta ventana es de carga QUE ES DE PRUEBA
 */
public class VentanaDeCargaPrueba {

    Pane mainLayout;


    Rectangle cuadrado1 = cuadrado(0, 150, Color.RED);
    Rectangle cuadrado2 = cuadrado(0, 150, Color.BLUE);

    public VentanaDeCargaPrueba(){
        try {
            setupID2();
        } catch (Exception e) {}

    }


    private void setupID() throws Exception {

        this.mainLayout = new Pane();

        mainLayout.getChildren().addAll(cuadrado1,cuadrado2);

        //TranslateTransition translateTransition1 = crearTransicion(cuadrado1, -150);
        //TranslateTransition translateTransition2 = crearTransicion(cuadrado2, 150);

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(3), cuadrado1);
        translateTransition1.setFromX(0);   // Posición inicial en X
        translateTransition1.setFromY(208);   // Posición inicial en Y
        translateTransition1.setToX(266);   // Posición final en X
        translateTransition1.setToY(0);   // Posición final en Y
        translateTransition1.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition1.setAutoReverse(false);

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(3), cuadrado2);
        translateTransition2.setFromX(298);  // Posición inicial en X
        translateTransition2.setFromY(0);  // Posición inicial en Y
        translateTransition2.setToX(0);     // Posición final en X
        translateTransition2.setToY(328);     // Posición final en Y
        translateTransition2.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition2.setAutoReverse(false);


        translateTransition1.play();
        translateTransition2.play();
    }
    // Configurar animación para el segundo cuadrado (de derecha a izquierda)


    private Rectangle cuadrado(double x, double y, Color color) {
        Rectangle cuadrado = new Rectangle(x, y, 50, 50);
        cuadrado.setFill(color);
        return cuadrado;
    }

    private void setupID2() {

        this.mainLayout = new Pane();

        Label label = new Label("Apple");
        label.setStyle("-fx-font-size: 24px;");
        label.setLayoutX(100);
        label.setLayoutY(250);

        Label label2 = new Label("Bank");
        label2.setStyle("-fx-font-size: 24px;");
        label2.setLayoutX(180);
        label2.setLayoutY(150);


        mainLayout.getChildren().addAll(label,label2);

        //TranslateTransition translateTransition1 = crearTransicion(cuadrado1, -150);
        //TranslateTransition translateTransition2 = crearTransicion(cuadrado2, 150);

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(3), label);
        translateTransition1.setFromX(0);   // Posición inicial en X
        translateTransition1.setFromY(0);   // Posición inicial en Y
        translateTransition1.setToX(0);   // Posición final en X
        translateTransition1.setToY(0);   // Posición final en Y
        translateTransition1.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition1.setAutoReverse(false);

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1), label2);
        translateTransition2.setFromX(0);  // Posición inicial en X
        translateTransition2.setFromY(158);  // Posición inicial en Y
        translateTransition2.setToX(0);     // Posición final en X
        translateTransition2.setToY(80);     // Posición final en Y
        translateTransition2.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition2.setAutoReverse(false);


        translateTransition1.play();
        translateTransition2.play();
    }






    public Pane getRoot() {
        return mainLayout;
    }
}

