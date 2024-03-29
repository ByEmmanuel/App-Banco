package UserDashboard;

import DAO.OperacionesDAO;
import Interfaces.MainInterfaceUser;
import UserRegistration.Animaciones;
import UserRegistration.Cargarimagenes;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import static Interfaces.MainInterfaceLogin.clientesDAO;
import static Interfaces.MainInterfaceLogin.controller2;


public class PaginaPrincipalDashboard implements MainInterfaceUser {


    Animaciones animaciones = new Animaciones();
    OperacionesDAO operacionesDAO = new OperacionesDAO();
    private static Pane mainLayoutDashboard = new Pane();
    private Pane paneUno = new Pane();
    private Pane paneDos = new Pane();

    private static String telefono = null;
    static Cargarimagenes imagenes = new Cargarimagenes();

    private String nombreUsuarioLogEd;
    private Label labelSaldo = new Label();

    private Label labelSaldo2 = new Label();

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
    private String numTelefonoLogeado = controller2.getNumeroDeCelular();
    String ingresos = String.valueOf(operacionesDAO.BuscarSaldoPorTelefono(numTelefonoLogeado));



    //private static String nombre;
    //private static final String nombre  = clientesDAO.BuscarNombrePorTelefono(mainLayout1,"11");

    public PaginaPrincipalDashboard(){
        tamañoDeLaBarra();
        //actualizarPantallas();
        Platform.runLater(this::actualizarPantallas);
        setupIU();
    }

