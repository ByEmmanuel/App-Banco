package UserRegistration;


import Interfaces.MetodosRegistro;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 * Clase que contiene los metodos para la vista de Captura de datos de login del usuario
 *   ( <---- Controller Registro Datos Login ----> )
 */
public class Controller5 implements MetodosRegistro {

    String[] arrayDeDatos = new String[6];

    Pane mainLayout6;



    private static final TextField campoEmail = new TextField();
    private final PasswordField campoContraseña = new PasswordField();
    private final PasswordField campoConfirmarContraseña = new PasswordField();
    private final TextField campoNumeroTelefono = new TextField();
    private final ComboBox<String> campoPreguntaDeSeguridad = new ComboBox<>();
    private final TextField campoRespuestaDeSeguridad = new TextField();



    public void continuarRegistro(String[] array){
        this.arrayDeDatos = array;

    }


    public Controller5(){
        setupIU();
    }

    private void setupIU(){
        Controller1 controller1 = new Controller1();
        mainLayout6 = new Pane();
        mainLayout6.setId("PanelRegistro");
        mainLayout6.getChildren().addAll(controller1.botonInicio(),label1(),botonComprobar(),botonRegresar(), panelSuperior(),campoEmail(),campoContraseña(),campoConfirmarContraseña(),campoNumeroTelefono(),campoPreguntaDeSeguridad(),campoRespuestaDeSeguridad(),botonContinuar());
    }

    private Button botonComprobar(){
        Button botonComprobar = new Button("Comprobar");
        botonComprobar.setId("botonComprobar");
        botonComprobar.setLayoutX(95);
        botonComprobar.setLayoutY(550);
        botonComprobar.setOnAction(e -> {

            /*
            System.out.println(CONTROLLER_4.cargarArray());

            for (int i = 0; i < arrayDeDatos.length; i++) {
                System.out.println(arrayDeDatos[i]);
            }

             */

            /*System.out.println("Nombre: " + nombre + "\n" +
                    "Primer Apellido: " + primerApellido + "\n" +
                    "Segundo Apellido: " + segundoApellido + "\n" +
                    "Nacionalidad: " + nacionalidad + "\n" +
                    "Fecha de Nacimiento: " + fechaDeNacimiento + "\n" +
                    "Estado donde nacio: " + estadoDondeNacio);*/

        });


        return botonComprobar;
    }
    Label label1(){
        Label label = new Label("¡Llena los siguientes Formularios. \n Estos seran tus credenciales \n de inicio de sesion!");
        label.setStyle("-fx-font-size: 18px");
        label.setLayoutX(25);
        label.setLayoutY(60);

        label.setId("");

        return label;

    }
    private TextField campoEmail (){

        campoEmail.setPromptText("Email");
        campoEmail.setPrefWidth(289);
        campoEmail.setLayoutX(20);
        campoEmail.setLayoutY(140);
        campoEmail.setId("campoRegistroDatosUsuario");

        return campoEmail;
    }
    private PasswordField campoContraseña (){

        campoContraseña.setPromptText("Contraseña");
        campoContraseña.setPrefWidth(289);
        campoContraseña.setLayoutX(20);
        campoContraseña.setLayoutY(210);
        campoContraseña.setId("campoRegistroDatosUsuario");

        return campoContraseña;
    }
    private PasswordField campoConfirmarContraseña (){

        campoConfirmarContraseña.setPromptText("Confirmar Contraseña");
        campoConfirmarContraseña.setPrefWidth(289);
        campoConfirmarContraseña.setLayoutX(20);
        campoConfirmarContraseña.setLayoutY(280);
        campoConfirmarContraseña.setId("campoRegistroDatosUsuario");

        return campoConfirmarContraseña;
    }
    private TextField campoNumeroTelefono (){

        campoNumeroTelefono.setPromptText("Numero de telefono");
        campoNumeroTelefono.setPrefWidth(289);
        campoNumeroTelefono.setLayoutX(20);
        campoNumeroTelefono.setLayoutY(350);
        campoNumeroTelefono.setId("campoRegistroDatosUsuario");

        return campoNumeroTelefono;
    }
    private ComboBox<String> campoPreguntaDeSeguridad (){

        campoPreguntaDeSeguridad.setPromptText("Pregunta de seguridad");
        campoPreguntaDeSeguridad.setPrefWidth(289);
        campoPreguntaDeSeguridad.setStyle("-fx-font-size: 13px ; -fx-font-family: 'Roboto Light' ; -fx-padding: 5px ;  ; -fx-border-width: 1px ; -fx-border-style: solid ;");
        campoPreguntaDeSeguridad.setLayoutX(20);
        campoPreguntaDeSeguridad.setLayoutY(420);
        campoPreguntaDeSeguridad.setId("campoRegistroDatosUsuario");

        campoPreguntaDeSeguridad.getItems().addAll("¿Cual es el nombre de tu primer mascota?",
                "¿Cual es el nombre de tu primer maestro?",
                "¿Cual es el nombre de tu primer mejor amigo?",
                "¿Cual es el nombre de tu primer novia?",
                "¿Cual es el nombre de tu primer novio?",
                "¿Cual es el nombre de tu primer amor?",
                "¿Cual es el nombre de tu primer hijo?",
                "¿Cual es el nombre de tu primer hija?",
                "¿Cual es el nombre de tu primer auto?",
                "¿Cual es el nombre de tu serie de tv favorita?",
                "¿Cual es el nombre de tu videojuego favorito?");

        return campoPreguntaDeSeguridad;
    }
    private TextField campoRespuestaDeSeguridad (){

        campoRespuestaDeSeguridad.setPromptText("Respuesta de seguridad");
        campoRespuestaDeSeguridad.setPrefWidth(289);
        campoRespuestaDeSeguridad.setLayoutX(20);
        campoRespuestaDeSeguridad.setLayoutY(490);
        campoRespuestaDeSeguridad.setId("campoRegistroDatosUsuario");

        return campoRespuestaDeSeguridad;
    }

