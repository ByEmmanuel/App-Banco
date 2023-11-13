package Controllers;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class Cargarimagenes {
    Animaciones animaciones = new Animaciones();
    public ImageView bienvenidaLogo() {
        URL Img = getClass().getResource("/imagenes/appleBck.jpg");
        Image background = new Image(Img.toString(),330, 316, false, true);
        ImageView bienvenidaLogo = new ImageView(background);
        bienvenidaLogo.setLayoutX(0); // Izquierda A derecha ( X )
        bienvenidaLogo.setLayoutY(0);  // Arriba A Abajo ( Y )
        bienvenidaLogo.setOpacity(0.75);
        return bienvenidaLogo;
    }

    /**
     * BOTON MENU QUE DESPLIEGA VARIAS OPCIONES
     * @return
     */
    public Button ImgMenu1() {
        Button ImgButton = new Button();
        ImgButton.setId("Boton-Menu");
        URL loginImgUrl = getClass().getResource("/imagenes/burger-menuu.png");
        Image loginImage = new Image(loginImgUrl.toString(), 20, 20, false, true);
        ImgButton.setGraphic(new ImageView(loginImage));
        ImgButton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        ImgButton.setOnAction(Event -> {
            animaciones.moverPantallaPrincipal();

        });
        // Establecer las coordenadas x e y del botón en el Pane
        ImgButton.setLayoutX(280); // Ajusta la coordenada x según sea necesario
        ImgButton.setLayoutY(20); // Ajusta la coordenada y según sea necesario


        return ImgButton;
    }
    //boolean botonSeleccionado; //aqui es true
    public boolean botonSeleccionado = false;
    public ToggleButton ImgMenu2() {

        ToggleButton ImgButton = new ToggleButton();
        ImgButton.setId("Boton-Menu");
        URL loginImgUrl = getClass().getResource("/imagenes/burger-menuu.png");
        Image loginImage = new Image(loginImgUrl.toString(), 20, 20, false, true);
        ImgButton.setGraphic(new ImageView(loginImage));
        ImgButton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");

        botonSeleccionado = ImgButton.isSelected();
        //ImgButton.selectedProperty().bindBidirectional(botonSeleccionado);

/**
 * este boton hace que si se hace click en el menu
 * vaya hacia la izquierda
 *
 */
        ImgButton.setOnAction(event -> {
            if (!botonSeleccionado) {
                animaciones.moverPantallaInicioSesion();
                botonSeleccionado = false;
                ImgButton.setText("Activado");
                System.out.println("Botón activado");
            } else {
                if (botonSeleccionado == false){

                //animaciones.moverPantallaInicioSesion();
                }else{
                    //animaciones.reiniciarPantallas();
                }
                botonSeleccionado = true;
                ImgButton.setText("Desactivado");
                System.out.println("Botón desactivado");
            }
        });
        /*
        ImgButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                ImgButton.setText("Activado");
                System.out.println("Botón activado");
            } else {
                ImgButton.setText("Desactivado");
                System.out.println("Botón desactivado");
            }
        });*/
        Controller1 controller1 = new Controller1();

/*

        ImgButton.setOnAction(event -> {
            // Cambiar el estado de ImgButton al hacer clic en OtroButton
            ImgButton.cambiarEstado(ImgButton.isSelected());
        });
*/

        // Establecer las coordenadas x e y del botón en el Pane
        ImgButton.setLayoutX(280); // Ajusta la coordenada x según sea necesario
        ImgButton.setLayoutY(20); // Ajusta la coordenada y según sea necesario


        return ImgButton;
    }
    public Button ImgMenu3() {
        Button ImgButton = new Button();
        ImgButton.setId("Boton-Menu");
        URL loginImgUrl = getClass().getResource("/imagenes/burger-menuu.png");
        Image loginImage = new Image(loginImgUrl.toString(), 20, 20, false, true);
        ImgButton.setGraphic(new ImageView(loginImage));
        ImgButton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        ImgButton.setOnAction(Event -> {

            animaciones.moverPantallaRegistro();
        });
        // Establecer las coordenadas x e y del botón en el Pane
        ImgButton.setLayoutX(280); // Ajusta la coordenada x según sea necesario
        ImgButton.setLayoutY(20); // Ajusta la coordenada y según sea necesario


        return ImgButton;
    }
    public Button tokenMovilIMg() {
        Button boton = new Button();
        boton.setId("Boton-Menu");
        URL Img = getClass().getResource("/imagenes/tokenMovil.png");
        boton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        Image loginImage = new Image(Img.toString(), 77.6, 65, false, true);
        boton.setGraphic(new ImageView(loginImage));
        boton.setStyle("-fx-background-color: transparent; -fx-border-width: 2px;");
        boton.setOnAction(Event -> {


        });
        // Establecer las coordenadas x e y del botón en el Pane
        boton.setLayoutX(15); // Ajusta la coordenada x según sea necesario
        boton.setLayoutY(230); // Ajusta la coordenada y según sea necesario


        return boton;
    }
    public Button operacionQR() {
        Button boton = new Button();
        boton.setId("Boton-Menu");
        URL Img = getClass().getResource("/imagenes/codigoQR.png");
        Image loginImage = new Image(Img.toString(), 77.6, 65, false, true);
        //boton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        boton.setGraphic(new ImageView(loginImage));
        boton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        boton.setOnAction(Event -> {


        });
        // Establecer las coordenadas x e y del botón en el Pane
        boton.setLayoutX(110); // Ajusta la coordenada x según sea necesario
        boton.setLayoutY(235); // Ajusta la coordenada y según sea necesario


        return boton;
    }
    public Button emergencias() {
        Button boton = new Button();
        boton.setId("Boton-Menu");
        URL Img = getClass().getResource("/imagenes/emergencias.png");
        Image loginImage = new Image(Img.toString(), 77.6, 65, false, true);
        //boton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        boton.setGraphic(new ImageView(loginImage));
        boton.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
        boton.setOnAction(Event -> {


        });
        // Establecer las coordenadas x e y del botón en el Pane
        boton.setLayoutX(210); // Ajusta la coordenada x según sea necesario
        boton.setLayoutY(235); // Ajusta la coordenada y según sea necesario


        return boton;
    }
    public ImageView imgFoot() {
        URL Img = getClass().getResource("/imagenes/IMG_6813.jpg");
        Image background = new Image(Img.toString(),192.015, 109.395, false, true);
        ImageView imgL = new ImageView(background);
        imgL.setLayoutX(77); // Izquierda A derecha ( X )
        imgL.setLayoutY(340);  // Arriba A Abajo ( Y )

        return imgL;
    }


    public void setActualizarValorBoton(boolean booleano) {
        botonSeleccionado = booleano;
    }
}
