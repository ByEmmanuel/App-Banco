package UserRegistration;

import DAO.ClientesDAO;
import Excepciones.ErrorDesconocido;
import Excepciones.VentanaDeExito;
import Interfaces.MetodosRegistro;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class Controller6 implements MetodosRegistro {


    //Esta variable se declara asi ya que se le podra asignar diferentes valores dependiendo del error
    private static String mensajeError;
    private static int cantidad;
    private final TextField campoSaldo = new TextField();
    private ComboBox<String> comboBox = new ComboBox<>();
    private final TextField campoFirmaContrato = new TextField();
    private CheckBox checkBox = new CheckBox();

    /**
     * Clase que contiene los metodos para la vista de Eleccion de tipo de
     * Cuenta
     *  ( <---- Controller Registro Tipo De Cuenta ----> )
     */
    Pane mainLayout6;


    public Controller6(){
        setupIU();
    }

    private void setupIU(){
        this.mainLayout6 = new Pane();
        this.mainLayout6.setId("PanelRegistro");

        mainLayout6.getChildren().addAll(panelSuperior(),comboBox1(),continuar(),saldoField(),label1(),espacioParaFirmar(),label2(),cajitaDeAceptoTodo());
    }
    private Label label1(){
        Label label = new Label();
        label.setId("");
        label.setText("Por Ultimo, LLena Este Formulario \n y Firma tu Contrato");
        label.setLayoutX(60);
        label.setLayoutY(70);

        return label;
    }

    private ComboBox<String> comboBox1() {
    this.comboBox = new ComboBox<>();
        this.comboBox.getItems().addAll(
            "Cuenta de Ahorro",
            "Cuenta de Cheques",
            "Cuenta de Nomina",
            "Cuenta de Inversion",
            "Cuenta de Credito",
            "Cuenta de Hipoteca",
            "Cuenta de Seguro",
            "Cuenta de Fondo de Retiro",
            "Cuenta de Fondo de Inversion"
        );

        this.comboBox.setPromptText("Escoje tu tipo de cuenta");
        this.comboBox.setId("Boton-Registro-Tarjetas");

        this.comboBox.setEditable(false);
        this.comboBox.setLayoutX(60);
        this.comboBox.setLayoutY(130);

    if (comboBox.itemsProperty().getValue().equals("Cuenta de Ahorro")){
        System.out.println("Cuenta de Ahorro");
    }else if (comboBox.itemsProperty().getValue().equals("Cuenta de Cheques")){
        System.out.println("Cuenta de Cheques");
    }

    return comboBox;


    }

    private TextField saldoField(){

        campoSaldo.setPrefWidth(210);
        campoSaldo.getText().matches("^[0-9]$");

        campoSaldo.setPromptText("Ingrese saldo a depositar");
        campoSaldo.setId("Campo-Saldo");
        campoSaldo.setStyle("-fx-text-fill: white;");
        campoSaldo.setLayoutX(60);
        campoSaldo.setLayoutY(340);

        campoSaldo.textProperty().addListener((obs, oldValue, newValue) -> {
            try {
                int cantidad = Integer.parseInt(newValue);

                if (cantidad < 0) {
                    mensajeError = "No se puede ingresar un saldo negativo";
                    throw new ErrorDesconocido(mainLayout6, mensajeError, campoSaldo);
                }else if (!newValue.matches("\\d*")) {
                    campoSaldo.setEditable(false);
                    throw new ErrorDesconocido(mainLayout6,"Favor de introducir un numero valido", campoSaldo);
                }else if (cantidad > 200) {
                    campoSaldo.setEditable(false);
                    mensajeError = "No se puede ingresar un saldo mayor a 200";
                    throw new ErrorDesconocido(mainLayout6,mensajeError, campoSaldo);
                }
            }catch (NumberFormatException e) {
                // Manejar el caso en que el nuevo valor no es un número válido
                campoSaldo.setEditable(false);
                throw new ErrorDesconocido(mainLayout6, "Favor de introducir un número válido", campoSaldo);
            }
        });


        return campoSaldo;
    }



    private Label label2(){
        Label label = new Label();
        label.setId("");
        label.setText("Firma Aqui Con Tu Nombre Completo");
        label.setLayoutX(60);
        label.setLayoutY(400);



        return label;
    }
    private TextField espacioParaFirmar(){

        campoFirmaContrato.setPrefWidth(270);
        campoFirmaContrato.setPrefColumnCount(20);  // Ajusta el ancho preferido en términos de columnas de texto
        campoFirmaContrato.setStyle("-fx-font-size: 15px; -fx-text-fill: white;");
        campoFirmaContrato.setId("CampoFirma");
        campoFirmaContrato.setPromptText("Firma tu Contrato");

        campoFirmaContrato.setLayoutX(30);
        campoFirmaContrato.setLayoutY(450);

        return campoFirmaContrato;
    }
    private CheckBox cajitaDeAceptoTodo(){

        checkBox.setId("CheckBox");
        checkBox.setLayoutX(40);
        checkBox.setLayoutY(500);
        checkBox.setText("Acepto que lei todos los terminos y condiciones \n " +
                "y que estoy de acuerdo con ellos");

        return checkBox;

    }
    Button continuar (){
        Button button = new Button();
        button.setId("BotonEntrar");
        button.setText("Continuar");
        button.setLayoutX(98);
        button.setLayoutY(550);
        button.setOnAction(event -> {

            String tipoDeCuenta = comboBox.getValue();
            System.out.println(tipoDeCuenta);
            if (tipoDeCuenta == null ) {
                mensajeError = "No se ha seleccionado un tipo de cuenta";
                throw new ErrorDesconocido(mainLayout6,mensajeError, campoSaldo);
            } else if (campoSaldo.getText().isEmpty()) {
                mensajeError = "No se ha ingresado un saldo";
                throw new ErrorDesconocido(mainLayout6,mensajeError, campoSaldo);
            } else if (campoFirmaContrato.getText().isEmpty()) {
                mensajeError = "No se ha ingresado una firma";
                throw new ErrorDesconocido(mainLayout6,mensajeError, campoSaldo);
            } else if (!checkBox.isSelected()) {
                mensajeError = "No se ha aceptado el contrato";
                throw new ErrorDesconocido(mainLayout6,mensajeError, campoSaldo);
            } else if (cantidad > 200) {
                mensajeError = "No se puede ingresar un saldo mayor a 200";
                throw new ErrorDesconocido(mainLayout6,mensajeError, campoSaldo);
            }
            else {
                cargarPaginaMain();

                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.RegistrarDatosBancariosUsuario("", Double.parseDouble(campoSaldo.getText()),tipoDeCuenta,campoFirmaContrato.getText());

                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new VentanaDeExito(controller1.getRoot(),"Registro Exitoso");
            }

        });

        return button;
    }



    public Pane getRoot(){
        return mainLayout6;
    }

}
