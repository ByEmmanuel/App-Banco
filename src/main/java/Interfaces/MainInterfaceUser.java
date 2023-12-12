package Interfaces;

import UserDashboard.BarraNavegacion;
import UserDashboard.ControllerDash1;
import UserRegistration.Controller2;
import javafx.scene.layout.VBox;

import static Interfaces.MainInterfaceLogin.controller2;

public interface MainInterfaceUser {


    /**
     * Este controller se usa para cargar los elementos que ya
     * coloco el usuario
     *
     */
    ControllerDash1 dashBoard1 = new ControllerDash1();

    /**
     *  Este controller es la barra de navegacion del usuario - app
     */
    BarraNavegacion navegacionBarra = new BarraNavegacion();

    /**
     * Este es el componente al que se agregan los elementos
     * del user dashboard
     */

    VBox vbox = new VBox();
}
