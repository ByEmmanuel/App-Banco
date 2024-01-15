package UserRegistration;

import Interfaces.MainInterfaceUser;
import Interfaces.MetodosRegistro;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Animaciones implements MetodosRegistro, MainInterfaceUser {

    public TranslateTransition moveTransition;
    public boolean haciaIzquierda = false;


/*

    public void reiniciarPantallas() {
        if (moveTransition != null && moveTransition.getStatus() == Animation.Status.RUNNING) {
            moveTransition.stop();
        }

        // Asegúrate de que el panel esté en su posición inicial
        controller2.getRoot().setTranslateX(0);

        // Configurar la animación para mover hacia la izquierda
        moveTransition = new TranslateTransition(Duration.seconds(0.7), controller2.getRoot());
        moveTransition.setByX(0); // Mover 100 píxeles hacia la izquierda
        moveTransition.play();
        haciaIzquierda =! haciaIzquierda;

        //cargarimagenes.setActualizarValorBoton(false);
        */
/*
        if (moveTransition != null && moveTransition.getStatus() == Animation.Status.PAUSED) {
            // Si la animación está en curso, detenerla y revertirla
            moveTransition.stop();
            moveTransition.setRate(-1.0); // Configurar la velocidad hacia la izquierda
            moveTransition.play();

            //haciaIzquierda = !haciaIzquierda;
            System.out.println("Funcionando if");
        } else {
            // Configurar la animación de movimiento
            moveTransition.setRate(1.0); // Configurar la velocidad hacia la derecha
            System.out.println("Funcionando else");
            *//*
*/
/*if (haciaIzquierda) {
                moveTransition.setByX(170); // Mover 100 píxeles hacia la derecha
                System.out.println("If dentro del if funcionando");
            } else {
                moveTransition.setByX(170); // Mover 100 píxeles hacia la izquierda
                System.out.println("else dentro del if funcionando");
            }*//*
*/
/*
            moveTransition.play();
            //haciaIzquierda = !haciaIzquierda;
        }*//*

    }
*/

    public void moverPantallaPrincipal() {

        moveTransition = new TranslateTransition(Duration.seconds(0.7), controller1.getRoot());
        moveTransition.setByX(-100); // Mover 100 píxeles hacia la izquierda
        if (moveTransition != null && moveTransition.getStatus() == Animation.Status.RUNNING) {
            // Si la animación está en curso, detenerla y revertirla
            moveTransition.stop();
            moveTransition.setRate(-1.0); // Configurar la velocidad hacia la izquierda
            moveTransition.play();
            haciaIzquierda = !haciaIzquierda;

        } else {
            // Configurar la animación de movimiento
            moveTransition.setRate(1.0); // Configurar la velocidad hacia la derecha
            if (haciaIzquierda) {

                moveTransition.setByX(170); // Mover 100 píxeles hacia la derecha
            } else {
                moveTransition.setByX(-170); // Mover 100 píxeles hacia la izquierda
            }
            moveTransition.play();
        }
        haciaIzquierda = !haciaIzquierda;

    }
    public void moverPantallaInicioSesion() {
        moveTransition = new TranslateTransition(Duration.seconds(0.7), controller2.getRoot());

        //moveTransition.setByX(-100); // Mover 100 píxeles hacia la izquierda
        if (moveTransition != null && moveTransition.getStatus() == javafx.animation.Animation.Status.RUNNING ) {
            // Si la animación está en curso, detenerla y revertirla
            moveTransition.stop();
            moveTransition.setRate(-1.0); // Configurar la velocidad hacia la izquierda
            moveTransition.play();
            //haciaIzquierda = !haciaIzquierda;
        } else {
            // Configurar la animación de movimiento
            moveTransition.setRate(1.0); // Configurar la velocidad hacia la derecha
            //Si es true el hacieizquierda se movera a derecha
            if (haciaIzquierda) {
                System.out.println("Moviendo haciA derecha");
                moveTransition.setByX(170); // Mover 100 píxeles hacia la derecha

            } else {

                moveTransition.setByX(-170); // Mover 100 píxeles hacia la izquierda

                System.out.println("Moviendo haciA izquierda");

            }
            moveTransition.play();
            haciaIzquierda = !haciaIzquierda;
        }

    }
    public void moverPantallaRegistro() {
        moveTransition = new TranslateTransition(Duration.seconds(0.7), controller3.getRoot());
        moveTransition.setByX(-100); // Mover 100 píxeles hacia la izquierda
        if (moveTransition != null && moveTransition.getStatus() == javafx.animation.Animation.Status.RUNNING) {
            // Si la animación está en curso, detenerla y revertirla
            moveTransition.stop();
            moveTransition.setRate(-1.0); // Configurar la velocidad hacia la izquierda
            moveTransition.play();
            haciaIzquierda = !haciaIzquierda;
        } else {
            // Configurar la animación de movimiento
            moveTransition.setRate(1.0); // Configurar la velocidad hacia la derecha
            if (haciaIzquierda) {
                moveTransition.setByX(170); // Mover 100 píxeles hacia la derecha
            } else {
                moveTransition.setByX(-170); // Mover 100 píxeles hacia la izquierda
            }
            moveTransition.play();
            haciaIzquierda = !haciaIzquierda;
        }

    }

    public void animacionesDeEntrada(Pane pane){
        moveTransition = new TranslateTransition(Duration.seconds(0.7), pane);
        moveTransition.setFromY(600);
        moveTransition.setToY(0);
        moveTransition.play();
    }
    public void animacionesDeCarga(Pane pane){
        moveTransition = new TranslateTransition(Duration.seconds(0.5), pane);
        moveTransition.setFromX(-500);
        moveTransition.setToX(0);
        moveTransition.play();
    }
    public void animacionesDeSalida(Pane pane){
        moveTransition = new TranslateTransition(Duration.seconds(0.7), pane);
        moveTransition.setFromY(0);
        moveTransition.setToY(600);
        moveTransition.play();
        new Thread(() -> {
            try {
                Thread.sleep(100); // Espera durante el tiempo especificado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                moveTransition.setFromY(700);
                moveTransition.setToY(0);
                moveTransition.play();
            });
        }).start();


    }
    public void resetPantallas(Pane pane){
        moveTransition = new TranslateTransition(Duration.seconds(0.1), pane);
        moveTransition.setFromY(600);
        moveTransition.setToY(0);
        moveTransition.play();
    }
    public void animacionesVertical(Pane pane, int deY, int aY){
        moveTransition = new TranslateTransition(Duration.seconds(0.5), pane);
        moveTransition.setFromY(deY);
        moveTransition.setToY(aY);
        moveTransition.play();
    }

    public void setEstadoBoton(boolean valor) {
        haciaIzquierda = valor;
    }
}
