package Controllers;

import Interfaces.MetodosAB;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControllerRegistroPersona implements MetodosAB {

    Cargarimagenes imagenes = new Cargarimagenes();
    Button botonMenu = imagenes.ImgMenu3();
    Pane mainLayout4;

    public ControllerRegistroPersona(){
        setupIU();
    }
    private void setupIU(){

        ControllerOpciones controllerOpciones = new ControllerOpciones();

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
        Pane.getChildren().addAll(h1Pane2(),h2Pane2(),numeroDeCelular(),NumeroDeTarjeta());

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
        textField.setLayoutY(125);


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


    public Pane getRoot(){
        return mainLayout4;
    }

}
