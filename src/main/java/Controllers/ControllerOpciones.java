package Controllers;

import Interfaces.MetodosAB;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

public class ControllerOpciones implements MetodosAB {
    Pane mainLayout4;
    public ControllerOpciones(){
        setupIU();
    }
    private void setupIU(){


        Controller1 controller1 = new Controller1();
        Button botonInicio = controller1.botonInicio();
        this.mainLayout4 = new Pane();
        this.mainLayout4.setId("PanelRegistro");

        mainLayout4.getChildren().addAll(botonInicio);
    }




    public Pane getMainLayout4() {
        return mainLayout4;
    }
}
