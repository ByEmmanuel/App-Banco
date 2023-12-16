package UserRegistration;

import Interfaces.MetodosRegistro;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Clase que contiene los metodos para la vista de Captura de datos del usuario
 *  ( <---- ControllerRegistroDatosUsuario ----> )
 */

public class Controller4 implements MetodosRegistro {

    Controller5 controller5 = new Controller5();

    private static final TextField campoNombre = new TextField();
    private final TextField campoPrimerApellido = new TextField();
    private final TextField campoSegundoApellido = new TextField();
    private final TextField campoNacionalidad = new TextField();
    private final TextField campoFechaDeNacimiento = new TextField();
    private final ComboBox<String> campoLugarDondeNacio = new ComboBox<>();

    private Pane mainLayout5;


    String[] arrayDeDatos = new String[6];


    public Controller4(){
        setupIU();
    }

    private void setupIU(){


        Button botonMenu = Controller1.controller1.botonInicio();
        this.mainLayout5 = new Pane();
        this.mainLayout5.setId("PanelRegistro");

        mainLayout5.getChildren().addAll(panelSuperior(),label1(),campoNombre(),
                campoApellidoMaterno(),campoApellidoPaterno(), campoNacionalidad(),
                campoFechaDeNacimiento(),botonContinuar(),boton2(),botonLugarDeNacimiento(),botonMenu);


    }


