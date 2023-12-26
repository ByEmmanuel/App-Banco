package Interfaces;

import UserRegistration.Animaciones;
import UserRegistration.Cargarimagenes;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import static Interfaces.MainInterfaceLogin.primaryStage;


/**
 * Esta interfaz contiene los metodos para cargar las pantallas del dashboard
 * y la pantalla de carga que se muestra al cargar las pantallas que en realidad
 * no carga solo porque tarde en cargar
 */

public interface MetodosUserDashBoard extends MainInterfaceUser {



    default void ventanaDeCarga(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        Pane Pane = new Pane();
        //Agregar animaciones
        Animaciones animaciones = new Animaciones();
        animaciones.animacionesDeCarga(Pane);

        Pane.getChildren().addAll(ventanaDeCarga.getRoot());
        //Crear La escena
        Scene scene = new Scene(Pane, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    /**
     * Cargar Dashboard Si el parametro pasado es 0, se cargará la ventana de carga.
     * Sí es 1, no se cargará la ventana de carga
     */
    default void cargarDashBoard(Integer tipoDePantalla){
        if (tipoDePantalla.equals(0)) {
            ventanaDeCarga();
            new Thread(() -> {
                try {
                    Thread.sleep(2000); // Espera durante el tiempo especificado
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    try {
                        //Establecer el titulo
                        primaryStage.setTitle("Apple Bank");
                        //Agregar Los Controles
                        Pane Pane = new Pane();
                        //Agregar animaciones
                        Animaciones animaciones = new Animaciones();
                        animaciones.animacionesDeEntrada(Pane);
                        Cargarimagenes imagenes = new Cargarimagenes();
                        Button transferir = imagenes.transferir();
                        Button oportunidades = imagenes.oportunidades();
                        Button retiroSinTrjt = imagenes.retiroSinTrjt();
                        Button tresPuntos = imagenes.botonTresPuntos();

                        Pane.getChildren().addAll(dashBoard1.getRoot(),cargarPanelInferior(),transferir,oportunidades,retiroSinTrjt,tresPuntos);
                        //Crear La escena
                        Scene scene = new Scene(Pane, 328, 636);
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
        } else if (tipoDePantalla.equals(1)) {
            primaryStage.setTitle("Apple Bank");

            Pane Pane = new Pane();

            Cargarimagenes imagenes = new Cargarimagenes();

            Button transferir = imagenes.transferir();
            Button oportunidades = imagenes.oportunidades();
            Button retiroSinTrjt = imagenes.retiroSinTrjt();
            Button tresPuntos = imagenes.botonTresPuntos();

            Pane.getChildren().addAll(dashBoard1.getRoot(),cargarPanelInferior(),transferir,oportunidades,retiroSinTrjt,tresPuntos);
            Scene scene = new Scene(Pane, 328, 636);

            String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));

            scene.getStylesheets().add(CSS);
            primaryStage.setScene(scene);
            primaryStage.show();
        }else {
            System.out.println("Favor de escojer el tipo de pantalla a cargar 0 para animacion, 1 para no animacion");
        }
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
default void cargarTransferir(){
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
                    pane.getChildren().addAll(transferencias.getRoot());
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
    default void cargarPaginaNuevoContacto(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        Pane pane = new Pane();
        pane.getChildren().addAll(nuevoDestinatario.getRoot());
        //Crear La escena
        Scene scene = new Scene(pane, 328, 636);
        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        scene.getStylesheets().add(CSS);
        //Mostrar La escena
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    default void cargarPaginaImporte(){
        //Establecer el titulo
        primaryStage.setTitle("Apple Bank");
        //Agregar Los Controles
        Pane pane = new Pane();
        Animaciones animaciones = new Animaciones();
        animaciones.animacionesDeEntrada(pane);
        pane.getChildren().addAll(importe.getRoot());
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
