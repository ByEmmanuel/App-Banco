package UserDashboard;

import Interfaces.MetodosUserDashBoard;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Notificaciones implements MetodosUserDashBoard {

    private Pane mainLayout4;

    public Notificaciones() {
        setupIU();
    }

    private void setupIU() {
        mainLayout4 = new Pane();
        mainLayout4.setId("");
        mainLayout4.getChildren().addAll(texto());
    }
    private Label texto(){
        Label label = new Label("Notificaciones");
        label.setId("Label-Registro");
        label.setLayoutX(124);
        label.setLayoutY(250);
        return label;
    }
    public Pane getRoot() {
        return mainLayout4;
    }


}
