
package clases;

import javax.swing.JPanel;

public class Serpiente {

    public int colocacionX, colocacionY;
    public int altoPanel, anchoPanel;

    public Serpiente(int colocacionX, int colocacionY, int numFilas, int numCols){
        this.colocacionX=colocacionX;
        this.colocacionY=colocacionY;
        this.altoPanel=numFilas;
        this.anchoPanel=numCols;
    }

}
