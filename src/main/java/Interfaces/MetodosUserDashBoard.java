package Interfaces;

import UserRegistration.Animaciones;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import static Interfaces.MainInterfaceLogin.mainLayout;
import static Interfaces.MainInterfaceLogin.primaryStage;

public interface MetodosUserDashBoard extends MainInterfaceUser {

    //StackPane StackPane = new StackPane();
    default void ventanaDeCarga(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        StackPane StackPane = new StackPane();
        //Agregar animaciones
        Animaciones animaciones = new Animaciones();
        animaciones.animacionesDeCarga(StackPane);

        StackPane.getChildren().addAll(ventanaDeCarga.getRoot());
        //Crear La escena
        Scene scene = new Scene(StackPane, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    default void cargarDashBoard(){
        ventanaDeCarga();
        // Agrega un tiempo de espera en milisegundos (por ejemplo, 3000 ms = 3 segundos)
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Espera durante el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                //mainLayout.getChildren().clear();
                try {
                    //Establecer el titulo
                    primaryStage.setTitle("Apple Bank");
                    //Agregar Los Controles
                    StackPane StackPane = new StackPane();
                    //Agregar animaciones
                    Animaciones animaciones = new Animaciones();
                    animaciones.animacionesDashBoard(StackPane);
                    StackPane.getChildren().addAll(dashBoard1.getRoot(),cargarPanelInferior());
                    //Crear La escena
                    Scene scene = new Scene(StackPane, 328, 636);
                    //Agregar los estilos CSS
                    String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
                    scene.getStylesheets().add(CSS);
                    //Mostrar La escena
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();
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
        ventanaDeCarga();
        // Agrega un tiempo de espera en milisegundos (por ejemplo, 3000 ms = 3 segundos)
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Espera durante el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                //mainLayout.getChildren().clear();
                try {
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
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();
    }
    default void cargarOportunidades(){
        ventanaDeCarga();
        // Agrega un tiempo de espera en milisegundos (por ejemplo, 3000 ms = 3 segundos)
        new Thread(() -> {
            try {
                Thread.sleep(1000); // Espera durante el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                //mainLayout.getChildren().clear();
                try {
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
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();
    }
    default void cargarNotificaciones(){
        ventanaDeCarga();
        // Agrega un tiempo de espera en milisegundos (por ejemplo, 3000 ms = 3 segundos)
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Espera durante el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                //mainLayout.getChildren().clear();
                try {
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
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();

    }
    default void cargarAyuda(){
        ventanaDeCarga();
        // Agrega un tiempo de espera en milisegundos (por ejemplo, 3000 ms = 3 segundos)
        new Thread(() -> {
            try {
                Thread.sleep(600); // Espera durante el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                //mainLayout.getChildren().clear();
                try {
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
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();
    }
}
