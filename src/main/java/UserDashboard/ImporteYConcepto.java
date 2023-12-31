package UserDashboard;

import Excepciones.ErrorDesconocido;
import Interfaces.MetodosUserDashBoard;
import UserRegistration.Animaciones;
import UserRegistration.Cargarimagenes;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ImporteYConcepto extends PaginaPrincipalDashboard implements MetodosUserDashBoard {

    Transferencias transferencias = new Transferencias();
    Pane paneUno = transferencias.cuentasOrigen();
    Cargarimagenes imagenes = new Cargarimagenes();
    private Pane mainLayoutImporte;
    private Pane paneParteUno = new Pane();
    private Pane paneParteDos = new Pane();
    private String cantidadDeDinero = super.getSaldo();
    private String usuarioDestino;
    private TextField importeField = new TextField();
    private TextField conceptoField = new TextField();
    private Label usuarioDestinoLabel = new Label();
    private Label labelPreview2 = new Label();
    private Label labelPreview3 = new Label();
    private Button botonTransferir = new Button("Transferir");


    Pane previewDos = new Pane();
    Pane previewTres = new Pane();
    Pane previewCuatro = new Pane();

    private final double[] cantidadADepositar = new double[2];


    public ImporteYConcepto(){

        setupUI();

    }

    private void setupUI(){
        Button x = imagenes.botonX();
        mainLayoutImporte = new Pane();
        mainLayoutImporte.setId("PanelImporte");
        mainLayoutImporte.getChildren().addAll(headerTransferencias(),x,importe(),concepto(),botonPrueba());
        mainLayoutImporte.setLayoutX(0);
        mainLayoutImporte.setLayoutY(0);
    }



    private Pane importe(){
        //paneParteDos.setOpacity(0.5);
        paneParteUno.setStyle("-fx-background-color: #FFFFFF;");
        paneParteUno.setLayoutX(0);
        paneParteUno.setLayoutY(51);
        paneParteUno.setPrefSize(328, 260);
        paneParteUno.setId("Concepto");
        paneParteUno.getChildren().addAll(importeLabel("black",15,"Bold",25,20),
                                          importeLabel("black", 10,"italic",45,65),
                importeField(),h1(), botonContinuarUno());
        return paneParteUno;
    }
    private Label importeLabel(String color, int tamaño, String tipoDeLetra, int posX, int posY){
        Label label = new Label("Importe");
        label.setStyle("-fx-text-fill: " + color + "; -fx-font-size: " + tamaño + "px; font-weight: " + tipoDeLetra + ";");
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
            paneParteDos.setOpacity(1);
            mainLayoutImporte.getChildren().remove(paneParteUno);
            //limpiarPantallas();
            reiniciarPantallas();
            Animaciones animaciones = new Animaciones();
            animaciones.animacionesVertical(paneParteDos,0,-150);
            paneParteDos.setStyle("-fx-background-color: rgb(255,255,255);");
            System.out.println("BOTON PRUEBA CLICKEADO");
        });
        return botonPrueba;
    }
    private Button botonContinuarUno(){
        Button botonContinuar = new Button("Continuar");
        botonContinuar.setDisable(true);

        importeField.textProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("Nuevo valor " + newValue);

            try {
                double dinero = Double.parseDouble(cantidadDeDinero);
                double textField = Double.parseDouble(importeField.getText());
                //System.out.println("Dinero: " + dinero);
                //System.out.println("TextField: " + textField);
                if (textField < dinero && textField > 0) {
                    botonContinuar.setDisable(false);
                    botonContinuar.setOpacity(1);
                    this.cantidadADepositar[0] = textField;
                }
                    //throw new ErrorDesconocido(mainLayoutImporte,"No tienes suficientes fondos\n en tu cuenta");
                else {
                    botonContinuar.setDisable(true);
                    botonContinuar.setOpacity(0.5);
                    throw new ErrorDesconocido(mainLayoutImporte,"No tienes suficientes fondos\n en tu cuenta \n o el valor introducido es invalido");
                }
            }catch (Exception e) {
                botonContinuar.setDisable(true);
                botonContinuar.setOpacity(0.5);
                System.out.println("Error");

            }


        });

        botonContinuar.setId("BotonContinuar");
        botonContinuar.setLayoutX(95);
        botonContinuar.setLayoutY(200);
        botonContinuar.setOnAction(Event -> {

            paneParteUno.setOpacity(1);
            paneParteDos.setOpacity(1);
            mainLayoutImporte.getChildren().remove(paneParteUno);
            Animaciones animaciones = new Animaciones();
            animaciones.animacionesVertical(paneParteDos,0,-150);
            colocarMiniventana();

            System.out.println("BOTON PRUEBA CLICKEADO");
        });
        return botonContinuar;
    }

    /**
     * Esta funcion es la que se encarga de crear la segunda parte de la pantalla
     * que es el concepto de la transferencia
     * @return
     */
    Pane concepto(){

        paneParteDos.setOpacity(0.5);
        paneParteDos.setStyle("-fx-background-color: rgba(243,243,243,0.85);");
        paneParteDos.setLayoutX(0);
        paneParteDos.setLayoutY(311);
        paneParteDos.setPrefSize(328, 260);
        paneParteDos.setId("Concepto");
        paneParteDos.getChildren().addAll(conceptoField(),referencia(),conceptoLabel(),botonContinuarDos());
        return paneParteDos;

    }
    private Label conceptoLabel (){
        Label label = new Label("Concepto");
        label.setStyle("-fx-text-fill: black; -fx-font-size: 15px;");
        label.setLayoutX(30);
        label.setLayoutY(50);
        return label;
    }
    private Button botonContinuarDos() {
        Button botonContinuarDos = new Button("Continuar");
        botonContinuarDos.setId("BotonContinuar");
        botonContinuarDos.setDisable(true);

        importeField.textProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("Nuevo valor " + newValue);

            try {
                double dinero = Double.parseDouble(cantidadDeDinero);
                double textField = Double.parseDouble(importeField.getText());
                //System.out.println("Dinero: " + dinero);
                //System.out.println("TextField: " + textField);
                if (textField < dinero && textField > 0) {
                    botonContinuarDos.setDisable(false);
                    botonContinuarDos.setOpacity(1);
                }
                //throw new ErrorDesconocido(mainLayoutImporte,"No tienes suficientes fondos\n en tu cuenta");
                else {
                    botonContinuarDos.setDisable(true);
                    botonContinuarDos.setOpacity(0.5);
                    throw new ErrorDesconocido(mainLayoutImporte, "No tienes suficientes fondos\n en tu cuenta \n o el valor introducido es invalido");
                }
            } catch (Exception e) {
                botonContinuarDos.setDisable(true);
                botonContinuarDos.setOpacity(0.5);
                System.out.println("Error");

            }
        });
        botonContinuarDos.setOnAction(Event -> {
            previewTransferencia();
        });
        botonContinuarDos.setLayoutX(95);
        botonContinuarDos.setLayoutY(350);
         return botonContinuarDos;
    }
    private void colocarMiniventana(){
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #04417c;");
        pane.setLayoutX(0);
        pane.setLayoutY(51);
        pane.setPrefSize(328, 150);
        pane.setId("Concepto");
        pane.getChildren().addAll(labelDineroEnCuenta(),importeLabel("white",20,"Bold",25,18));
        mainLayoutImporte.getChildren().addAll(pane);
    }
    private TextField referencia(){
        TextField textField = new TextField();
        textField.setPromptText("Referencia");
        textField.setId("importeField");
        textField.setLayoutX(25);
        textField.setLayoutY(60);
        textField.setPrefSize(280, 40);
        return textField;
    }
    private TextField conceptoField(){

        conceptoField.setPromptText("Concepto");
        conceptoField.setId("importeField");
        conceptoField.setLayoutX(25);
        conceptoField.setLayoutY(150);
        conceptoField.setPrefSize(280, 40);

        return conceptoField;
    }
    private Label labelDineroEnCuenta(){
        Label label = new Label();
        label.setText("$" + cantidadADepositar[0]);
        label.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
        label.setLayoutX(30);
        label.setLayoutY(70);
        return label;
    }

    /**
     * Aquí empiezan las funciones que hacen algo caracteristico de esta funcion (Transferir)
     * Esta funcion es la que se encarga de limpiar las pantallas de esta pagína
     */
    public void reiniciarPantallas(){
        System.out.println("Primera parte de la pantalla reiniciada");

        new Thread(() -> {
            try {
                Thread.sleep(2000); // Espera durante el tiempo especificado
                System.out.println("Segunda parte de la pantalla reiniciada");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Platform.runLater(() -> {
                System.out.println("Tercera parte de la pantalla reiniciada");
                paneParteUno.setOpacity(1);
                paneParteDos.setOpacity(0.5);
                Label label = new Label("prueba");
                label.setStyle("-fx-text-fill: black; -fx-font-size: 15px;");
                label.setLayoutX(30);
                label.setLayoutY(50);

                mainLayoutImporte.getChildren().remove(paneParteUno);
                mainLayoutImporte.getChildren().remove(paneParteDos);
                mainLayoutImporte.getChildren().remove(paneUno);
                mainLayoutImporte.getChildren().remove(previewDos);
                mainLayoutImporte.getChildren().remove(previewTres);
                mainLayoutImporte.getChildren().remove(previewCuatro);
                mainLayoutImporte.getChildren().remove(botonTransferir);
                mainLayoutImporte.getChildren().addAll(paneParteUno,paneParteDos);
                animaciones.animacionesVertical(paneParteDos,-150,0);
                paneParteDos.setLayoutX(0);
                paneParteDos.setLayoutY(311);
                importeField.setText("");
                usuarioDestinoLabel.setText("");
                labelPreview3.setText("");
                labelPreview2.setText("");
                previewDos.getChildren().removeAll(label,labelPreview2,usuarioDestinoLabel);
                previewTres.getChildren().removeAll(labelPreview3,importeLabel("",0,"",0,0));
                //previewDos.getChildren().removeAll(label,usuarioDestino());


                System.out.println("Pantalla reiniciada");
            });

        }).start();

    }
    private void previewTransferencia() {
        mainLayoutImporte.getChildren().remove(paneParteUno);
        mainLayoutImporte.getChildren().remove(paneParteDos);

        mainLayoutImporte.getChildren().addAll(paneUno,previewDos(),previewTres(),previewCuatro(),botonTransferir());
    }
    Pane previewDos(){

        previewDos.setStyle("-fx-background-color: #1b74bc;");
        previewDos.setLayoutX(0);
        previewDos.setLayoutY(200);
        previewDos.setPrefSize(328, 120);
        previewDos.setId("PanePreviewDos");
        // Label
        Label label = new Label("DESTINATARIO");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 18px;");
        label.setLayoutX(20);
        label.setLayoutY(15);
        // Label
        usuarioDestinoLabel.setText(usuarioDestino);
        usuarioDestinoLabel.setStyle("-fx-text-fill: white; -fx-font-size: 15px;");
        usuarioDestinoLabel.setLayoutX(80);
        usuarioDestinoLabel.setLayoutY(50);
        //Label

        labelPreview2.setStyle("-fx-text-fill: white; -fx-font-size: 15px;");
        labelPreview2.setLayoutX(80);
        labelPreview2.setLayoutY(80);
        labelPreview2.setText(nuevoDestinatario.getDatosTransferenciaDestino());




        previewDos.getChildren().addAll(label, labelPreview2,usuarioDestinoLabel);
        return previewDos;
    }
    Pane previewTres(){

        previewTres.setStyle("-fx-background-color: #02ffb6;");
        previewTres.setLayoutX(0);
        previewTres.setLayoutY(320);
        previewTres.setPrefSize(328, 120);
        previewTres.setId("PanePreviewDos");

        labelPreview3.setLayoutX(25);
        labelPreview3.setLayoutY(50);
        labelPreview3.setStyle("-fx-text-fill: white; -fx-font-size: 25px;");
        labelPreview3.setText("$"+ cantidadADepositar[0]);


        previewTres.getChildren().addAll(labelPreview3,importeLabel("white",25,"Bold",25,20));
        return previewTres;
    }
    Pane previewCuatro(){

        previewCuatro.setStyle("-fx-background-color: #68da42;");
        previewCuatro.setLayoutX(0);
        previewCuatro.setLayoutY(440);
        previewCuatro.setPrefSize(328, 120);
        previewCuatro.setId("PanePreviewTres");
        previewCuatro.getChildren().addAll();
        return previewCuatro;
    }

    /**
     * Este boton será temporalmente el boton de transferir
     * @return
     */
    private Button botonTransferir(){

        botonTransferir.setId("BotonContinuar");
        botonTransferir.setLayoutX(95);
        botonTransferir.setLayoutY(570);

        botonTransferir.setOnAction(Event -> {
            System.out.println("BOTON TRANSFERIR CLICKEADO");
            double cantidad = Double.parseDouble(importeField.getText());
            operacionesDAO.transferirDOS(mainLayoutImporte,"","",cantidad);
        });

        return botonTransferir;

    }
    public void setUsuarioDestino(String usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

    public Pane getRoot(){
        return mainLayoutImporte;
    }

}
