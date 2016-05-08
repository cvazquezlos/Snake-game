/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

/******************************* PAQUETES IMPORTADOS *******************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/************************* CLASE DEL OBJETO "CONTROLADOR". *************************
Esta clase permite controlar el modelo. Implementa el patrón MVC.
************************************************************************************/
public class Controlador implements KeyListener{

    /***************************** ATRIBUTOS DE CLASE. *****************************
    Tienen acceso privado para facilitar el encapsulamiento. Para acceder a su con-
    tenido emplearemos los métodos get y set (si es necesario).
    ********************************************************************************/
    private Modelo modelo;
    private int ultimaDir, direccion, direccionAnterior, velocidad;

    /*************************** CONSTRUCTOR DE LA CLASE. **************************
    Recibe como argumento el modelo y la vista a la que asociará el KeyListener.
    ********************************************************************************/
    public Controlador(Modelo modelo, VistaTablero vista){
        this.modelo=modelo;
        ultimaDir=0;
        direccion=0;
        direccionAnterior=0;
        velocidad=90;
        // Añadimos nuestra vista como interfaz del controlador
        vista.addKeyListener(this);
    }

    /*************************** MÉTODOS GETTER Y SETTER. **************************
    Los métodos getter y setter permiten acceder a los elementos de la clase (métodos
    getter) y modificarlos (métodos setter).
    ********************************************************************************/
    public void setUltimasDirecciones(int ultimaDir, int direccionAnterior){
        this.ultimaDir=ultimaDir;
        this.direccionAnterior=direccionAnterior;
    }

    /****************************** MÉTODOS DE CLASE. ******************************
    Agregan funcionalidades al objeto de la clase.
    ********************************************************************************/
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Actualizamos las últimas direcciones para conocer, en concreto, ultimaDir y direccionAnterior,
        // que nos servirán para evitar que si anteriormente se ha pulsado la tecla hacia arriba, no se
        // pulse la tecla hacia abajo (este movimiento no está permitido en la serpiente), se deberá pulsar
        // antes a alguna tecla de los lados, y lo mismo sucede con las teclas de giro
        setUltimasDirecciones(modelo.getUltimaDir(), modelo.getDireccionAnterior());
        switch(e.getKeyCode()){
            // Pulsamos hacia arriba
            case (KeyEvent.VK_UP):
                // Si pulsamos hacia arriba, no podemos pulsar hacia abajo, debemos girar antes
                if (ultimaDir!=2)
                    direccion=1;
                // Modificamos el modelo para mostrar el movimiento por la vista
                modelo.setDirecciones(direccion, ultimaDir, direccionAnterior);
                break;
            // Pulsamos hacia abajo
            case (KeyEvent.VK_DOWN):
                // Si pulsamos hacia abajo, no podemos pulsar hacia arriba, debemos girar antes
                if (ultimaDir!=1)
                    direccion=2;
                // Modificamos el modelo para mostrar el movimiento por la vista
                modelo.setDirecciones(direccion, ultimaDir, direccionAnterior);
                break;
            // Pulsamos hacia la izquierda
            case (KeyEvent.VK_LEFT):
                // Si pulsamos hacia la izquierda, debemos ir hacia arriba o hacia abajo antes de girar hacia la derecha
                if (ultimaDir!=4)
                    direccion=3;
                // Modificamos el modelo para mostrar el movimiento por la vista
                modelo.setDirecciones(direccion, ultimaDir, direccionAnterior);
                break;
            // Pulsamos hacia la derecha
            case (KeyEvent.VK_RIGHT):
                // Si pulsamos hacia la derecha, debemos ir hacia arriba o hacia abajo antes de girar hacia la izquierda
                if (ultimaDir!=3)
                    direccion=4;
                // Modificamos el modelo para mostrar el movimiento por la vista
                modelo.setDirecciones(direccion, ultimaDir, direccionAnterior);
                break;
            // Pulsamos P
            case (KeyEvent.VK_P):
                // Pausa del juego
                if (direccion!=0){
                    direccionAnterior=direccion;
                    direccion=0;
                }
                // Si ya se había pausado el juego, lo reanuda
                else
                    direccion=direccionAnterior;
                // Modificamos el modelo para parar el juego en la vista, o para reanudarlo si previamente se ha parado
                modelo.setDirecciones(direccion, ultimaDir, direccionAnterior);
                break;
            // Pulsamos la tecla + (del teclado numérico)
            case (KeyEvent.VK_ADD):
                // La velocidad incrementa en 10 unidades (drecementa el número de píxeles necesarios para recorrer una unidad)
                velocidad-=10;
                // Modificamos el modelo para incrementar la velocidad en la vista
                modelo.setVelocidad(velocidad);
                break;
            // Pulsamos la tecla + (del teclado numérico)
            case (KeyEvent.VK_SUBTRACT):
                // La velocidad decrementa en 10 unidades (incrementa el número de píxeles necesarios para recorrer una unidad)
                velocidad+=10;
                // Modificamos el modelo para decrementar la velocidad en la vista
                modelo.setVelocidad(velocidad);
                break;
        }
    }

}