    private void setupIU(){
        Cargarimagenes imagenes = new Cargarimagenes();
        Button transferir = imagenes.transferir();
        Button oportunidades = imagenes.oportunidades();
        Button retiroSinTrjt = imagenes.retiroSinTrjt();
        Button tresPuntos = imagenes.botonTresPuntos();


        mainLayoutDashboard = new Pane();
        mainLayoutDashboard.setId("Pane-Dashboard");




        mainLayoutDashboard.getChildren().addAll(fondo(),transferir,oportunidades,retiroSinTrjt,tresPuntos,labelSaldo(),
                diaAdia(),verMas(),ingresosLabel(),gastosLabel(),ingresos$(),gastos$(),label1(),ingresos(),gastos(),hBox1(),hBox2()
                ,botonPrueba());
        mainLayoutDashboard.setStyle("-fx-background-color: rgba(245,241,241,0.51);");

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
        this.nombreUsuarioLogEd = clientesDAO.BuscarNombrePorTelefono(mainLayoutDashboard,telefono);
        label.setText("Hola, " + nombreUsuarioLogEd);
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

    /**
     * NO SE ACTUALIZA EL VALOR CUANDO LLAMO VARIAS VECES A LA BASE DE DATOS Y NO RESUELVE EL PROBLEMA
     * DE ACTUALIZAR EL LABEL AL HACER UNA TRANSFERENCIA
     * @return
     */
    private Pane hBox1(){

        paneUno.setLayoutX(20);
        paneUno.setLayoutY(280);
        //BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        //Background background = new Background(backgroundFill);
        paneUno.setId("Pane-UserDashBoard");
        //Pane.setBackground(background);
        // Configurar relleno programáticamente

        //Esto esta puesto asi por si le tengo que pasar un valor


//        labelSaldo.setText("$"+ingresos);
//        labelSaldo.setLayoutX(190);
//        labelSaldo.setLayoutY(50);
//        labelSaldo.setStyle("-fx-font-size: 18px");

        Label label2 = new Label("Cuentas En Pesos");
        label2.setLayoutX(15);
        label2.setLayoutY(20);
        label2.setStyle("-fx-font-size: 14px");




        actualizarPantallas();
        paneUno.setPadding(new Insets(0, 140, 0, 15)); // Padding: arriba, derecha, abajo, izquierda
        paneUno.getChildren().add(label2);
        //paneUno.getChildren().add(labelSaldo);
        paneUno.getChildren().add(labelNumCuenta());
        paneUno.getChildren().add(datosCuenta());
        paneUno.getChildren().add(saldoDisponible());

        return paneUno;
    }
    private Label labelSaldo(){
        Label label = new Label();
        // Este metodo solo muestra el saldo del usuario solamente cuando se carga toda la applicacion,
        // para fines de testeo esto se muestra como 0.00
        String saldo = this.ingresos;
        label.setText("$"+saldo);
        label.setLayoutX(190);
        label.setLayoutY(50);
        label.setStyle("-fx-font-size: 18px");

        return label;

    }
    private Label datosCuenta(){
        Label label = new Label();

        label.setText(obtenerDatosCuenta());
        label.setLayoutX(15);
        label.setLayoutY(50);
        label.setStyle("-fx-font-size: 18px; -fx-text-fill: #1b74bc");

        return label;
    }
    private Label labelNumCuenta (){
        Label label = new Label();
        //Esto esta puesto asi por si le tengo que pasar un valor
        String numCuenta = operacionesDAO.BuscarNumCuentaPorTelefono("");
        label.setText("· " + numCuenta);
        label.setLayoutX(15);
        label.setLayoutY(75);
        label.setStyle("-fx-font-size: 14px");

        return label;
    }
    private Label saldoDisponible(){
        Label label = new Label();

        label.setText("Saldo Disponible");
        label.setLayoutX(170);
        label.setLayoutY(75);
        label.setStyle("-fx-font-size: 12px");

        return label;
    }
    private Pane hBox2(){

        actualizarPantallas();

        paneDos.setLayoutX(20);
        paneDos.setLayoutY(420);
        //BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        //Background background = new Background(backgroundFill);
        paneDos.setId("Pane-UserDashBoard");
        //Pane.setBackground(background);
        // Configurar relleno programáticamente
        paneDos.setPadding(new Insets(0, 140, 0, 15)); // Padding: arriba, derecha, abajo, izquierda
        paneDos.getChildren().addAll(label3(),tarjeta());

        return paneDos;
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
        label.setText("· "+tarjeta);
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
    public String obtenerDatosCuenta(){
        //Esto esta puesto asi por si le tengo que pasar un valor
        getNombreUsuarioLogEd();
        String numCuenta = operacionesDAO.BuscarNumCuentaPorTelefono("");
        String tipoDeCuenta = operacionesDAO.BuscarTipoDeCuentaPorTelefono("");;
        String numTarjeta = operacionesDAO.BuscarTarjetaPorTelefono("");
        String datos = numTarjeta + tipoDeCuenta + numCuenta;
        return datos;
    }

    /**
     * Este metodo no sirve :/
     */
    public void actualizarPantallas() {

        //labelSaldo.setText("%");
        //paneUno.getChildren().remove(labelSaldo);
        System.out.println("Iniciando la actualización de pantallas...");
    
        new Thread(() -> {
            try {
                Thread.sleep(100);
                System.out.println("El Hilo actual es; " + Thread.currentThread());
                System.out.println("Espera completada");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    
            try {

                //System.out.println("Nuevo saldo obtenido: " );
    
                Platform.runLater(() -> {

                    if(paneUno.getChildren().contains(labelSaldo2) || mainLayoutDashboard.getChildren().contains(labelSaldo2)){
                        mainLayoutDashboard.getChildren().remove(labelSaldo2);
                        paneUno.getChildren().remove(labelSaldo2);
                    }

                    //mainLayoutDashboard.getChildren().removeAll(labelSaldo,labelNumCuenta(),datosCuenta(),saldoDisponible());


                    // Resto de la lógica de actualización...
                    /**
                     * LLAMANDO A LA BASE DE DATOS DESDE AQUI CON EL NOMBRE DE USUARIO
                     */


                    //labelSaldo2.setText("$"+ingresos);
                    paneUno.getChildren().add(labelSaldo2);
                    labelSaldo2.setLayoutX(190);
                    labelSaldo2.setLayoutY(50);
                    labelSaldo2.setStyle("-fx-font-size: 18px");

                    labelSaldo2.setText("$" + operacionesDAO.BuscarSaldoPorNombre(nombreUsuarioLogEd));

                    //paneUno.getChildren().removeAll(labelSaldo);
                    if (paneUno.getChildren().contains(labelSaldo)|| mainLayoutDashboard.getChildren().contains(labelSaldo)){
                        paneUno.getChildren().remove(labelSaldo);
                    }



                    System.out.println("El saldo del label es: " + labelSaldo2.getText());
                    //paneUno.getChildren().add(labelSaldo);
                });
            } catch (Exception ex) {
                ex.printStackTrace();  
            }
        }).start();
    }
    public String getSaldo() {
        return ingresos;
    }

    public Pane getRoot(){
        return mainLayoutDashboard;
    }

    private Button botonPrueba(){
        Button button = new Button("Prueba");
        button.setLayoutX(50);
        button.setLayoutY(50);

        button.setOnAction(event -> {
            //labelSaldo.setText("Prueba");
            actualizarPantallas();
            System.out.println("AAAAA");
        });

        return button;
    }


    public String getNombreUsuarioLogEd() {
        operacionesDAO.inicioSesionUsuario(nombreUsuarioLogEd);
        //System.out.println(nombreUsuarioLogEd);
        return nombreUsuarioLogEd;
    }
}
