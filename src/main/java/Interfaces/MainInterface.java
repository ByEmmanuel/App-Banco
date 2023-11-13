package Interfaces;

import Controllers.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public interface MainInterface {

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
    ControllerRegistroPersona controller4 = new ControllerRegistroPersona();
    Pane mainLayout = new Pane();


    /**
     * Stage es la pantalla que aparece en la pantalla
     */
    Stage primaryStage = new Stage();
}
