package UserRegistration;

import Interfaces.MetodosRegistro;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 *  Clase que contiene los metodos para la vista de opciones
 */

public class ControllerRegistroEmpresas implements MetodosRegistro {
    Pane mainLayout4;
    public ControllerRegistroEmpresas(){
        setupIU();
    }
    private void setupIU(){


        Controller1 controller1 = new Controller1();
        Button botonInicio = controller1.botonInicio();
        this.mainLayout4 = new Pane();
        this.mainLayout4.setId("PanelRegistro");

        mainLayout4.getChildren().addAll(botonInicio);
    }




    public Pane getRoot() {
        return mainLayout4;
    }
}
