package Tests;


import Interfaces.MetodosRegistro;
import Interfaces.MetodosUserDashBoard;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CargarPantallaDirectamente extends Application implements MetodosRegistro, MetodosUserDashBoard {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {



        /*
         * Ventana de carga.
         * Los Cuadrados de esta ventana de carga
         * Esta ventana de carga necesita ser llamada asi, ya que no se puede llamar solo a su clase
         * LOS CUADRADOS NO DEJARAN DE MOVERSE YA QUE NO TIENEN TIEMPO LIMITE PARA PARARSE
         *
         */

//
//        VentanaDeCarga vc = new VentanaDeCarga();
//          mainLayout.getChildren().addAll(vc.getRoot());
//          Scene scene = new Scene(mainLayout, 328, 636);
//          primaryStage.setScene(scene);
//          primaryStage.show();




/*

        //Ventana Principal
        MainApp mainApp = new MainApp();
        mainApp.start(primaryStage);
*/
/*

        //Ventana Login
        cargarPantallaInicioSesion();

*/
        /*
        cargarPaginaMain();
        */

        /*
        cargarPantallaRegistro();
        */

        /*
        cargarPaginaRegistroPersona();
        */

        //cargarPaginaRegistroDatos();

        //cargarPaginaRegistroDatos2();

        //cargarPaginaServiciosFinancieros();

        //cargarPaginaRegistroEmpresa();

        /*

        try {
            PruebaPanes pruebaPanes = new PruebaPanes();
            pruebaPanes.start(stage);




            throw new VentanaDeExito(pruebaPanes.getRoot(), "Mensaje de prueba");
        }catch (Exception e){
            System.out.println("IDK");
        }

         */

        //Esta pantalla tiene que ser cargada junto con su animacion
        // y su numero de telefono; de lo contrario cargarla directamente dara error

        //cargarDashBoard();

        // Esto esta desactivado porque las animaciones se tienen que hacer a nivel directo de la clase
        // Animaciones animaciones = new Animaciones();
        //animaciones.animacionesDashBoard();

       /*
        Polygon diagonal = new Polygon(
                20, 0,   // Punto superior izquierdo
                300, 0,  // Punto superior derecho
                280, 22,   // Punto inferior derecho (formando la diagonal)
                0, 22    // Punto inferior izquierdo
        );
        diagonal.setLayoutX(50);
        diagonal.setLayoutY(100);
        diagonal.setFill(Color.valueOf("blue"));

        // Crear dos rectángulos con altura de 30 pixeles
        Rectangle rectangulo1 = crearRectangulo(30, 100, Color.BLUE);
        Rectangle rectangulo2 = crearRectangulo(30, 100, Color.RED);

        // Configurar sus posiciones
        rectangulo1.setLayoutX(10);
        rectangulo1.setLayoutY(50);
        rectangulo2.setLayoutX(10);
        rectangulo2.setLayoutY(120);

        // Crear el contenedor principal
        Pane root = new Pane(rectangulo1, rectangulo2,diagonal);

        // Configurar el escenario
        Scene scene = new Scene(root, 400, 300);

        // Configurar el escenario y mostrarlo
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rectángulo con Esquinas Recortadas");
        primaryStage.show();
        */

        //timer();
        cargarDashBoard();


    }
    private void timer() {
        // Agrega un tiempo de espera en milisegundos (por ejemplo, 3000 ms = 3 segundos)
        new Thread(() -> {
            try {
                Thread.sleep(1800); // Espera durante el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                //mainLayout.getChildren().clear();
                try {
                    cargarDashBoard();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }).start();
    }


}
