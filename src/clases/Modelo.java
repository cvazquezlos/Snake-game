/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JPanel;

public class Modelo extends Observable{

    private ArrayList<Serpiente> serpiente;
    private int direccion, ultimaDir, direccionAnterior;
    private Color colorFondoVista, colorSerpiente, colorTrofeo1, colorTrofeo2;
    private int numFilasVista, numColumnasVista;
    private int velocidad;


    public Modelo(){
        serpiente=new ArrayList<Serpiente>();
        direccion=0;
        ultimaDir=0;
        direccionAnterior=0;
        colorFondoVista=new java.awt.Color(204, 255, 204);
        colorSerpiente=new java.awt.Color(254, 46, 46);
        colorTrofeo1=new java.awt.Color(46, 154, 254);
        colorTrofeo2=Color.blue;
        numFilasVista=40;
        numColumnasVista=40;
        velocidad=90;
        Serpiente serp=new Serpiente(5,5,5,5);
        serpiente.add(serp);
        ActualizaTablero actualiza=new ActualizaTablero();
        actualiza.start();
    }

    public int getFilas(){
        return this.numFilasVista;
    }

    public int getCols(){
        return this.numColumnasVista;
    }

    public Color getColorSerpiente(){
        return this.colorSerpiente;
    }

    public Color getColorFondo(){
        return colorFondoVista;
    }

    public ArrayList<Serpiente> getSerpiente(){
        return serpiente;
    }

    public void notificaCambios() {
        this.setChanged();
        this.notifyObservers();
    }

    public void insertarDirecciones(int direccion, int ultimaDir, int direccionAnterior){
        this.direccion=direccion;
        this.ultimaDir=ultimaDir;
        this.direccionAnterior=direccionAnterior;
        actualizaPosicion();
    }

    public void actualizaVelocidad(int velocidad){
       this.velocidad=velocidad;
    }

    public void actualizaPosicion(){
        Serpiente serp;
        switch (direccion){
            case (1):
                serp=new Serpiente(serpiente.get(serpiente.size()-1).altoPanel-1,serpiente.get(serpiente.size()-1).anchoPanel,serpiente.get(serpiente.size()-1).altoPanel-1,serpiente.get(serpiente.size()-1).anchoPanel);
                serpiente.add(serp);
                ultimaDir=1;
                break;
            case (2):
                serp=new Serpiente(serpiente.get(serpiente.size()-1).altoPanel+1,serpiente.get(serpiente.size()-1).anchoPanel,serpiente.get(serpiente.size()-1).altoPanel+1,serpiente.get(serpiente.size()-1).anchoPanel);
                serpiente.add(serp);
                ultimaDir=2;
                break;
            case (3):
                serp=new Serpiente(serpiente.get(serpiente.size()-1).altoPanel,serpiente.get(serpiente.size()-1).anchoPanel-1,serpiente.get(serpiente.size()-1).altoPanel,serpiente.get(serpiente.size()-1).anchoPanel-1);
                serpiente.add(serp);
                ultimaDir=3;
                break;
            case (4):
                serp=new Serpiente(serpiente.get(serpiente.size()-1).altoPanel,serpiente.get(serpiente.size()-1).anchoPanel+1,serpiente.get(serpiente.size()-1).altoPanel,serpiente.get(serpiente.size()-1).anchoPanel+1);
                serpiente.add(serp);
                ultimaDir=4;
                break;
        }
        // Eliminamos el panel de su posición anterior, porque hemos creado el panel en la nueva posición, luego ha habido movimiento
        if(direccion!=0)
            serpiente.remove(0);
    }

    class ActualizaTablero extends Thread{
        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(velocidad);
                    actualizaPosicion();
                } catch (Exception ex) {
                    System.out.println("Te has salido de los límites.");
                    System.exit(1);
                }
            }
        }
    }

}
