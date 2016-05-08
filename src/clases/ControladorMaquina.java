/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

/******************************* PAQUETES IMPORTADOS *******************************/
import java.util.ArrayList;

public class ControladorMaquina extends Thread{

    private Modelo modelo;
    private int ultimaDir, direccion, velocidad;
    private ArrayList<Serpiente> serpienteIA;
    private int posicionX, posicionY;

    public ControladorMaquina(Modelo modelo){
        this.modelo=modelo;
        ultimaDir=0;
        direccion=0;
    }

    public void getDatos(ArrayList<Serpiente> serpienteIA, int posicionX, int posicionY){
        this.serpienteIA=serpienteIA;
        this.posicionX=posicionX;
        this.posicionY=posicionY;
    }

    @Override
    public void run(){
        while (true){
            try{
                this.getDatos(modelo.getSerpienteIA(), modelo.getPosicionX(), modelo.getPosicionY());
                int diferenciaX=(serpienteIA.get(0).getColocacionX()-posicionX);
                int diferenciaY=(serpienteIA.get(0).getColocacionY()-posicionY);
                if (diferenciaX==0||diferenciaY==0){
                    if (diferenciaX==0)
                        if (diferenciaY>0)
                            direccion=3;
                        else
                            direccion=4;
                    else if (diferenciaY==0)
                        if (diferenciaX>0)
                            direccion=1;
                        else
                            direccion=2;
                } else {
                    if (Math.abs(diferenciaX)>Math.abs(diferenciaY)){
                        if (diferenciaX>0)
                            direccion=1;
                        else
                            direccion=2;
                    }else{
                        if (diferenciaY>0)
                            direccion=3;
                        else
                            direccion=4;
                    }
                }
                modelo.setDireccionesIA(direccion, ultimaDir);
                Thread.sleep(velocidad);
            } catch (Exception ex){}
        }
    }

}
