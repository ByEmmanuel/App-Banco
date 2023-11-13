package Controllers;

import Interfaces.MetodosAB;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Animaciones implements MetodosAB {

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

    public void setEstadoBoton(boolean valor) {
        haciaIzquierda = valor;
    }
}
