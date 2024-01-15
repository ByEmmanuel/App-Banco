package UserRegistration;

import Interfaces.MetodosRegistro;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Clase que contiene los metodos para la vista de Registro de persona si tiene tarjeta
 *  ( <---- ControllerRegistroPersona ----> )
 */
public class ControllerRegistroPersona implements MetodosRegistro {

    Cargarimagenes imagenes = new Cargarimagenes();
    Button botonMenu = imagenes.ImgMenu3();
    Pane mainLayout4;

    public ControllerRegistroPersona(){
        setupIU();
    }
    private void setupIU(){

        ControllerRegistroEmpresas controllerRegistroEmpresas = new ControllerRegistroEmpresas();

        this.mainLayout4 = new Pane();
        //this.mainLayout4.setId("PanelRegistroPersona");

        mainLayout4.getChildren().addAll(pane1(),pane2());


    }
    private Pane pane1(){
        Pane Pane = new Pane();
        Pane.setLayoutX(0);
        Pane.setLayoutY(0);
        Pane.setId("PanelRegistroPersona");
        Pane.setPadding(new Insets(3, 60, 10, 20)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(texto(),h1(),h2());

        return Pane;
    }
    private Label texto(){
        Label label = new Label(" Registro ");
        label.setId("h3-RegistroPersona");
        label.setLayoutX(134);
        label.setLayoutY(10);
        return label;
    }
    private Label h1(){
        Label label = new Label(" Contrata y activa sin costo los servicios \n" +
                "                    digitales Apple Bank ");
        label.setId("h1_Registro");
        label.setLayoutX(17);
        label.setLayoutY(95);
        return label;
    }
    private Label h2(){
        Label label = new Label("Ingresa a nuestras aplicaciones con tu número de \n" +
                "                    celular y una sola contraseña.");
        label.setId("h3-RegistroPersona");
        label.setLayoutX(17);
        label.setLayoutY(145);
        return label;
    }
    private Pane pane2(){
        Pane Pane = new Pane();
        Pane.setLayoutX(0);
        Pane.setLayoutY(190);
        Pane.setId("PanelIdentificate");
        Pane.setPadding(new Insets(3, 330, 636, 20)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(h1Pane2(),h2Pane2(),numeroDeCelular(),NumeroDeTarjeta(),boton1(),boton2(),infoText(),infoText2(),
                continuar(),AvisoDePrivacidad(),label2(),noTengoTarjeta());

        return Pane;
    }
    private Label h1Pane2(){
        Label label = new Label("IDENTIFÍCATE");

        label.setId("h1_Registro");
        label.setLayoutX(17);
        label.setLayoutY(20);
        return label;
    }

    private Label h2Pane2(){
        Label label = new Label("Ingresa los siguientes datos para iniciar el proceso \n" +
                "de contratación y activación:");
        label.setId("h3-RegistroPersona");
        label.setLayoutX(17);
        label.setLayoutY(55);
        return label;
    }

    private TextField numeroDeCelular(){
        TextField textField = new TextField();
        textField.setId("TextFieldNumeroCelularRegistro");
        textField.setPromptText("Número de celular");
        textField.setLayoutX(17);
        textField.setLayoutY(105);


        return textField;
    }
    private TextField NumeroDeTarjeta(){
        TextField textField = new TextField();
        textField.setId("TextFieldNumeroCelularRegistro");
        textField.setLayoutX(17);
        textField.setLayoutY(205);
        textField.setPromptText("Número de tarjeta / QR");


        return textField;
    }
    private Button boton1 (){
        Button boton = new Button();
        boton.setId("InfoRegistroPersona");
        boton.setLayoutX(25);
        boton.setLayoutY(160);
        boton.setText("¡");


        return boton;
    }
    private Button boton2 (){
        Button boton = new Button();
        boton.setId("InfoRegistroPersona");
        boton.setLayoutX(25);
        boton.setLayoutY(260);
        boton.setText("¡");


        return boton;
    }

    private Label infoText(){
        Label label = new Label();
        label.setStyle("-fx-font-size: 11px; -fx-text-fill: white;");
        label.setText("Escribe el número celular registrado (o que deseas \n" +
                "   registrar) en tu cuenta Apple Bank.");
        label.setLayoutX(45);
        label.setLayoutY(162);

        return label;
    }
    private Label infoText2(){
        Label label = new Label();
        label.setStyle("-fx-font-size: 11px; -fx-text-fill: white;");
        label.setText("Escribe los 16 dígitos o toma una foto de tu tarjeta.");
        label.setLayoutX(45);
        label.setLayoutY(263);

        return label;
    }
    private Button continuar(){
        Button button = new Button();
        button.setText("Entrar");
        button.setId("BotonEntrar");
        button.setLayoutX(100);
        button.setLayoutY(375);

        return button;
    }
    private Button AvisoDePrivacidad(){
        Button button = new Button();
        button.setText("Aviso De Privacidad");
        button.setId("BotonAvisoDePrivacidad");
        button.setLayoutX(10);
        button.setLayoutY(305);

        return button;
    }
    private Label label2(){
        Label label = new Label();
        label.setStyle("-fx-text-fill: white");
        label.setLayoutX(20);
        label.setLayoutY(340);
        label.setText("Al continuar confirmas que eres cliente APPLE BANK");

        return label;
    }
    private Button noTengoTarjeta(){
        Button button = new Button();
        button.setText("¿No Tienes Tarjeta, !Da Click Aqui¡ ?");
        button.setId("BotonNoTengoTarjeta");
        button.setLayoutX(10);
        button.setLayoutY(419);
        button.setOnAction( event ->{
            cargarPaginaRegistroDatos();
        });

        return button;
    }





    public Pane getRoot(){
        return mainLayout4;
    }

}