    public Label label(){
        Label label = new Label("IDk");
        label.setLayoutX(200);
        label.setLayoutY(200);

        label.setId("IDK");

        return label;
    }
    private Label label1(){
        Label label = new Label("¡Llena tus datos En Esta Seccion, \n Al finalizar, Da click en Continuar!");
        label.setStyle("-fx-font-size: 19px");
        label.setLayoutX(20);
        label.setLayoutY(80);

        label.setId("");

        return label;

    }
    private TextField campoNombre (){

        campoNombre.setPromptText("Nombre");
        campoNombre.setPrefWidth(289);
        campoNombre.setLayoutX(20);
        campoNombre.setLayoutY(150);
        campoNombre.setId("campoRegistroDatosUsuario");

        return campoNombre;
    }
    private TextField campoApellidoPaterno (){

        campoPrimerApellido.setPromptText("Primer Apellido");
        campoPrimerApellido.setPrefWidth(289);
        campoPrimerApellido.setLayoutX(20);
        campoPrimerApellido.setLayoutY(230);
        campoPrimerApellido.setId("campoRegistroDatosUsuario");

        return campoPrimerApellido;
    }
    private TextField campoApellidoMaterno (){

        campoSegundoApellido.setPromptText("Segundo Apellido");
        campoSegundoApellido.setPrefWidth(289);
        campoSegundoApellido.setLayoutX(20);
        campoSegundoApellido.setLayoutY(290);
        campoSegundoApellido.setId("campoRegistroDatosUsuario");

        return campoSegundoApellido;
    }
    private TextField campoNacionalidad(){

        campoNacionalidad.setPromptText("Campo nacionalidad");
        campoNacionalidad.setPrefWidth(289);
        campoNacionalidad.setLayoutX(20);
        campoNacionalidad.setLayoutY(350);
        campoNacionalidad.setId("campoRegistroDatosUsuario");

        return campoNacionalidad;
    }
    private TextField campoFechaDeNacimiento(){

        campoFechaDeNacimiento.setPromptText("Fecha de nacimiento (AAAA-MM-DD)");
        campoFechaDeNacimiento.setPrefWidth(289);
        campoFechaDeNacimiento.setLayoutX(20);
        campoFechaDeNacimiento.setLayoutY(410);
        campoFechaDeNacimiento.setId("campoRegistroDatosUsuario");

        return campoFechaDeNacimiento;
    }
    private Button botonContinuar(){
        Button boton = new Button("Continuar");
        boton.setId("BotonEntrar");
        boton.setLayoutX(95);
        boton.setLayoutY(570);
        boton.setDisable(true);

        // Agregar un oyente de eventos a todos los campos de texto
        campoNombre.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));
        campoPrimerApellido.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));
        campoSegundoApellido.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));
        campoNacionalidad.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));
        campoFechaDeNacimiento.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));


        /**
         * Algoritmo de registro
         */
        boton.setOnAction( event -> {

            boolean a = campoNombre.getText().matches("^[a-zA-Z].{2,}$");
            boolean b = campoPrimerApellido.getText().matches("^[a-zA-Z].{3,}$");
            boolean c = campoNacionalidad.getText().matches("^[a-zA-Z].{4,}$");
            boolean d = campoFechaDeNacimiento.getText().matches("^[0-9].{4,}$");
            boolean e = campoLugarDondeNacio.getValue().matches("^[a-zA-Z].{2,}$");


            String nombre = campoNombre.getText();
            String primerApellido = campoPrimerApellido.getText();
            String segundoApellido = campoSegundoApellido.getText();
            String nacionalidad = campoNacionalidad.getText();
            String fechaDeNacimiento = campoFechaDeNacimiento.getText();
            String lugarDondeNacio = campoLugarDondeNacio.getValue().toString();



            if (!a){
                System.out.println("Nombre Mal");
            } else if (!b) {
                System.out.println("Apellido Mal");
            } else if (!c) {
                System.out.println("Numero Mal");
            }else if (!d) {
                System.out.println("Fecha Mal");
            }else if (!e) {
                System.out.println("Lugar Mal");
            } else {

//
//                clientesDAO.RegistrarDatosUsuario(
//                        campoNombre.getText(),
//                        campoPrimerApellido.getText(),
//                        campoSegundoApellido.getText(),
//                        campoNacionalidad.getText(),
//                        campoFechaDeNacimiento.getText(),
//                        campoLugarDondeNacio.getValue().toString());



                //controller6.continuarRegistro(array);
                //controller6.continuarRegistro2(nombre, primerApellido, segundoApellido, nacionalidad, fechaDeNacimiento, lugarDondeNacio);


                cargarPaginaRegistroDatos2();
                System.out.println("Registro Completo");
            }
        });

        return boton;
    }
    ComboBox<String> botonLugarDeNacimiento (){
        campoLugarDondeNacio.setId("ComboBox");
        campoLugarDondeNacio.setLayoutX(20);
        campoLugarDondeNacio.setLayoutY(470);
        campoLugarDondeNacio.setPrefWidth(289);
        campoLugarDondeNacio.setPromptText("Lugar de Nacimiento");
        campoLugarDondeNacio.getItems().addAll("Aguascalientes","Baja California",
                "Baja California Sur","Campeche","Chiapas","Chihuahua","Coahuila",
                "Colima","Durango","Estado de México","Guanajuato","Guerrero","Hidalgo",
                "Jalisco","Michoacán","Morelos","Nayarit","Nuevo León","Oaxaca","Puebla",
                "Querétaro","Quintana Roo","San Luis Potosí","Sinaloa","Sonora","Tabasco",
                "Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas");

        return campoLugarDondeNacio;
    }

    /**
     * metodo para verificar los campos (debugger)
     *
     */
    private Button boton2 (){
        Button boton = new Button();
        boton.setText("Comprobar campos");
        boton.setLayoutX(25);
        boton.setLayoutY(500);
        boton.setOnAction( event ->{
            System.out.println(campoNombre.getText() + " \n "+ campoApellidoPaterno().getText()+ " \n " + campoApellidoMaterno().getText()+ " \n " + campoNacionalidad().getText()+ " \n " + campoFechaDeNacimiento().getText());

        });

        return boton;

    }
    private void actualizarEstadoBoton(Button boton) {
        // Lógica para habilitar o deshabilitar el botón
        if (!campoNombre().getText().isEmpty() &&
                !campoApellidoPaterno().getText().isEmpty() &&
                !campoApellidoMaterno().getText().isEmpty() &&
                !campoNacionalidad().getText().isEmpty() &&
                !campoFechaDeNacimiento().getText().isEmpty()) {
            boton.setDisable(false);
            boton.setOpacity(1);
        } else {
            boton.setOpacity(0.4);
            boton.setDisable(true);
        }
    }

    public String cargarArray(){
        arrayDeDatos = new String[]{
                campoNombre.getText(),
                campoPrimerApellido.getText(),
                campoSegundoApellido.getText(),
                campoNacionalidad.getText(),
                campoFechaDeNacimiento.getText(),
                campoLugarDondeNacio.getValue().toString()
        };
        return arrayDeDatos.toString();
    }

    /*
     * Metodos no usados
     *  cargarregistro
     * e imprimir array
     */
    public void CargarRegistroDatosUsuario2(String[] array){
        Controller5 controller5 = new Controller5();
        controller5.continuarRegistro(array);
    }

    public String[] imprimirArray(String[] array){
        return array;
    }

    public static String getCampoNombre() {
        return campoNombre.getText();
    }

    public Pane getRoot(){
        return mainLayout5;
    }
}
