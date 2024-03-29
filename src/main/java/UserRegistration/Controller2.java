package UserRegistration;

import Excepciones.ErrorDesconocido;
import Interfaces.MetodosRegistro;
import Interfaces.MetodosUserDashBoard;
import UserDashboard.PaginaPrincipalDashboard;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 *  Clase que contiene los metodos para la pantalla de Login
 *  ( <---- Pantalla 2 ----> )
 */
public class Controller2 implements MetodosRegistro , MetodosUserDashBoard  {
    private Pane mainLayout2;
    private Button botonEntrar;
    private static final TextField numeroDeCelular = new TextField();
    private static final PasswordField passwordField = new PasswordField();
    private String nombreUsuario;

    public Controller2(){
        setupIU();
    }
    private void setupIU(){
        Cargarimagenes imagenes = new Cargarimagenes();
        ImageView BckG = imagenes.bienvenidaLogo();
        ToggleButton BotonMenu = imagenes.ImgMenu2();
        Controller1 controller1 = new Controller1();
        Button botonInicio = controller1.botonInicio();
        this.mainLayout2 = new Pane();
        this.mainLayout2.setId("PanelLogin");

        mainLayout2.getChildren().addAll(logoText(),BotonMenu,CampoContraseña(),CampoEmail(),OlvideContraseña(),Entrar(),Registrar(),botonInicio);
    }



    private TextField CampoEmail(){

        numeroDeCelular.setPrefWidth(230);
        numeroDeCelular.setId("LabelInicio");
        numeroDeCelular.setPromptText("Número celular");
        numeroDeCelular.setLayoutX(42);
        numeroDeCelular.setLayoutY(250);

        return numeroDeCelular;
    }
    private Label Contraseña(){
        Label label = new Label("Contraseña");
        label.setId("LabelRegistro");
        label.setLayoutX(124);
        label.setLayoutY(500);

        return label;
    }
    private PasswordField CampoContraseña(){
        passwordField.setId("LabelInicio");
        passwordField.setPrefWidth(230); // Ancho en píxeles
        passwordField.setPromptText("Contraseña");
        passwordField.setLayoutX(42);
        passwordField.setLayoutY(320);

        return passwordField;
    }

    private Button OlvideContraseña(){
        Button boton = new Button("Olvidé mi contraseña");
        boton.setId("BotonOlvido");

        boton.setLayoutX(84);
        boton.setLayoutY(365);
        boton.setOnAction(evento ->{
            System.out.println("Olvido COntraseña");

        });
        return boton;
    }
    private Button Entrar(){
        this.botonEntrar = new Button("Entrar");
        botonEntrar.setId("BotonEntrar");


        botonEntrar.setOpacity(0.5); // Establecer la opacidad al 50% (0.0 es completamente transparente, 1.0 es opaco)
        botonEntrar.setLayoutX(98);
        botonEntrar.setLayoutY(410);
        botonEntrar.setDisable(true);
        // Cambia el cursor al pasar el mouse por encima del botón
        botonEntrar.setOnMouseEntered(event -> {
            botonEntrar.setCursor(Cursor.HAND);
        });



        // Agregar oyentes al TextField y al PasswordField
        numeroDeCelular.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Texto en el TextField: " + newValue);

            if (!numeroDeCelular.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                botonEntrar.setDisable(false);
                botonEntrar.setOpacity(1);
            } else {
                botonEntrar.setOpacity(0.5);
                botonEntrar.setDisable(true);
            }

        });


        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Contraseña en el PasswordField: " + newValue);

            if (!numeroDeCelular.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                botonEntrar.setDisable(false);
                botonEntrar.setOpacity(1);
            } else {
                botonEntrar.setDisable(true);
                botonEntrar.setOpacity(0.5);
                System.out.println("Valores no introducidos");
            }
        });

        botonEntrar.setOnAction(event -> {

            String numeroUsuario = numeroDeCelular.getText();
            String contraseñaUsuario = passwordField.getText();
            if (clientesDAO.coincidenLosDatos(mainLayout2,numeroUsuario,contraseñaUsuario)) {

                System.out.println("Inicio de sesión exitoso");

                cargarDashBoard(0);
                /*
                Animaciones animaciones = new Animaciones();
                animaciones.animacionesEntrada();
                */
            } else {
                throw new ErrorDesconocido(mainLayout2,"Numero de celular invalido \n o el usuario no existe");
            }

        });

        return botonEntrar;
    }
    private Button Registrar(){
        Text textoNormal = new Text("¿Quieres usar la app AppleBank? ");
        textoNormal.setStyle("-fx-fill: #FFFFFF;");
        Text textoNegrita = new Text("¡Regístrate!");
        textoNegrita.setStyle("-fx-font-weight: bold; -fx-fill: white;"); // Aplicar el estilo al texto en negritas
        TextFlow textFlow = new TextFlow(textoNormal, textoNegrita);
        Button boton = new Button();

        boton.setId("Footer");
        boton.setGraphic(textFlow);
        boton.setLayoutX(10);
        boton.setLayoutY(600);
        boton.setWrapText(true); // Permite que el texto se ajuste al ancho del botón

        boton.setOnAction(event -> {
            cargarPantallaRegistroOpciones();
            System.out.println("Registro");

            //String url = "https://www.apple.com/mx/"; // Reemplaza con la URL que desees abrir

            //abrirPaginaWeb(url);



        });

        return boton;
    }
    public static void abrirPaginaWeb(String url) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo abrir el navegador web.");
        }
    }

    public String  getNumeroDeCelular() {
        return numeroDeCelular.getText();
    }

    public String getContraseña() {
        return passwordField.getText();
    }

    public String getNombreUsuario() {
        return null ;
    }

    public Pane getRoot() {
        return mainLayout2;
    }
}
