package UserDashboard;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.awt.*;

public class BarraNavegacion {

    /**
     *
     */
    Pane mainLayout = new Pane();


    public BarraNavegacion(){
        setupIU();
    }

    private void setupIU(){



        mainLayout.setPrefSize(380, 60);
        mainLayout.setLayoutX(0);

        // Modificar el valor de Y para cambiar la altura de la barra de navegación
        mainLayout.setLayoutY(0);




       mainLayout.setId("Barra-Desplazamiento");

       mainLayout.getChildren().addAll(botonHome(),vidaFinanciera(),botonMasProductos(),botonBuzon(),botonPerfil());

    }

    Button botonHome(){
        Button botonHome = new Button();
        botonHome.setId("Botones-Barra-Navegacion");
        botonHome.setLayoutX(30);
        botonHome.setLayoutY(20);
        return botonHome;

    }


    Button vidaFinanciera() {
        Button vidaFinanciera = new Button();
        vidaFinanciera.setId("Botones-Barra-Navegacion");
        vidaFinanciera.setLayoutX(90);
        vidaFinanciera.setLayoutY(20);
        return vidaFinanciera;
    }

    Button botonMasProductos(){
        Button botonHome = new Button();
        botonHome.setId("Botones-Barra-Navegacion");
        botonHome.setLayoutX(150);
        botonHome.setLayoutY(20);
        return botonHome;

    }

    Button botonBuzon(){
        Button botonHome = new Button();
        botonHome.setId("Botones-Barra-Navegacion");
        botonHome.setLayoutX(210);
        botonHome.setLayoutY(20);
        return botonHome;

    }

    Button botonPerfil(){
        Button botonHome = new Button();
        botonHome.setId("Botones-Barra-Navegacion");
        botonHome.setLayoutX(270);
        botonHome.setLayoutY(20);
        return botonHome;

    }

    public Pane getRoot(){
        return mainLayout;
    }

}
