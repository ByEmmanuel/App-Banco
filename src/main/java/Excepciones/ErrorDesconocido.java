package Excepciones;

import Interfaces.MetodosRegistro;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ErrorDesconocido extends RuntimeException {

    private static final Pane errorLayout = new Pane();
    VBox vbox = new VBox();
    private static final int anchura = 80;
    private static final int altura = 200;


    public ErrorDesconocido(Pane mainLayout,String mensajeDeError,TextField textField) {


        //errorLayout.setMaxWidth(300);
        //errorLayout.setMaxHeight(300);
        //errorLayout.setLayoutX(60);
        //errorLayout.setLayoutY(300);
        vbox.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #000000; -fx-border-width: 2px; -fx-border-radius: 5px;");
        vbox.setMaxWidth(300);
        vbox.setMaxHeight(300);
        vbox.setLayoutX(anchura);
        vbox.setLayoutY(altura);


        // Establecer alineación del VBox
        vbox.setAlignment(Pos.CENTER); // También puedes usar Pos.TOP_LEFT, Pos.BOTTOM_RIGHT, etc.


        // Establecer espaciado entre elementos (en píxeles)
        vbox.setSpacing(30); // Puedes ajustar este valor según tus necesidades


        // Establecer el relleno del VBox
        vbox.setPadding(new Insets(20, 10, 20, 10));


        errorLayout.setId("ErrorLayout-Pane");

        //Aqui se agregan los elementod al pane que se mostrara dentro de otro pane (de donde es llamado)
        vbox.getChildren().addAll( Msg(mensajeDeError),boton(textField));



        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        errorLayout.getStylesheets().add(CSS);

        //Mostrar La escena

        mainLayout.getChildren().addAll(vbox);

    }



    private Label Msg(String mensajeDeError) {
        Label Errormsg = new Label();
        Errormsg.setId("MensajeError");
        Errormsg.setText(mensajeDeError);

        Errormsg.setLayoutX(30);
        Errormsg.setLayoutY(50);

        return Errormsg;
    }

    private Button boton(TextField textField){
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
            textField.setEditable(true);



        });
        boton.setLayoutX(210);
        boton.setLayoutY(235);
        return boton;
    }

    public ErrorDesconocido(Pane mainLayout,String mensajeDeError ) {


        //errorLayout.setMaxWidth(300);
        //errorLayout.setMaxHeight(300);
        //errorLayout.setLayoutX(60);
        //errorLayout.setLayoutY(300);
        vbox.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #000000; -fx-border-width: 2px; -fx-border-radius: 5px;");
        vbox.setMaxWidth(300);
        vbox.setMaxHeight(300);
        vbox.setLayoutX(anchura);
        vbox.setLayoutY(altura);


        // Establecer alineación del VBox
        vbox.setAlignment(Pos.CENTER); // También puedes usar Pos.TOP_LEFT, Pos.BOTTOM_RIGHT, etc.


        // Establecer espaciado entre elementos (en píxeles)
        vbox.setSpacing(30); // Puedes ajustar este valor según tus necesidades


        // Establecer el relleno del VBox
        vbox.setPadding(new Insets(20, 10, 20, 10));


        errorLayout.setId("ErrorLayout-Pane");

        //Aqui se agregan los elementod al pane que se mostrara dentro de otro pane (de donde es llamado)
        vbox.getChildren().addAll( Msg(mensajeDeError),boton());



        //Agregar los estilos CSS
        String CSS = String.valueOf(MetodosRegistro.class.getResource("/Styles/styles.css"));
        errorLayout.getStylesheets().add(CSS);

        //Mostrar La escena

        mainLayout.getChildren().addAll(vbox);

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




        });
        boton.setLayoutX(210);
        boton.setLayoutY(235);
        return boton;
    }


}
