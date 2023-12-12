package Interfaces;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import static Interfaces.MainInterfaceLogin.primaryStage;

public interface MetodosUserDashBoard extends MainInterfaceUser {



    default void cargarDashBoard(){



        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles


        vbox.getChildren().addAll(dashBoard1.getRoot(),panelInferior());
        //Crear La escena
        Scene scene = new Scene(vbox, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Este metodo crea el panel inferior de la pantalla principal y se tiene que
     * agregar a cada pantalla del dashBoard
     * @return
     */
    default Pane panelInferior(){

        Pane Pane = new Pane();

        Pane.setLayoutX(0);
        Pane.setLayoutY(0);

        Pane.setId("PaneInferior");
        //Pane.setPadding(new Insets(3, 60, 0, 20)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(navegacionBarra.getRoot());

        return Pane;
    }
}
