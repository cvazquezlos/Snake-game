/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controlador implements KeyListener{

    Modelo modelo;
    private int ultimaDir, direccion, direccionAnterior, velocidad;

    public Controlador(Modelo modelo, Vista vista){
        this.modelo=modelo;
        ultimaDir=0;
        direccion=0;
        direccionAnterior=0;
        velocidad=90;
        vista.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            // Pulsamos hacia arriba
            case (KeyEvent.VK_UP):
                // Si pulsamos hacia arriba, no podemos pulsar hacia abajo, debemos girar antes
                if (ultimaDir!=2)
                    direccion=1;
                modelo.insertarDirecciones(direccion, ultimaDir, direccionAnterior);
                modelo.notificaCambios();
                break;
            // Pulsamos hacia abajo
            case (KeyEvent.VK_DOWN):
                // Si pulsamos hacia abajo, no podemos pulsar hacia arriba, debemos girar antes
                if (ultimaDir!=1)
                    direccion=2;
                modelo.insertarDirecciones(direccion, ultimaDir, direccionAnterior);
                modelo.notificaCambios();
                break;
            // Pulsamos hacia la izquierda
            case (KeyEvent.VK_LEFT):
                // Si pulsamos hacia la izquierda, debemos ir hacia arriba o hacia abajo antes de girar hacia la derecha
                if (ultimaDir!=4)
                    direccion=3;
                modelo.insertarDirecciones(direccion, ultimaDir, direccionAnterior);
                modelo.notificaCambios();
                break;
            // Pulsamos hacia la derecha
            case (KeyEvent.VK_RIGHT):
                // Si pulsamos hacia la derecha, debemos ir hacia arriba o hacia abajo antes de girar hacia la izquierda
                if (ultimaDir!=3)
                    direccion=4;
                modelo.insertarDirecciones(direccion, ultimaDir, direccionAnterior);
                modelo.notificaCambios();
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
                modelo.insertarDirecciones(direccion, ultimaDir, direccionAnterior);
                modelo.notificaCambios();
                break;
            // Pulsamos la tecla + (del teclado numérico)
            case (KeyEvent.VK_ADD):
                // La velocidad incrementa en 10 unidades (drecementa el número de píxeles necesarios para recorrer una unidad)
                velocidad-=10;
                modelo.actualizaVelocidad(velocidad);
                modelo.notificaCambios();
                break;
            // Pulsamos la tecla + (del teclado numérico)
            case (KeyEvent.VK_SUBTRACT):
                // La velocidad decrementa en 10 unidades (incrementa el número de píxeles necesarios para recorrer una unidad)
                velocidad+=10;
                modelo.actualizaVelocidad(velocidad);
                modelo.notificaCambios();
                break;
        }
    }

}
