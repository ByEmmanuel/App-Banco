package Excepciones;

import Interfaces.MetodosRegistro;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class VentanaDeExito extends RuntimeException {


    private static final Pane errorLayout = new Pane();
    VBox vbox = new VBox();

    public VentanaDeExito(Pane mainLayout, String mensajeDeExito) {

        errorLayout.setMaxWidth(300);
        errorLayout.setMaxHeight(300);
        errorLayout.setLayoutX(89);
        errorLayout.setLayoutY(150);
        errorLayout.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-padding: 10px;");

        //vbox.setMaxWidth(300);
        //vbox.setMaxHeight(300);
        //vbox.setLayoutX(90);
        //vbox.setLayoutY(150);


        // Establecer alineación del VBox
        //vbox.setAlignment(Pos.CENTER); // También puedes usar Pos.TOP_LEFT, Pos.BOTTOM_RIGHT, etc.


        // Establecer espaciado entre elementos (en píxeles)
        //vbox.setSpacing(30); // Puedes ajustar este valor según tus necesidades


        // Establecer el relleno del VBox
        //vbox.setPadding(new Insets(20, 10, 20, 10));


        errorLayout.setId("ErrorLayout-Mensaje");

        //Aqui se agregan los elementod al pane que se mostrara dentro de otro pane (de donde es llamado)
        errorLayout.getChildren().addAll( Msg(mensajeDeExito),boton());



        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        errorLayout.getStylesheets().add(CSS);

        //Mostrar La escena

        mainLayout.getChildren().addAll(errorLayout);

    }



    private Label Msg(String mensajeDeExito) {
        Label Errormsg = new Label();
        Errormsg.setId("MensajeExito");
        Errormsg.setText(mensajeDeExito);

        Errormsg.setLayoutX(20);
        Errormsg.setLayoutY(50);

        return Errormsg;
    }

    private Button boton(){
        Button boton = new Button("Ok");

        boton.setId("BotonContinuarRegistro");
        boton.setStyle("""
                -fx-font-weight: bold;  \s
                -fx-text-fill: white;   \s
                -fx-border-color: #1b74bc;
                    -fx-border: 50%;
                    -fx-border-radius: 0px;
                    -fx-display: flex;
                    -fx-background-color: #156baa;
                    -fx-border-width: 1px;
                    -fx-padding: 12 40 12 40;
                    -fx-font-size: 13px;""");
        boton.setOnAction(Event -> {

            // Esto es para cerrar la ventana de error
            vbox.setVisible(false);

            errorLayout.setVisible(false);


            

        });
        boton.setLayoutX(35);
        boton.setLayoutY(170);
        return boton;
    }


}
