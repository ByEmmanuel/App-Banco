package Controllers;

import Interfaces.MetodosAB;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class Controller3 implements MetodosAB {
    Cargarimagenes imagenes = new Cargarimagenes();
    Button botonMenu = imagenes.ImgMenu3();
    Pane mainLayout3;

    public Controller3(){
        setupIU();
    }
    private void setupIU(){

        ControllerOpciones controllerOpciones = new ControllerOpciones();
        Button botonMenu = Controller1.controller1.botonInicio();
        this.mainLayout3 = new Pane();
        this.mainLayout3.setId("PanelRegistro");

        mainLayout3.getChildren().addAll(seleccionaPerfil(),leyenda(),hBox1(), hBox2(), hBox3(),botonMenu);


    }
    private Label seleccionaPerfil(){
        Label label = new Label("Selecciona tu perfil");
        label.setStyle("-fx-font-size: 30px");
        label.setLayoutX(30);
        label.setLayoutY(55);
        return label;
    }
    private Label leyenda(){
        Label label = new Label(" Antes de elegir tu perfil y continuar con la activación \n de" +
                "Tu Banca por internet, es necesario que hayas \n" +
                " firmado tu Contrato Unico Digital en sucursal.");
        label.setStyle("-fx-font-size: 13px");
        label.setLayoutX(15);
        label.setLayoutY(90);
        return label;
    }
    private Pane hBox1(){
        Pane Pane = new Pane();
        Pane.setLayoutX(0);
        Pane.setLayoutY(0);
        Pane.setId("PaneSuperior");
        Pane.setPadding(new Insets(3, 60, 0, 20)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(logoText(),botonMenu);

        return Pane;
    }
    private Pane hBox2(){
        Pane Pane = new Pane();
        Pane.setLayoutX(20);
        Pane.setLayoutY(160);
        //BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        //Background background = new Background(backgroundFill);
        Pane.setId("Pane");
        //Pane.setBackground(background);
        // Configurar relleno programáticamente
        Pane.setPadding(new Insets(3, 60, 3, 20)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(label1(),label2(),opcion1(),opcion2(),opcion3(),botonPersona());

        return Pane;
    }
    private Label label1(){
        Label label = new Label("Soy persona");
        label.setLayoutX(15);
        label.setLayoutY(30);
        label.setStyle("-fx-font-size: 16px");

        return label;
    }
    private Label label2(){
        Label label = new Label("¿Qué necesitas?");
        label.setLayoutX(17);
        label.setLayoutY(65);
        label.setStyle("-fx-font-size: 16px");

        return label;
    }
    private Label opcion1(){
        Label label = new Label("* Tarjeta");
        label.setLayoutX(17);
        label.setLayoutY(90);
        label.setStyle("-fx-font-size: 15px");

        return label;
    }
    private Label opcion2(){
        Label label = new Label("* Token Móvil");
        label.setLayoutX(17);
        label.setLayoutY(120);
        label.setStyle("-fx-font-size: 15px");

        return label;
    }
    private Label opcion3(){
        Label label = new Label("* Alertas");
        label.setLayoutX(17);
        label.setLayoutY(150);
        label.setStyle("-fx-font-size: 15px");

        return label;
    }
    private Button botonPersona(){
        Button boton = new Button("Continuar");
        boton.setId("Boton-Continuar-Registro");
        boton.setLayoutX(17);
        boton.setLayoutY(180);
        boton.setOnAction(event ->{
            ControllerRegistroPersona registroPersona = new ControllerRegistroPersona();
            registroPersona.cargarPaginaRegistroPersona();
            System.out.println("Boton soy persona clickeado");
        });

        return boton;
    }
    private Pane hBox3(){
        Pane Pane = new Pane();
        Pane.setLayoutX(20);
        Pane.setLayoutY(395);
        //BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        //Background background = new Background(backgroundFill);
        Pane.setId("Pane");
        //Pane.setBackground(background);
        // Configurar relleno programáticamente
        Pane.setPadding(new Insets(3, 60, 3, 20)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(label10(),label20(),opcion10(),opcion20(),botonEmpresa());

        return Pane;
    }
    private Label label10(){
        Label label = new Label("Soy Empresa");
        label.setLayoutX(15);
        label.setLayoutY(30);
        label.setStyle("-fx-font-size: 16px");

        return label;
    }
    private Label label20(){
        Label label = new Label("¿Qué necesitas?");
        label.setLayoutX(17);
        label.setLayoutY(85);
        label.setStyle("-fx-font-size: 16px");

        return label;
    }
    private Label opcion10(){
        Label label = new Label("* Tarjeta");
        label.setLayoutX(17);
        label.setLayoutY(110);
        label.setStyle("-fx-font-size: 15px");

        return label;
    }
    private Label opcion20(){
        Label label = new Label("* Token Móvil o físico");
        label.setLayoutX(17);
        label.setLayoutY(140);
        label.setStyle("-fx-font-size: 15px");

        return label;
    }
    Button botonEmpresa(){
        Button boton = new Button("Continuar");
        boton.setId("Boton-Continuar-Registro");
        boton.setLayoutX(17);
        boton.setLayoutY(180);
        boton.setOnAction(event ->{
            System.out.println("Boton soy Empresa clickeado");
        });

        return boton;
    }


    public Pane getRoot(){
        return mainLayout3;
    }
}
