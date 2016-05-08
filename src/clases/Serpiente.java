/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

/******************************* PAQUETES IMPORTADOS *******************************/
import javax.swing.JPanel;

/************************** CLASE DEL OBJETO "SERPIENTE". **************************
Esta clase implementa la serpiente y sus características.
************************************************************************************/
public class Serpiente {

    /***************************** ATRIBUTOS DE CLASE. *****************************
    Tienen acceso privado para facilitar el encapsulamiento. Para acceder a su con-
    tenido emplearemos los métodos get y set (si es necesario).
    ********************************************************************************/
    private int colocacionX, colocacionY;

    /*************************** CONSTRUCTOR DE LA CLASE. **************************
    No recibe ningún argumento en especial.
    ********************************************************************************/
    public Serpiente(int colocacionX, int colocacionY){
        this.colocacionX=colocacionX;
        this.colocacionY=colocacionY;
    }

    /*************************** MÉTODOS GETTER Y SETTER. **************************
    Los métodos getter y setter permiten acceder a los elementos de la clase (métodos
    getter) y modificarlos (métodos setter).
    ********************************************************************************/
    public int getColocacionX(){
        return colocacionX;
    }

    public int getColocacionY(){
        return colocacionY;
    }

    public void setColocacionY(int colocacionY){
        this.colocacionY=colocacionY;
    }

    public void setColocacionX(int colocacionX){
        this.colocacionX=colocacionX;
    }
}
