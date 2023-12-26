package UserDashboard;

import Excepciones.ErrorDesconocido;
import UserRegistration.Cargarimagenes;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ImporteYConcepto extends PaginaPrincipalDashboard{

    Cargarimagenes imagenes = new Cargarimagenes();
    private Pane mainLayoutImporte;
    Pane header = new Pane();
    Pane paneParteUno = new Pane();
    String cantidadDeDinero = super.getSaldo();
    TextField importeField = new TextField();


    public ImporteYConcepto(){

        setupUI();

    }

    private void setupUI(){
        Button x = imagenes.botonX();
        mainLayoutImporte = new Pane();
        mainLayoutImporte.setId("PanelImporte");
        mainLayoutImporte.getChildren().addAll(importe(),x,concepto(),botonPrueba());
        mainLayoutImporte.setLayoutX(0);
        mainLayoutImporte.setLayoutY(0);
    }

    private Pane importe(){

        header.setStyle("-fx-background-color: #04417c;");
        header.setLayoutX(0);
        header.setLayoutY(0);
        header.setPrefSize(328, 50);
        header.setId("Importe");
        Label label = new Label("Transferir");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 17px;");
        label.setLayoutX(130);
        label.setLayoutY(15);
        header.getChildren().addAll(label);
        return header;
    }

    private Pane concepto(){
        //paneParteDos.setOpacity(0.5);
        paneParteUno.setStyle("-fx-background-color: #FFFFFF;");
        paneParteUno.setLayoutX(0);
        paneParteUno.setLayoutY(51);
        paneParteUno.setPrefSize(328, 260);
        paneParteUno.setId("Concepto");
        paneParteUno.getChildren().addAll(importeLabel("black",15,"Bold",25,20),
                                          importeLabel("black", 10,"italic",45,65),
                importeField(),h1(),botonContinuar());
        return paneParteUno;
    }
    private Label importeLabel(String color, int tamaño, String tipoDeLetra, int posX, int posY){
        Label label = new Label("Importe");
        label.setStyle("-fx-text-fill: " + color + "; -fx-font-size: " + tamaño + "px; -fx-font-weight: " + tipoDeLetra + ";");
        label.setLayoutX(posX);
        label.setLayoutY(posY);
        return label;
    }
    private TextField importeField(){

        importeField.setPromptText("$");
        importeField.setId("importeField");
        importeField.setLayoutX(25);
        importeField.setLayoutY(60);
        importeField.setPrefSize(280, 40);

        return importeField;
    }
    private Label h1(){
        Label label = new Label("En tu cuenta tienes $" + cantidadDeDinero);
        label.setStyle("-fx-text-fill: black ; -fx-font-size: 15px; ");
        label.setLayoutX(50);
        label.setLayoutY(120);
        return label;
    }
    Button botonPrueba(){
        Button botonPrueba = new Button("Prueba");
        botonPrueba.setLayoutX(160);
        botonPrueba.setLayoutY(400);
        botonPrueba.setOnAction(Event -> {
            paneParteUno.setOpacity(1);
            System.out.println("BOTON PRUEBA CLICKEADO");
        });
        return botonPrueba;
    }
    private Button botonContinuar(){
        Button botonContinuar = new Button("Continuar");
        botonContinuar.setDisable(true);

        importeField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Nuevo valor " + newValue);

            try {
                double dinero = Double.parseDouble(cantidadDeDinero);
                double textField = Double.parseDouble(importeField.getText());
                System.out.println("Dinero: " + dinero);
                System.out.println("TextField: " + textField);
                if (textField < dinero && textField > 0) {
                    botonContinuar.setDisable(false);
                    botonContinuar.setOpacity(1);
                }
                    //throw new ErrorDesconocido(mainLayoutImporte,"No tienes suficientes fondos\n en tu cuenta");
                else {
                    botonContinuar.setDisable(true);
                    botonContinuar.setOpacity(0.5);
                    System.out.println("Valores no introducidos");
                }
            }catch (Exception e) {
                botonContinuar.setDisable(true);
                botonContinuar.setOpacity(0.5);
                System.out.println("Error");
                throw new ErrorDesconocido(mainLayoutImporte,"Ingrese un valor valido");
            }


        });

        botonContinuar.setId("BotonContinuar");
        botonContinuar.setLayoutX(95);
        botonContinuar.setLayoutY(200);
        botonContinuar.setOnAction(Event -> {
            paneParteUno.setOpacity(1);
            System.out.println("BOTON PRUEBA CLICKEADO");
        });
        return botonContinuar;
    }

    public Pane getRoot(){
        return mainLayoutImporte;
    }

}
