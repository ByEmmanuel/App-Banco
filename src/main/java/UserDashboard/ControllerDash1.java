package UserDashboard;

import UserRegistration.Animaciones;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import static Interfaces.MainInterfaceLogin.clientesDAO;


public class ControllerDash1  {


    Animaciones animaciones = new Animaciones();
    private static Pane mainLayout1 = new Pane();

    private static String telefono = null;
    //private static String nombre;
    //private static final String nombre  = clientesDAO.BuscarNombrePorTelefono(mainLayout1,"11");

    public ControllerDash1(){
        setupIU();


    }

    private void cargaAnimacion(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(javafx.util.Duration.seconds(1));
        transition.setNode(mainLayout1);
        transition.setToX(200);
        transition.setToY(100);
        transition.play();
    }

    private void setupIU(){
        mainLayout1 = new Pane();
        mainLayout1.setId("Pane-Dashboard");

        mainLayout1.getChildren().addAll(fondo(),label1(),hBox1(),hBox2());
        mainLayout1.setStyle("-fx-background-color: rgba(245,241,241,0.51);");


    }


    private Label label1(){
        Label label = new Label();
        label.setId("");
        label.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: white;");

        /**
         *  El parametro telefono llega null siempre por si despues tengo
         *  que hacer ajustes
         */
        label.setText("Hola, " + clientesDAO.BuscarNombrePorTelefono(mainLayout1,telefono));
        label.setLayoutX(100);
        label.setLayoutY(20);

        return label;
    }

    Polygon fondo(){
        // Crear un triángulo para representar la parte inferior diagonal
        // Crear un polígono para representar el cuadrado con la parte inferior en diagonal
        Polygon diagonal = new Polygon(
                0, 0,   // Punto superior izquierdo
                328, 0,  // Punto superior derecho
                328, 320,   // Punto inferior derecho (formando la diagonal)
                0, 400    // Punto inferior izquierdo
        );
        diagonal.setLayoutX(0);
        diagonal.setLayoutY(0);
        diagonal.setFill(Color.valueOf("156baa")); // Puedes cambiar el color según tus preferencias
                                        //2a93d9
        return diagonal;
    }

    private Pane hBox1(){
        Pane Pane = new Pane();
        Pane.setLayoutX(20);
        Pane.setLayoutY(280);
        //BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        //Background background = new Background(backgroundFill);
        Pane.setId("Pane-UserDashBoard");
        //Pane.setBackground(background);
        // Configurar relleno programáticamente
        Pane.setPadding(new Insets(0, 140, 0, 15)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(label2());

        return Pane;
    }
    private Pane hBox2(){
        Pane Pane = new Pane();
        Pane.setLayoutX(20);
        Pane.setLayoutY(420);
        //BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        //Background background = new Background(backgroundFill);
        Pane.setId("Pane-UserDashBoard");
        //Pane.setBackground(background);
        // Configurar relleno programáticamente
        Pane.setPadding(new Insets(0, 140, 0, 15)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(label3());

        return Pane;
    }

    Label label2(){
        Label label = new Label("Cuentas En Pesos");
        label.setLayoutX(15);
        label.setLayoutY(30);
        label.setStyle("-fx-font-size: 14px");

        return label;
    }
    Label label3(){
        Label label = new Label("TARJETAS");
        label.setLayoutX(15);
        label.setLayoutY(30);
        label.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        return label;
    }

    public Pane getRoot(){
        return mainLayout1;
    }
}
