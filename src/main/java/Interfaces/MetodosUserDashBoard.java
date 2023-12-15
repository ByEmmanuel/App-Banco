package Interfaces;

import UserRegistration.Animaciones;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import static Interfaces.MainInterfaceLogin.primaryStage;

public interface MetodosUserDashBoard extends MainInterfaceUser {



    default void cargarDashBoard(){



        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        Pane pane = new Pane();
        //Agregar animaciones
        Animaciones animaciones = new Animaciones();
        animaciones.animacionesDashBoard(pane);

        pane.getChildren().addAll(dashBoard1.getRoot(),cargarPanelInferior());
        //Crear La escena
        Scene scene = new Scene(pane, 328, 636);
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
    default Pane cargarPanelInferior(){

        Pane Pane = new Pane();

        Pane.setLayoutX(0);
        Pane.setLayoutY(0);

        Pane.setId("PaneInferior");
        //Pane.setPadding(new Insets(3, 60, 0, 20)); // Padding: arriba, derecha, abajo, izquierda
        Pane.getChildren().addAll(navegacionBarra.getRoot());

        return Pane;
    }

    default void cargarVidaFinanciera(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        Pane pane = new Pane();
        pane.getChildren().addAll(dashBoard2.getRoot(),cargarPanelInferior());
        //Crear La escena
        Scene scene = new Scene(pane, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    default void cargarOportunidades(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        Pane pane = new Pane();
        pane.getChildren().addAll(dashBoard3.getRoot(),cargarPanelInferior());
        //Crear La escena
        Scene scene = new Scene(pane, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    default void cargarNotificaciones(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        Pane pane = new Pane();
        pane.getChildren().addAll(dashBoard4.getRoot(),cargarPanelInferior());
        //Crear La escena
        Scene scene = new Scene(pane, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    default void cargarAyuda(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        Pane pane = new Pane();
        pane.getChildren().addAll(dashBoard5.getRoot(),cargarPanelInferior());
        //Crear La escena
        Scene scene = new Scene(pane, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
