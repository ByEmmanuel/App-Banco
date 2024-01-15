package UserDashboard;

import Interfaces.MetodosUserDashBoard;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.controlsfx.glyphfont.FontAwesome;

public class VidaFinanciera implements MetodosUserDashBoard {

    private Pane mainLayout2;

    public VidaFinanciera() {
        setupIU();
    }

    private void setupIU() {

        mainLayout2 = new Pane();
        mainLayout2.setId("");
        mainLayout2.getChildren().addAll(texto());
    }
    private Label texto(){
        Label label = new Label("Mi día a día");
        label.setId("Label-Registro");
        label.setLayoutX(124);
        label.setLayoutY(250);
        return label;
    }
    public Pane getRoot() {
        return mainLayout2;
    }
}
