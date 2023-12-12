package Interfaces;

import UserDashboard.BarraNavegacion;
import UserRegistration.*;
import DAO.ClientesDAO;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public interface MainInterfaceLogin {

    /**
     * Este Metodo llama a las imagenes
     * @return imagenes
     */
    Cargarimagenes cargarimagenes = new Cargarimagenes();
    /**
     * Este controller llama a la pagina principal
     * @return main page
     */
    Controller1 controller1 = new Controller1();
    /**
     * Este controller llama a la pagina de inicio de sesion
     * @return login page
     */
    Controller2 controller2 = new Controller2();
    /**
     * Este controller llama a la pagina de opciones de tipo de registro
     * @return register options page
     */
    Controller3 controller3 = new Controller3();
    /**
     * Este controller llama a la pagina de registro de personas fisicas
     * @return fisic persons page
     */
    ControllerRegistroPersona controllerRegistroPersona = new ControllerRegistroPersona();
    /**
     * Este controller llama a la pagina de registro de personas morales (Empresas)
     * @return moral persons page
     */
    ControllerRegistroEmpresas controllerRegistroEmpresas = new ControllerRegistroEmpresas();

    /**
     * Este es el controller de captura de datos usuario
     * @return ingresa los datos a la base de datos
     */
    Controller4 controller4 = new Controller4();
    /**
     * Este es el controller de captura de datos usuario Para
     */
    Controller5 controller5 = new Controller5();

    /**
     * Este es el controller de captura de datos usuario Para la base de datos
     */
    ClientesDAO clientesDAO = new ClientesDAO();

    /**
     * Este es el controller de captura de Tipo de Servicios Financioeros a
     * contratar
     */
     Controller6 controller6 = new Controller6();

    Pane mainLayout = new Pane();


    VBox vbox = new VBox();
    /**
     * Stage es la pantalla que aparece en la pantalla
     */
    Stage primaryStage = new Stage();
}
