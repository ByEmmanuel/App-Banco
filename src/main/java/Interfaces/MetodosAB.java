package Interfaces;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public interface MetodosAB extends MainInterface {


    default void cargarPaginaMain(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controller1.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosAB.class.getResource("/Styles/styles.css"));
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
        String CSS = String.valueOf(MetodosAB.class.getResource("/Styles/styles.css"));
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
        String CSS = String.valueOf(MetodosAB.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena

        primaryStage.setScene(scene);
        primaryStage.show();


    }
    default void cargarPaginaRegistroPersona(){
        VBox vbox = new VBox();
        vbox.getChildren().addAll(controller4.getRoot());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosAB.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena

        primaryStage.setScene(scene);
        primaryStage.show();
    }
     default Label logoText(){
        String textoResaltado = "Apple Bank";
        Label label = new Label(textoResaltado);
        label.setId("h1");
        label.setLayoutX(114);
        label.setLayoutY(20);

        return label;
    }

    boolean enSuLugar = false;


}
