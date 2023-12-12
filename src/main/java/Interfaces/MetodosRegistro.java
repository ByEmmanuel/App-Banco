package Interfaces;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public interface MetodosRegistro extends MainInterfaceLogin {

    default Pane panelSuperior(){
        var botonMenu = controller1.botonInicio();
        Pane Pane = new Pane();
        Pane.setLayoutX(0);
        Pane.setLayoutY(0);
        Pane.setId("PaneSuperior");
        Pane.setPadding(new Insets(3, 60, 0, 20)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(logoText(),botonMenu);

        return Pane;
    }
    default Label logoText(){
        String textoResaltado = "Apple Bank";
        Label label = new Label(textoResaltado);
        label.setId("h1");
        label.setLayoutX(114);
        label.setLayoutY(20);

        return label;
    }

    default void cargarPaginaMain(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controller1.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena
        primaryStage.setScene(scene);
        primaryStage.show();



    }
    default void cargarPantallaInicioSesion(){
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controller2.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena

        primaryStage.setScene(scene);
        primaryStage.show();


    }
    default void cargarPantallaRegistroOpciones(){
        //HBox hbox = new HBox(10);
        //hbox.getChildren().addAll(controller3.getMainHbox());
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controller3.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena

        primaryStage.setScene(scene);
        primaryStage.show();


    }
    default void cargarPaginaRegistroPersona(){
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controllerRegistroPersona.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    default void cargarPaginaRegistroEmpresa(){
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controllerRegistroEmpresas.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena

        primaryStage.setScene(scene);
        primaryStage.show();
    }



    default void cargarPaginaRegistroDatos(){
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controller4.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    default void cargarPaginaRegistroDatos2(){
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controller5.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    default void cargarPaginaServiciosFinancieros(){
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controller6.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena

        primaryStage.setScene(scene);
        primaryStage.show();
    }




}