    private Button botonContinuar(){
        Button boton = new Button("Continuar");
        boton.setId("BotonContinuarRegistro");
        boton.setLayoutX(95);
        boton.setLayoutY(570);
        boton.setDisable(true);

        // Agregar un oyente de eventos a todos los campos de texto
        campoEmail.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));
        campoContraseña.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));
        //campoConfirmarContraseña.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));
        campoNumeroTelefono.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));
        //campoPreguntaDeSeguridad.itemsProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));
        campoRespuestaDeSeguridad.textProperty().addListener((observable, oldValue, newValue) -> actualizarEstadoBoton(boton));


        /**
         * Algoritmo de registro
         */
        boton.setOnAction( event -> {

            boolean a = campoEmail.getText().matches("^[a-zA-Z0-9].{2,}$");
            boolean b = campoContraseña.getText().matches("^[a-zA-Z0-9].{2,}$");
            boolean c = campoNumeroTelefono.getText().matches("^[a-zA-Z0-9]{2,}$");
            boolean d = !campoPreguntaDeSeguridad.getValue().isEmpty();
            boolean e = campoRespuestaDeSeguridad.getText().matches("^[a-zA-Z0-9].{2,}$");
/*

            boolean a = campoEmail.getText().matches("^[a-zA-Z].{2,}$");
            boolean b = campoContraseña.getText().matches("^[a-zA-Z0-9].{2,}$");
            boolean c = campoNumeroTelefono.getText().matches("^[0-9]{9,}$");
            boolean d = campoPreguntaDeSeguridad.getValue().isEmpty();
            boolean e = campoRespuestaDeSeguridad.getText().matches("^[a-zA-Z].{2,}$");
*/

            String contraseña = campoContraseña.getText();
            //String confirmarContraseña = campoConfirmarContraseña.getText();
            String numeroTelefono = campoNumeroTelefono.getText();
            String preguntaDeSeguridad = campoPreguntaDeSeguridad.getValue().toString();
            String respuestaDeSeguridad = campoRespuestaDeSeguridad.getText();



            if (!a){
                System.out.println("Email Mal");
            } else if (!b) {
                System.out.println("Contraseña Mal");
            } else if (!c) {
                System.out.println("Numero Mal");
            }else if (!d) {
                System.out.println("Pregunta Mal");
            }else if (!e) {
                System.out.println("Respuesta Mal");
            } else {
                try {
                    clientesDAO.RegistrarDatosLoginUsuario(
                            campoEmail.getText(),
                            campoContraseña.getText(),
                            campoNumeroTelefono.getText(),
                            campoPreguntaDeSeguridad.getValue().toString(),
                            campoRespuestaDeSeguridad.getText()
                    );
                    cargarPaginaServiciosFinancieros();
                    System.out.println("Registro Completo");
                } catch (RuntimeException exception) {
                    System.out.println("Error al registrar los datos de inicio de sesión");
                }



            }
        });

        return boton;
    }

    private Button botonRegresar() {
        Button botonMenu = new Button("Regresar");
        botonMenu.setId("botonMenu");
        botonMenu.setLayoutX(95);
        botonMenu.setLayoutY(600);
        botonMenu.setOnAction(e -> {
            cargarPaginaRegistroDatos();


        });
        return botonMenu;
    }
    private void actualizarEstadoBoton (Button boton){
        // Lógica para habilitar o deshabilitar el botón
        if (!campoEmail().getText().isEmpty() &&
                !campoContraseña().getText().isEmpty() &&
                !campoConfirmarContraseña().getText().isEmpty() &&
                !campoNumeroTelefono().getText().isEmpty() &&
                !campoPreguntaDeSeguridad().getValue().isEmpty() &&
                !campoRespuestaDeSeguridad().getText().isEmpty()) {
            boton.setDisable(false);
            boton.setOpacity(1);
        } else {
            boton.setOpacity(0.4);
            boton.setDisable(true);
        }
    }

    /*private void actualizarEstadoBoton(Button boton) {
        // Lógica para habilitar o deshabilitar el botón
        if (!campoEmail().getText().isEmpty() &&
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
    }*/

    public static String getNombre() {
        return campoEmail.getText();
    }
    public Pane getRoot() {
        return mainLayout6;
    }
}
