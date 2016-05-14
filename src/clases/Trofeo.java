/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

/**************************** CLASE DEL OBJETO "TROFEO". ***************************
Esta clase implementa los trofeos y sus características.
************************************************************************************/
public class Trofeo {

    /***************************** ATRIBUTOS DE CLASE. *****************************
    Tienen acceso privado para facilitar el encapsulamiento. Para acceder a su con-
    tenido emplearemos los métodos get y set (si es necesario).
    ********************************************************************************/
    private int colocacionX, colocacionY;

    /*************************** CONSTRUCTOR DE LA CLASE. **************************
    No recibe ningún argumento en especial.
    ********************************************************************************/
    public Trofeo(){
        colocacionX=0;
        colocacionY=0;
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

    public void setColocacionX(int colocacionX){
        this.colocacionX=colocacionX;
    }

    public void setColocacionY(int colocacionY){
        this.colocacionY=colocacionY;
    }
}
