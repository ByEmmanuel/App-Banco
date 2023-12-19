package Interfaces;

import Pantallas.VentanaDeCarga;
import UserDashboard.*;
import UserDashboard.PaginaPrincipalDashboard;
import UserRegistration.Controller2;
import javafx.scene.layout.VBox;

import static Interfaces.MainInterfaceLogin.controller2;

/**
 * Esta es la interfaz principal de usuarios ya registrados
 * y aqui se cargan todas las clases que se van a utilizar
 */
public interface MainInterfaceUser {


    /**
     * Este controller se usa para cargar los elementos que ya
     * coloco el usuario
     *
     */
    PaginaPrincipalDashboard dashBoard1 = new PaginaPrincipalDashboard();
    /*
     * Este controller es la pantalla de vida financiera
     */
    VidaFinanciera dashBoard2 = new VidaFinanciera();
    /*
     * Este controller es la pantalla de Oportunidades
     */
    Oportunidades dashBoard3 = new Oportunidades();
    /*
     * Este controller es la pantalla de notificaciones
     */
    Notificaciones dashBoard4 = new Notificaciones();
    /*
     * Este controller es la pantalla de Ayuda Ejecutiva
     */
    Ayuda dashBoard5 = new Ayuda();


    /**
     *  Este controller es la barra de navegacion del usuario - app
     */
    BarraNavegacion navegacionBarra = new BarraNavegacion();

    /**
     * Este es el componente al que se agregan los elementos
     * del user dashboard
     */
    //VBox vbox = new VBox();

    /**
     * Este controller es la pantalla de carga
     */
    VentanaDeCarga ventanaDeCarga = new VentanaDeCarga();

    /**
     *  Este es el controller de la pantalla de transferencias
     */
    Transferencias transferencias = new Transferencias();

}
