package UserRegistration;
import Interfaces.MetodosRegistro;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


/**
 *  Clase que contiene los metodos para la pantalla de bienvenida
 *  ( <---- Pantalla 1 ----> )
 */
public class Controller1 implements MetodosRegistro {
    private Pane mainLayout;

    public Controller1(){

        setupIU();

    }



    private void setupIU(){
        Cargarimagenes imagenes = new Cargarimagenes();
        ImageView BckG = imagenes.bienvenidaLogo();
        Button menu1 = imagenes.ImgMenu1();
        Button tokenMovil = imagenes.tokenMovilIMg();
        Button operacionQR = imagenes.operacionQR();
        Button emergencias = imagenes.emergencias();
        ImageView imgFoot = imagenes.imgFoot();

        mainLayout = new Pane();

        mainLayout.getChildren().addAll(BckG,iniciarSesion(), menu1,imgFoot,tokenMovil,operacionQR,emergencias,pregunta(),TextoOnTop(),QuieroSaber(),h2());
    }


    private Label TextoOnTop(){
        Label NombreDelBanco = new Label();
        NombreDelBanco.setId("h1");
        NombreDelBanco.setText("Apple Bank");

        NombreDelBanco.setLayoutX(114);
        NombreDelBanco.setLayoutY(30);

        return NombreDelBanco;
    }

    public Button iniciarSesion(){
        Button boton1 = new Button("Iniciar Sesion");
        boton1.setId("BotonSuperior");
        boton1.setOnAction(event ->{
            /*
            Random numeroRandom = new Random();
            int a = numeroRandom.nextInt(100);
            */
            int numeroAleatorio = (int) (Math.random() * 100);
            System.out.println(numeroAleatorio);



            cargarPantallaInicioSesion();


        });
        boton1.setLayoutX(108);
        boton1.setLayoutY(180);

        return boton1;
    }

    private Label pregunta(){
        Label label = new Label("¿Y si te encontraras 200?");
        label.setId("pregunta");

        label.setLayoutX(84);
        label.setLayoutY(470);

        return label;
    }

    private Label h2(){
        Label label = new Label("Con plan Apple Bank Guardas dinero sin darte cuenta\n" +
                "                  Date un gustito con eso que juntes");

        label.setId("h2");
        label.setLayoutX(20);
        label.setLayoutY(495);

        return label;
    }
    private Button QuieroSaber(){
        Button boton = new Button("Quiero saber más");
        boton.setId("BotonInferior");
        boton.setLayoutX(104);
        boton.setLayoutY(550);
        boton.setOnAction(event ->{
            System.out.println("Boton Quiero saber mas on click ");
        });

        return boton;
    }
    //private static Button boton = new Button("Inicio");


    /**
     * este es el boton de inicio que lleva a la pagina principal
     */
    private Button boton;
    public Button botonInicio(){
        boton = new Button("Inicio");

        boton.setLayoutX(380);
        boton.setLayoutY(40);
        /*boton.setOnAction(event ->{
            cargarPaginaMain();
            Animaciones animaciones = new Animaciones();
            animaciones.reiniciarPantallas();
            Cargarimagenes cargarimagenes = new Cargarimagenes();
            cargarimagenes.setBotonSeleccionado(false);


        });*/

        boton.setOnAction(event -> {


            cargarPaginaMain();
            Animaciones animaciones = new Animaciones();
            animaciones.setEstadoBoton(false);

            //Este metodo hace que llame a la funcion reiniciar pantallas de las animaciones
            //animaciones.reiniciarPantallas();
            // Cambiar el estado de OtroButton al hacer clic en ImgButton
            //cambiarEstado(false);

        });
        return boton;
    }/*
    public void cambiarEstado(boolean estado) {
        boton.setSelected(estado);
    }*/

    public Pane getRoot() {
        return mainLayout;
    }

}

