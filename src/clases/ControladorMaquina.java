/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

/******************************* PAQUETES IMPORTADOS *******************************/
import java.util.ArrayList;

/************************* CLASE DEL OBJETO "CONTROLADOR". *************************
Esta clase permite controlar el modelo. Implementa el patrón MVC para la IA.
************************************************************************************/
public class ControladorMaquina extends Thread{

    /***************************** ATRIBUTOS DE CLASE. *****************************
    Tienen acceso privado para facilitar el encapsulamiento. Para acceder a su con-
    tenido emplearemos los métodos get y set (si es necesario).
    ********************************************************************************/
    private Modelo modelo;
    private int ultimaDir, direccion, velocidad;
    private ArrayList<Serpiente> serpienteIA;
    private int posicionX, posicionY;

    /*************************** CONSTRUCTOR DE LA CLASE. **************************
    Recibe como argumento el modelo.
    ********************************************************************************/
    public ControladorMaquina(Modelo modelo){
        this.modelo=modelo;
        ultimaDir=0;
        direccion=0;
    }

    /*************************** MÉTODOS GETTER Y SETTER. **************************
    Los métodos getter y setter permiten acceder a los elementos de la clase (métodos
    getter) y modificarlos (métodos setter).
    ********************************************************************************/
    public void getDatos(ArrayList<Serpiente> serpienteIA, int posicionX, int posicionY, int velocidad){
        this.serpienteIA=serpienteIA;
        this.posicionX=posicionX;
        this.posicionY=posicionY;
        this.velocidad=velocidad;
    }

    /****************************** MÉTODOS DE CLASE. ******************************
    Agregan funcionalidades al objeto de la clase.
    ********************************************************************************/
    @Override
    public void run(){
        while (true){
            try{
                this.getDatos(modelo.getSerpienteIA(), modelo.getPosicionX(), modelo.getPosicionY(), modelo.getVelocidadIA());
                int diferenciaX=(serpienteIA.get(serpienteIA.size()-1).getColocacionX()-posicionX);
                int diferenciaY=(serpienteIA.get(serpienteIA.size()-1).getColocacionY()-posicionY);
                if (diferenciaX==0||diferenciaY==0){
                    if (diferenciaX==0)
                        if (diferenciaY>0)
                            if (ultimaDir!=4){
                                direccion=3;
                                ultimaDir=3;
                            }else{
                                direccion=1;
                                ultimaDir=1;
                            }
                        else
                            if (ultimaDir!=3){
                                direccion=4;
                                ultimaDir=4;
                            }else{
                                direccion=2;
                                ultimaDir=2;
                            }
                    else if (diferenciaY==0)
                        if (diferenciaX>0)
                            if (ultimaDir!=2){
                                direccion=1;
                                ultimaDir=1;
                            }else{
                                direccion=3;
                                ultimaDir=3;
                            }
                        else
                            if (ultimaDir!=1){
                                direccion=2;
                                ultimaDir=2;
                            }else{
                                direccion=4;
                                ultimaDir=4;
                            }
                } else {
                    if (Math.abs(diferenciaX)>Math.abs(diferenciaY)){
                        if (diferenciaX>0)
                            if (ultimaDir!=2){
                                direccion=1;
                                ultimaDir=1;
                            }else{
                                direccion=3;
                                ultimaDir=3;
                            }
                        else
                            if (ultimaDir!=1){
                                direccion=2;
                                ultimaDir=2;
                            }else{
                                direccion=4;
                                ultimaDir=4;
                            }
                    }else{
                        if (diferenciaY>0)
                            if (ultimaDir!=4){
                                direccion=3;
                                ultimaDir=3;
                            }else{
                                direccion=1;
                                ultimaDir=1;
                            }
                        else
                            if (ultimaDir!=3){
                                direccion=4;
                                ultimaDir=4;
                            }else{
                                direccion=2;
                                ultimaDir=2;
                            }
                    }
                }
                modelo.setDireccionesIA(direccion, ultimaDir);
                Thread.sleep(velocidad);
            } catch (Exception ex){}
        }
    }

}
