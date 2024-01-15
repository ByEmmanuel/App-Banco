package applebank.appbancodefinitivo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/*
 * Controllador de la ventana de prueba en formato FXML
 */
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}