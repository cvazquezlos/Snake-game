/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

public class Trofeo {
    private int colocacionX, colocacionY;

    public Trofeo(){
        colocacionX=0;
        colocacionY=0;
    }

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
