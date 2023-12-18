package UserDashboard;

import Pantallas.VentanaDeCargaPrueba;
import javafx.scene.layout.Pane;

public class Transferencias {

    private Pane mainLayoutTransferencias;
    VentanaDeCargaPrueba ventanaDeCarga = new VentanaDeCargaPrueba();


    public Transferencias(){

        setupUI();
    }

    private void setupUI(){
        this.mainLayoutTransferencias = new Pane();
        mainLayoutTransferencias.setId("PanelTransferencias");
        mainLayoutTransferencias.getChildren().addAll(ventanaDeCarga.getRoot());
    }



    public Pane getRoot(){
        return mainLayoutTransferencias;
    }
}
