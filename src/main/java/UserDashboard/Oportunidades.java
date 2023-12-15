package UserDashboard;

import Interfaces.MetodosUserDashBoard;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Oportunidades implements MetodosUserDashBoard {

    private Pane mainLayout3;

    public Oportunidades() {
        setupIU();
    }

    private void setupIU() {
        mainLayout3 = new Pane();
        mainLayout3.setId("");
        mainLayout3.getChildren().addAll(texto());
    }
    private Label texto(){
        Label label = new Label("Opotunidades");
        label.setId("Label-Registro");
        label.setLayoutX(124);
        label.setLayoutY(250);
        return label;
    }
    public Pane getRoot() {
        return mainLayout3;
    }

}
