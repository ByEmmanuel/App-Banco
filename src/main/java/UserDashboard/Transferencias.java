package UserDashboard;

import Pantallas.VentanaDeCargaPrueba;
import UserRegistration.Cargarimagenes;
import UserRegistration.Controller1;
import UserRegistration.ControllerRegistroEmpresas;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class Transferencias {

    private Pane mainLayoutTransferencias;
    Cargarimagenes imagenes = new Cargarimagenes();
    Button x = imagenes.botonX();
    public Transferencias(){

        setupUI();
    }

    private void setupUI(){

        mainLayoutTransferencias = new Pane();
        mainLayoutTransferencias.setId("PanelTransferencias");
        mainLayoutTransferencias.getChildren().addAll(cuentasOrigen(),contactos(),x);
    }

    private Pane cuentasOrigen(){
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #0d408c;");
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        pane.setPadding(new Insets(3, 130, 3, 20)); // Padding: arriba, derecha, abajo, izquierda
        pane.setId("CuentasOrigen");
        pane.getChildren().addAll(transferir(),cambiarDeCuenta(),cuentaOrigen());
        return pane;
    }
    private Label transferir(){
        Label label = new Label("Transferir");
        label.setStyle("-fx-font-size: 18px; -fx-text-fill: #ffffff;");
        label.setLayoutX(125);
        label.setLayoutY(10);
        return label;
    }
    private Label cuentaOrigen(){
        Label label = new Label("Cuenta Origen");
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: #ffffff;");
        label.setLayoutX(20);
        label.setLayoutY(50);
        return label;
    }
    private Button cambiarDeCuenta(){
        Button button = new Button("Cambiar");
        button.setStyle("-fx-font-size: 16px; -fx-text-fill: #008bff;-fx-background-color: transparent; -fx-border-width: 0;");
        button.setLayoutX(230);
        button.setLayoutY(50);
        button.setOnAction(Event -> {
            System.out.println("BOTON LOGIN CLICKEADO");
            System.out.println("KJSAHFKNAIUFY");
        });
        return button;
    }

    private Pane contactos(){
        Pane pane = new Pane();
        Button nuevoContacto = imagenes.botonNuevoContacto();
        pane.setStyle("-fx-background-color: #ffffff;");
        pane.setLayoutX(0);
        pane.setLayoutY(150);
        pane.setPadding(new Insets(3, 130, 3, 20)); // Padding: arriba, derecha, abajo, izquierda
        pane.setId("Contactos");
        pane.getChildren().addAll(nuevoContacto);
        return pane;
    }

    public Pane getRoot(){
        return mainLayoutTransferencias;
    }
}
