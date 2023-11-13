package Tests;


import Interfaces.MetodosAB;
import javafx.application.Application;
import javafx.stage.Stage;

public class CargarPantallaDirectamente extends Application implements MetodosAB {

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

        VentanaDeCarga vc = new VentanaDeCarga();
          mainLayout.getChildren().addAll(vc.getRoot());
          Scene scene = new Scene(mainLayout, 328, 636);
          primaryStage.setScene(scene);
          primaryStage.show();

*/


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

        cargarPaginaRegistroPersona();

    }




}
