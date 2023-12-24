package UserDashboard;

import Interfaces.MetodosUserDashBoard;
import UserRegistration.Cargarimagenes;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Transferencias extends PaginaPrincipalDashboard implements MetodosUserDashBoard {

    private Pane mainLayoutTransferencias;
    Cargarimagenes imagenes = new Cargarimagenes();
    Button x = imagenes.botonX();
    public Transferencias(){

        setupUI();
    }

    private void setupUI(){

        mainLayoutTransferencias = new Pane();
        mainLayoutTransferencias.setId("PanelTransferencias");
        mainLayoutTransferencias.getChildren().addAll(cuentasOrigen(),contactos(),x,saldo());
        mainLayoutTransferencias.setLayoutX(0);
        mainLayoutTransferencias.setLayoutY(0);
    }

    private Pane cuentasOrigen(){
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #0d408c;");
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        pane.setPadding(new Insets(3, 130, 10, 20)); // Padding: arriba, derecha, abajo, izquierda
        pane.setId("CuentasOrigen");
        pane.getChildren().addAll(h1(),cambiarDeCuenta(), h2(),cuentaOrigenTarjeta(),tarjeta());
        return pane;
    }
    //Transferir
    private Label h1(){
        Label label = new Label("Transferir");
        label.setStyle("-fx-font-size: 18px; -fx-text-fill: #ffffff;");
        label.setLayoutX(125);
        label.setLayoutY(10);
        return label;
    }
    //Cuenta Origen
    private Label h2(){
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

            System.out.println("CAMBIAR DE CUENTA PARA DEPOSITAR CLICKEADO");
        });
        return button;
    }
    //Saldo
    private Label saldo(){
        Label label = new Label();
        // Este metodo solo muestra el saldo del usuario solamente cuando se carga toda la applicacion,
        // para fines de testeo esto se muestra como 0.00
        String saldo = PaginaPrincipalDashboard.dashBoard1.getSaldo();
        label.setText("$"+saldo);
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: #ffffff;");
        label.setLayoutX(240);
        label.setLayoutY(90);
        return label;
    }
    private Label cuentaOrigenTarjeta(){
        Label label = new Label();

        label.setText(dashBoard1.obtenerDatosCuenta());
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: #ffffff;");
        label.setLayoutX(20);
        label.setLayoutY(100);
        return label;
    }
    private Label tarjeta(){
        Label label = new Label();
        String numTarjeta = operacionesDAO.BuscarTarjetaPorTelefono("");
        label.setText("· " + numTarjeta);
        label.setStyle("-fx-font-size: 16px; -fx-text-fill: #ffffff;");
        label.setLayoutX(20);
        label.setLayoutY(130);
        return label;
    }

    private Pane contactos(){
        Pane pane = new Pane();
        Button nuevoContacto = imagenes.botonNuevoContacto();
        pane.setStyle("-fx-background-color: #ffffff;");
        pane.setLayoutX(0);
        pane.setLayoutY(165);
        pane.setPadding(new Insets(3, 130, 3, 20)); // Padding: arriba, derecha, abajo, izquierda
        pane.setId("Contactos");
        pane.getChildren().addAll(nuevoContacto,h3(),nuevoContacto());
        return pane;
    }
    Label h3(){
        Label label = new Label("DESTINATARIO");
        label.setStyle("-fx-font-size: 14px; -fx-text-fill: #000000;");
        label.setLayoutX(20);
        label.setLayoutY(10);
        return label;
    }
    Button nuevoContacto(){
        Button button = new Button("Nuevo");
        button.setStyle("-fx-font-size: 20px; -fx-text-fill: #008bff;-fx-background-color: transparent; -fx-border-width: 0;");
        button.setLayoutX(70);
        button.setLayoutY(50);
        button.setOnAction(Event -> {
            cargarPaginaNuevoContacto();
            System.out.println("BOTON NUEVO CONTACTO CLICKEADO");
        });
        return button;
    }

    public Pane getRoot(){
        return mainLayoutTransferencias;
    }
}
