package UserDashboard;

import Interfaces.MetodosUserDashBoard;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class BarraNavegacion implements MetodosUserDashBoard {

    /**
     *
     */
    Pane mainLayout = new Pane();


    public BarraNavegacion(){
        setupIU();
    }

    private void setupIU(){



        mainLayout.setPrefSize(380, 60);
        mainLayout.setLayoutX(0);

        // Modificar el valor de Y para cambiar la altura de la barra de navegación
        mainLayout.setLayoutY(579);




       mainLayout.setId("Barra-Desplazamiento");

       mainLayout.getChildren().addAll(botonHome(),vidaFinanciera(),botonMasProductos(),botonBuzon(),botonPerfil());

    }

    public Button botonHome() {
        Button ImgButton = new Button();
        ImgButton.setId("Boton-Menu");
        URL loginImgUrl = getClass().getResource("/imagenes/home.svg");
        javafx.scene.image.Image loginImage = new Image(loginImgUrl.toString(), 70, 70, false, true);
        ImgButton.setGraphic(new ImageView(loginImage));
        ImgButton.setStyle("");
        ImgButton.setOnAction(Event -> {


            cargarDashBoard();


        });
        // Establecer las coordenadas x e y del botón en el Pane
        ImgButton.setLayoutX(20); // Ajusta la coordenada x según sea necesario
        ImgButton.setLayoutY(20); // Ajusta la coordenada y según sea necesario


        return ImgButton;
    }



    Button vidaFinanciera() {
        Button vidaFinanciera = new Button();
        vidaFinanciera.setId("Botones-Barra-Navegacion");
        vidaFinanciera.setOnAction(Event -> {


            cargarVidaFinanciera();

        });

        vidaFinanciera.setLayoutX(90);
        vidaFinanciera.setLayoutY(20);
        return vidaFinanciera;
    }

    Button botonMasProductos(){
        Button botonMas = new Button();
        botonMas.setId("Botones-Barra-Navegacion");
        botonMas.setOnAction(Event -> {

            cargarOportunidades();

        });

        botonMas.setLayoutX(150);
        botonMas.setLayoutY(20);
        return botonMas;

    }

    Button botonBuzon(){
        Button botonNotis = new Button();
        botonNotis.setId("Botones-Barra-Navegacion");
        botonNotis.setOnAction(Event -> {

           cargarNotificaciones();

        });

        botonNotis.setLayoutX(210);
        botonNotis.setLayoutY(20);
        return botonNotis;

    }

    Button botonPerfil(){
        Button botonAyuda = new Button();
        botonAyuda.setId("Botones-Barra-Navegacion");
        botonAyuda.setOnAction(Event -> {

            cargarAyuda();

        });

        botonAyuda.setLayoutX(270);
        botonAyuda.setLayoutY(20);
        return botonAyuda;

    }

    public Pane getRoot(){
        return mainLayout;
    }

}
