package UserDashboard;

import Interfaces.MetodosUserDashBoard;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Ayuda implements MetodosUserDashBoard {

    private Pane mainLayout5;

    public Ayuda() {
        setupIU();
    }

    private void setupIU() {
        mainLayout5 = new Pane();
        mainLayout5.setId("");
        mainLayout5.getChildren().addAll(texto());
    }
    private Label texto(){
        Label label = new Label("Ayuda");
        label.setId("Label-Registro");
        label.setLayoutX(124);
        label.setLayoutY(250);
        return label;
    }
    /*
     * Aqui se agregan los metodos que se necesiten para la clase
     */
    public Pane getRoot() {
        return mainLayout5;
    }
}
