package UserDashboard;

import DAO.OperacionesDAO;
import Interfaces.MainInterfaceUser;
import UserRegistration.Animaciones;
import UserRegistration.Cargarimagenes;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import static Interfaces.MainInterfaceLogin.clientesDAO;


public class PaginaPrincipalDashboard implements MainInterfaceUser {


    Animaciones animaciones = new Animaciones();
    OperacionesDAO operacionesDAO = new OperacionesDAO();
    private static Pane mainLayout1 = new Pane();

    private static String telefono = null;
    static Cargarimagenes imagenes = new Cargarimagenes();

    //Estos valores son los que iran en el poligono de ingresos y siempre tienen que tener una distancia de 15
//    private static int ingresosX = 280;
//    private static int ingresosY = 265;

    private static int porcentajeIngresos;
    private static int porcentajeGastos = 90;

    //estos son de prueba
    private static int ingresosX;
    private static int ingresosY;

    private static int gastosX;
    private static int gastosY;

    //private static String nombre;
    //private static final String nombre  = clientesDAO.BuscarNombrePorTelefono(mainLayout1,"11");

    public PaginaPrincipalDashboard(){
        tamañoDeLaBarra();

        setupIU();
    }

    private void setupIU(){
        mainLayout1 = new Pane();
        mainLayout1.setId("Pane-Dashboard");


        mainLayout1.getChildren().addAll(fondo(),diaAdia(),verMas(),ingresosLabel(),gastosLabel(),ingresos$(),gastos$(),label1(),ingresos(),gastos(),hBox1(),hBox2());
        mainLayout1.setStyle("-fx-background-color: rgba(245,241,241,0.51);");


    }
    private Label diaAdia(){
        Label label = new Label("Mi Día A Día");
        label.setId("Label-Dashboard");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        label.setLayoutX(20);
        label.setLayoutY(60);

        return label;
    }

    private Button verMas(){
        Button button = new Button("Ver más");
        button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 13px;");
        button.setLayoutX(250);
        button.setLayoutY(60);

        button.setOnAction(event -> {
            System.out.println("Ver más pulsado");
        });

        return button;
    }
    private Label ingresosLabel(){
        Label label = new Label("Ingresos");
        label.setId("Label-Dashboard");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        label.setLayoutX(20);
        label.setLayoutY(100);

        return label;
    }
    private Label gastosLabel(){
        Label label = new Label("Gastos");
        label.setId("Label-Dashboard");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        label.setLayoutX(20);
        label.setLayoutY(150);

        return label;
    }
    private Label ingresos$(){
        int i = 0;
        Label label = new Label("$" + i);
        label.setOnMouseClicked(event -> {
            int j = 10;
            int k = i + j;
            label.setText("$" + k);


        });
        label.setId("Label-Dashboard");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        label.setLayoutX(250);
        label.setLayoutY(100);

        return label;
    }
    private Label gastos$(){
        Label label = new Label("$" + porcentajeGastos);
        label.setId("Label-Dashboard");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 13px;");
        label.setLayoutX(250);
        label.setLayoutY(150);

        return label;
    }
    private Polygon ingresos(){
        Polygon barra1 = new Polygon(
                15, 0,   // Punto superior izquierdo
                ingresosX, 0,  // Punto superior derecho
                ingresosY, 15,   // Punto inferior derecho (formando la diagonal)
                0, 15    // Punto inferior izquierdo
        );
        barra1.setLayoutX(20);
        barra1.setLayoutY(130);

        barra1.setOnMouseClicked(event -> {
            porcentajeIngresos = porcentajeIngresos + 10;
            System.out.println(porcentajeIngresos);


        });
        barra1.setFill(Color.valueOf("yellow")); // Puedes cambiar el color según tus preferencias
        //2a93d9
        return barra1;
    }
    private Polygon gastos(){
        Polygon barra1 = new Polygon(
                15, 0,   // Punto superior izquierdo
                gastosX, 0,  // Punto superior derecho
                gastosY, 15,   // Punto inferior derecho (formando la diagonal)
                0, 15    // Punto inferior izquierdo
        );
        barra1.setLayoutX(20);
        barra1.setLayoutY(180);


        barra1.setFill(Color.valueOf("blue")); // Puedes cambiar el color según tus preferencias
        //2a93d9
        return barra1;
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
        Pane.getChildren().addAll(label2(),labelCantidad(),labelNumCuenta());

        return Pane;
    }
    private Label labelCantidad(){
        Label label = new Label();
        //Esto esta puesto asi por si le tengo que pasar un valor
        String ingresos = String.valueOf(operacionesDAO.BuscarSaldoPorTelefono(""));
        label.setText("$" + ingresos);
        label.setLayoutX(150);
        label.setLayoutY(30);
        label.setStyle("-fx-font-size: 14px");

        return label;
    }
    private Label labelNumCuenta (){
        Label label = new Label();
        //Esto esta puesto asi por si le tengo que pasar un valor
        String numCuenta = operacionesDAO.BuscarNumCuentaPorTelefono("");
        label.setText(numCuenta);
        label.setLayoutX(15);
        label.setLayoutY(80);
        label.setStyle("-fx-font-size: 14px");

        return label;
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
        Pane.getChildren().addAll(label3(),tarjeta());

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
    private Label tarjeta(){
        Label label = new Label();
        //Esto esta en comillas para que no me de error de momento
        String tarjeta = operacionesDAO.BuscarTarjetaPorTelefono("");
        label.setText(tarjeta);
        label.setLayoutX(15);
        label.setLayoutY(100);
        label.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        return label;
    }


    private void tamañoDeLaBarra(){
        int saldo = 10000;
        if (saldo >= 10000) {
            porcentajeIngresos = 100;
        } else if (saldo >= 9000) {
            porcentajeIngresos = 90;
        } else if (saldo >= 8000) {
            porcentajeIngresos = 80;
        } else if (saldo >= 7000) {
            porcentajeIngresos = 70;
        } else if (saldo >= 6000) {
            porcentajeIngresos = 60;
        } else if (saldo >= 5000) {
            porcentajeIngresos = 50;
        } else if (saldo >= 4000) {
            porcentajeIngresos = 40;
        } else if (saldo >= 3000) {
            porcentajeIngresos = 30;
        } else if (saldo >= 2000) {
            porcentajeIngresos = 20;
        } else if (saldo >= 1000) {
            porcentajeIngresos = 10;
        } else if (saldo >= 0) {
            porcentajeIngresos = 0;
        } else {
            porcentajeIngresos = 0;
        }

        switch (porcentajeIngresos){
//            case 10:
//                ingresosX = 10;
//                ingresosY = 5;
//                break;
            case 20:
                ingresosX = 50;
                ingresosY = 35;
                break;
            case 30:
                ingresosX = 80;
                ingresosY = 65;
                break;
            case 40:
                ingresosX = 110;
                ingresosY = 95;
                break;
            case 50:
                ingresosX = 140;
                ingresosY = 125;
                break;
            case 60:
                ingresosX = 170;
                ingresosY = 155;
                break;
            case 70:
                ingresosX = 200;
                ingresosY = 185;
                break;
            case 80:
                ingresosX = 230;
                ingresosY = 215;
                break;
            case 90:
                ingresosX = 260;
                ingresosY = 245;
                break;
            case 100:
                ingresosX = 290;
                ingresosY = 275;
                break;
            default:
                ingresosX = 40;
                ingresosY = 25;
                break;
        }

    }



    public Pane getRoot(){

        return mainLayout1;
    }
}
