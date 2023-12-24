package UserDashboard;

import DAO.ClientesDAO;
import DAO.OperacionesDAO;
import Excepciones.ErrorDesconocido;
import Interfaces.MetodosUserDashBoard;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Destinatario {

    private Pane mainLayoutDestinatario;
    private static final TextField textFieldDatos = new TextField();

    public Destinatario(){
        setupUI();
    }

    private void setupUI(){
        mainLayoutDestinatario = new Pane();
        mainLayoutDestinatario.setId("PanelDestinatario");
        mainLayoutDestinatario.getChildren().addAll(h1(),agregarContactos(),buscar());
    }
    private Label h1(){
        Label label = new Label("Nuevo Destinatario");
        label.setStyle("-fx-font-size: 17px; -fx-text-fill: #000000;");
        label.setLayoutX(90);
        label.setLayoutY(10);
        return label;
    }
    private Pane agregarContactos(){
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgba(218,211,211,0.58);");
        pane.setLayoutX(0);
        pane.setLayoutY(50);
        pane.setPadding(new Insets(3, 130, 10, 20)); // Padding: arriba, derecha, abajo, izquierda
        pane.getChildren().addAll(h2(),CampoEmail());
        return pane;
    }
    private Label h2(){
        Label label = new Label();
        Text textoNormal = new Text("Introduce una");
        textoNormal.setStyle("-fx-fill: rgba(3,3,3,0.5);");
        Text textoNegrita = new Text(" cuenta, CLABE, Tarjeta o Celular) \n");
        textoNegrita.setStyle("-fx-font-weight: bold; -fx-fill: #000000;"); // Aplicar el estilo al texto en negritas
        Text demasTexto = new Text("       para que te ayudemos con los datos del \n" +
                "               destinatario de cualquier banco:");
        demasTexto.setStyle("-fx-fill: rgba(3,3,3,0.5);");
        TextFlow textFlow = new TextFlow(textoNormal, textoNegrita,demasTexto);
        label.setGraphic(textFlow);
        label.setStyle("-fx-font-size: 13px; -fx-text-fill: #000000;");
        label.setLayoutX(30);
        label.setLayoutY(100);
        return label;
    }
    private TextField CampoEmail(){

        textFieldDatos.setPrefWidth(240);
        textFieldDatos.setId("LabelNuevoDestinatario");
        textFieldDatos.setPromptText("Cuenta, CLABE, tarjeta...");

        textFieldDatos.setLayoutX(30);
        textFieldDatos.setLayoutY(160);

        return textFieldDatos;
    }
    private Button buscar(){
        Button button = new Button("Buscar");
        //button.setStyle("-fx-font-size: 16px; -fx-text-fill: #008bff;-fx-background-color: transparent; -fx-border-width: 0;");
        button.setId("BotonBuscar");
        button.setLayoutX(120);
        button.setLayoutY(570);

        button.setDisable(true);
        button.setOpacity(0.5);
        textFieldDatos.textProperty().addListener((observable, oldValue, newValue) -> {
            if (textFieldDatos.getText().isEmpty()){
                button.setDisable(true);
                button.setOpacity(0.5);
            }else{
                button.setDisable(false);
                button.setOpacity(1);
            }
            button.setOnAction(Event -> {
                //sistema de busqueda de destinatario con base de datos
                System.out.println("BUSCAR CLICKEADO");
                OperacionesDAO operacionesDAO = new OperacionesDAO();
                String textFieldString = textFieldDatos.getText();

                //TalVez puedo usar un while o un do while aqui
                if (textFieldDatos.getText().matches("[0-9].{3,8}")){
                    System.out.println("NumeroDeCuenta");
                    operacionesDAO.BuscarUsuarioPorNumeroDeCuenta(textFieldString);
                }else if (textFieldDatos.getText().matches("[0-9].{9}")) {
                    System.out.println("Telefono");
                    operacionesDAO.BuscarUsuarioPorTelefono(textFieldString);
                }else if (textFieldDatos.getText().matches("[0-9].{15}")) {
                    System.out.println("Tarjeta");
                    operacionesDAO.BuscarUsuarioPorTarjeta(textFieldString);
                }else if (textFieldDatos.getText().matches("[0-9].{17}")) {
                    System.out.println("CLABE");
                    operacionesDAO.BuscarUsuarioPorCLABE(textFieldString);
                }else {
                    throw new ErrorDesconocido(mainLayoutDestinatario,"No se encontro el destinatario");
                }



            });
        });
        return button;
    }
    public Pane getRoot(){
        return mainLayoutDestinatario;
    }


}
