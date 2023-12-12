package Tests;


import DAO.ClientesDAO;
import Interfaces.MetodosRegistro;
import Interfaces.MetodosUserDashBoard;
import UserRegistration.Animaciones;
import javafx.application.Application;
import javafx.stage.Stage;

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

        cargarPaginaServiciosFinancieros();

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

        /*
*/
        cargarDashBoard();
        Animaciones animaciones = new Animaciones();
        animaciones.animacionesDashBoard();
    }

}
