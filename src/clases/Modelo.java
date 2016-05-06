/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

/******************************* PAQUETES IMPORTADOS *******************************/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**************************** CLASE DEL OBJETO "MODELO". ***************************
Esta clase es el modelo que extiende de Observable. Como tal, implementa el método
que notifica los cambios a sus observadoras, que mostrarán el contenido del modelo,
en este caso, a través de la pantalla y a través de un tablero.
************************************************************************************/
public class Modelo extends Observable{

    /***************************** ATRIBUTOS DE CLASE. *****************************
    Tienen acceso privado para facilitar el encapsulamiento. Para acceder a su con-
    tenido emplearemos los métodos get y set.
    ********************************************************************************/
    private ArrayList<Serpiente> serpiente, serpienteIA;
    private Trofeo[] trofeos;
    private boolean[] trofeosComidos;
    private int direccion, ultimaDir, direccionAnterior, direccionIA, ultimaDirIA;
    private Color colorFondoVista, colorSerpiente, colorTrofeo;
    private int numFilasVista, numColumnasVista;
    private int velocidad;
    private int segundos, minutos, horas, contador;
    private String tiempo, puntos, valor;
    private Timer timer;

    /*************************** CONSTRUCTOR DE LA CLASE. **************************
    Recibe como argumento los resultados de las opciones gráficas. Si no se producen
    cambios, entonces el array estará vacío y se asigna el tamaño y los colores por
    defecto. Si tiene contenido, entonces el constructor se amolda al contenido.
    ********************************************************************************/
    public Modelo(String[] resultados, String valor){
        this.valor=valor;
        /* Serpiente. El ArrayList es la estructura de datos que almacena la posición
        donde se encuentra. */
        serpiente=new ArrayList<Serpiente>();
        // Como debemos mostrar la serpiente para empezar el juego, creamos una
        Serpiente serp=new Serpiente(5,5);
        serpiente.add(serp);
        // La serpiente se encontrará estática hasta que el usuario quiera empezar
        direccion=0;
        // Como se mantiene estática (direccion=0), la última dirección es 0 también
        ultimaDir=0;
        direccionAnterior=0;
        direccionIA=0;
        ultimaDirIA=0;
        // Inicializamos la velocidad a 90
        velocidad=90;
        // Inicializamos el lanzador del temporizador a 0 (para que no se inicie)
        contador=0;
        // Inicializamos el contador de tiempo a 00:00:00
        tiempo="00:00:00";
        // Los tiempos los inicializamos a 0 también
        segundos=0;
        minutos=0;
        horas=0;
        // Los puntos que ha conseguido el jugador se inicializan a 0
        puntos="0";
        // Si hay parámetros de entrada debido a la configuración, los aplicamos
        if (resultados.length!=1){
            introduceResultados(resultados);
        // Si no, entonces cargamos las propiedades por defecto
        } else {
        colorFondoVista=new java.awt.Color(204, 255, 204);
        colorSerpiente=new java.awt.Color(254, 46, 46);
        colorTrofeo=new java.awt.Color(46, 154, 254);
        trofeos=new Trofeo[1];
        trofeosComidos=new boolean[1];
        numFilasVista=40;
        numColumnasVista=40;
        }
        // Lanzamos el método que nos permite controlar los choques de la serpiente consigo misma
        //Chocar choque=new Chocar();
        //choque.start();
        switch (this.valor){
            case ("0"):
                break;
            case ("1"):
                serpienteIA=new ArrayList<Serpiente>();
                Serpiente serpIA=new Serpiente(15, 15);
                serpienteIA.add(serpIA);
                ControladorMaquina controladorMaquina=new ControladorMaquina(this);
                controladorMaquina.start();
                break;
            case ("2"):
                break;
        }
        // Lanza la generación de trofeos
        inicializaArray();
        // Lanzamos la clase que nos permite controlar las acciones que provocan el fin del juego
        Funcionamiento funcionamiento=new Funcionamiento();
        funcionamiento.start();
        // Lanzamos el método que nos permite añadir los trofeos al tablero de juego y engrandar la serpiente
        AñadePuntos puntos=new AñadePuntos();
        puntos.start();
    }

    /*************************** MÉTODOS GETTER Y SETTER. **************************
    Los métodos getter y setter permiten acceder a los elementos de la clase (métodos
    getter) y modificarlos (métodos setter).
    ********************************************************************************/
    public int getFilas(){
        return this.numFilasVista;
    }

    public int getCols(){
        return this.numColumnasVista;
    }

    public Color getColorSerpiente(){
        return this.colorSerpiente;
    }

    public int getDireccion(){
        return this.direccion;
    }

    public Color getColorFondo(){
        return colorFondoVista;
    }

    public Color getColorTrofeo(){
        return colorTrofeo;
    }

    public Trofeo[] getTrofeos(){
        return trofeos;
    }

    public int getPosicionX(){
        return trofeos[0].getColocacionX();
    }

    public int getPosicionY(){
        return trofeos[0].getColocacionY();
    }

    public ArrayList<Serpiente> getSerpiente(){
        return serpiente;
    }

    public ArrayList<Serpiente> getSerpienteIA(){
        return serpienteIA;
    }

    public String getValor(){
        return valor;
    }

    public int getDireccionIA(){
        return this.direccionIA;
    }

    public int getUltimaDirIA(){
        return this.ultimaDirIA;
    }

    public String getTiempo(){
        return tiempo;
    }

    public String getPuntos(){
        return puntos;
    }

    public int getUltimaDir(){
        return ultimaDir;
    }

    public int getDireccionAnterior(){
        return direccionAnterior;
    }

    public void setDirecciones(int direccion, int ultimaDir, int direccionAnterior){
        this.direccion=direccion;
        this.ultimaDir=ultimaDir;
        this.direccionAnterior=direccionAnterior;
        actualizaPosicion();
    }

    public void setDireccionesIA(int direccion, int ultimaDir){
        this.direccionIA=direccion;
        this.ultimaDirIA=ultimaDir;
    }

    public void setVelocidad(int velocidad){
       this.velocidad=velocidad;
    }

    /****************************** MÉTODOS DE CLASE. ******************************
    Agregan funcionalidades al objeto de la clase.
    ********************************************************************************/
    // Introduce los resultados de las opciones gráficas en los atributos de la clase
    private void introduceResultados(String[] resultados){
        switch(resultados[0]){
            case ("Azul verdoso"):
                colorFondoVista=new java.awt.Color(46, 254, 200);
                break;
            case ("Azul claro"):
                colorFondoVista=new java.awt.Color(129, 218, 245);
                break;
            case ("Verde"):
                colorFondoVista=Color.green;
                break;
            case ("Negro"):
                colorFondoVista=Color.black;
                break;
            case ("Blanco"):
                colorFondoVista=Color.white;
                break;
        }
        switch(resultados[1]){
            case ("Rojo"):
                colorSerpiente=Color.red;
                break;
            case ("Gris"):
                colorSerpiente=Color.gray;
                break;
            case ("Magenta"):
                colorSerpiente=Color.magenta;
                break;
            case ("Marrón"):
                colorSerpiente=new java.awt.Color(138, 41, 8);
                break;
            case ("Blanco"):
                colorSerpiente=new java.awt.Color(242, 242, 242);
                break;
        }
        switch(resultados[2]){
            case ("2"):
                trofeos=new Trofeo[2];
                trofeosComidos=new boolean[2];
                break;
            case ("3"):
                trofeos=new Trofeo[3];
                trofeosComidos=new boolean[3];
                break;
            case ("4"):
                trofeos=new Trofeo[4];
                trofeosComidos=new boolean[4];
                break;
            case ("5"):
                trofeos=new Trofeo[5];
                trofeosComidos=new boolean[5];
                break;
            case ("6"):
                trofeos=new Trofeo[6];
                trofeosComidos=new boolean[6];
                break;
        }
        switch(resultados[3]){
            case ("Naranja"):
                colorTrofeo=new java.awt.Color(255, 128, 0);
                break;
            case ("Verde oscuro"):
                colorTrofeo=new java.awt.Color(11, 59, 11);
                break;
            case ("Amarillo"):
                colorTrofeo=Color.yellow;
                break;
            case ("Gris"):
                colorTrofeo=Color.gray;
                break;
        }
        switch(resultados[4]){
            case ("20x20"):
                numFilasVista=20;
                numColumnasVista=20;
                break;
            case ("25x25"):
                numFilasVista=25;
                numColumnasVista=25;
                break;
            case ("30x30"):
                numFilasVista=30;
                numColumnasVista=30;
                break;
            case ("35x35"):
                numFilasVista=35;
                numColumnasVista=35;
                break;
            case ("40x40"):
                numFilasVista=40;
                numColumnasVista=40;
                break;
            case ("50x50"):
                numFilasVista=50;
                numColumnasVista=50;
                break;
            case ("60x60"):
                numFilasVista=60;
                numColumnasVista=60;
                break;
        }
    }

    // Inicializa el array de trofeos comidos a true (no hay ninguno disponible cuando se genera el modelo)
    private void inicializaArray(){
        for (int i=0; i<trofeosComidos.length; i++){
            trofeosComidos[i]=true;
            generaPosiciones(i);
        }
    }

    // Genera posiciones para aquellos trofeos que hayan sido comidos o que no se encuentren en el tablero
    private void generaPosiciones(int i){
        if (trofeosComidos[i]){
            trofeos[i]=new Trofeo();
            int a=(int) (Math.random()*((numFilasVista-2)-1)+1);
            int b=(int) (Math.random()*((numColumnasVista-2)-1)+1);
            // Añadimos esta primera condición porque si nada más inicializarlo se lanza este método, no se
            // ejecuta correctamente debido a que parte de los trofeos todavía apuntan a null
            if (i!=0)
                if (esPosicionRepetida(a))
                    a=(int) (Math.random()*((numFilasVista-2)-1)+1);
            do {
                trofeos[i].setColocacionX(a);
                trofeos[i].setColocacionY(b);
            }while(trofeoPisado(i));
            trofeosComidos[i]=false;
        }
    }

    // Impide que un trofeo se coloque en una posición donde se encuentra la serpiente
    private boolean trofeoPisado(int indice){
        for (int i=0; i<serpiente.size(); i++){
            if ((trofeos[indice].getColocacionX()==serpiente.get(i).getColocacionX())&&
                    (trofeos[indice].getColocacionY()==serpiente.get(i).getColocacionY()))
                return true;
        }
        return false;
    }

    // Impiden que los trofeos se posicionen uno sobre otro
    private boolean esPosicionRepetida(int valor){
        for (int i=0; i<trofeos.length; i++)
            if (trofeos[i]!=null)
                if(trofeos[i].getColocacionX()==valor)
                    return true;
        return false;
    }

    // Si el trofeo ha sido comido (la serpiente está sobre él) devuelve true
    private boolean esTrofeoComido(Trofeo trofeo){
        return ((trofeo.getColocacionX()==serpiente.get(serpiente.size()-1).getColocacionX())&&
                (trofeo.getColocacionY()==serpiente.get(serpiente.size()-1).getColocacionY()));
    }

    // Si el trofeo ha sido comido (la serpiente está sobre él) devuelve true
    private boolean esTrofeoComidoIA(Trofeo trofeo){
        return ((trofeo.getColocacionX()==serpienteIA.get(0).getColocacionX())&&
                (trofeo.getColocacionY()==serpienteIA.get(0).getColocacionY()));
    }

    // Permite notificar a los observadores sobre los cambios en el modelo
    public void notificaCambios() {
        this.setChanged();
        this.notifyObservers();
    }

    // Permite iniciar, detener o reanudar el contador
    private void activarContador(boolean valor){
        if (valor){
            timer = new Timer();
            timer.schedule(new Contador(), 0, 1000);
        } else
            timer.cancel();
    }

    public void actualizaPosicion(){
        Serpiente serp;
        switch (direccion){
            case (1):
                serp=new Serpiente(serpiente.get(serpiente.size()-1).getColocacionX()-1, serpiente.get(serpiente.size()-1).getColocacionY());
                serpiente.add(serp);
                ultimaDir=1;
                break;
            case (2):
                serp=new Serpiente(serpiente.get(serpiente.size()-1).getColocacionX()+1, serpiente.get(serpiente.size()-1).getColocacionY());
                serpiente.add(serp);
                ultimaDir=2;
                break;
            case (3):
                serp=new Serpiente(serpiente.get(serpiente.size()-1).getColocacionX(), serpiente.get(serpiente.size()-1).getColocacionY()-1);
                serpiente.add(serp);
                ultimaDir=3;
                break;
            case (4):
                serp=new Serpiente(serpiente.get(serpiente.size()-1).getColocacionX(), serpiente.get(serpiente.size()-1).getColocacionY()+1);
                serpiente.add(serp);
                ultimaDir=4;
                break;
        }
        // Si la dirección es distinta de 0 (se ha iniciado el juego), entonces podemos permitir que funcione el temporizador
        if (direccion!=0){
            contador++;
            serpiente.remove(0);
            // Si nuestro contador ya ha sido lanzado (porque se incrementa en cada iteración), entonces no lo volvemos a lanzar
            if (contador==1){
                // Entonces ponemos en marcha el temporizador
                activarContador(true);
            }
        } else if ((direccion==0)&&(contador!=0)){ // Si se ha detenido el movimiento
            // Reiniciamos el contador
            contador=0;
            // Detenemos el temporizador
            activarContador(false);
        }
        if (this.valor=="1"){
            Serpiente serpIA;
            switch (direccionIA){
                case (1):
                    serpIA=new Serpiente(serpienteIA.get(serpienteIA.size()-1).getColocacionX()-1, serpienteIA.get(serpienteIA.size()-1).getColocacionY());
                    serpienteIA.add(serpIA);
                    ultimaDirIA=1;
                    break;
                case (2):
                    serpIA=new Serpiente(serpienteIA.get(serpienteIA.size()-1).getColocacionX()+1, serpienteIA.get(serpienteIA.size()-1).getColocacionY());
                    serpienteIA.add(serpIA);
                    ultimaDirIA=2;
                    break;
                case (3):
                    serpIA=new Serpiente(serpienteIA.get(serpienteIA.size()-1).getColocacionX(), serpienteIA.get(serpienteIA.size()-1).getColocacionY()-1);
                    serpienteIA.add(serpIA);
                    ultimaDirIA=3;
                    break;
                case (4):
                    serpIA=new Serpiente(serpienteIA.get(serpienteIA.size()-1).getColocacionX(), serpienteIA.get(serpienteIA.size()-1).getColocacionY()+1);
                    serpienteIA.add(serpIA);
                    ultimaDirIA=4;
                    break;
            }
            if (direccionIA!=0){
                serpienteIA.remove(0);
            }
        }
        if (chocar()){
            System.out.println("Te has chocado contigo mismo");
            serpiente.remove(serpiente.size()-1);
        }
    }

    // Detecta si la serpiente se choca consigo misma
    private boolean chocar(){
        for(int i=0;i<serpiente.size()-1;i++){
            if((serpiente.get(serpiente.size()-1).getColocacionX()==serpiente.get(i).getColocacionX())&&(serpiente.get(serpiente.size()-1).getColocacionY()==serpiente.get(i).getColocacionY())) return true;
        }
        return false;
    }

    /**************** CLASES QUE CONTROLAN MOVIMIENTOS NO DESEADOS. ****************
    Permiten controlar el correcto movimiento de la serpiente y se encuentran dentro
    del modelo, debido a que el Thread es el que permite el movimiento y posterior
    modificación del modelo observado.
    ********************************************************************************/
    class Funcionamiento extends Thread{
        @Override
        public void run(){
            while (true){
                try{
                    Thread.sleep(velocidad);
                    actualizaPosicion();
                    notificaCambios();
                }catch (Exception ex){
                    System.out.println("Te saliste de los límites.");
                    System.exit(1);
                }
            }
        }
    }

    /******* CLASE QUE CONTROLA LOS TROFEOS Y LOS PUNTOS ASOCIADOS A ELLOS. ********
    Controla que siempre haya trofeos sobre el tablero y, cuando éstos son comidos,
    reparte los puntos necesarios.
    ********************************************************************************/
    class AñadePuntos extends Thread{
        @Override
        public void run(){
            while (true){
                try{
                    int pos=-1;
                    for (int i=0; i<trofeos.length; i++){
                        if (esTrofeoComido(trofeos[i])||esTrofeoComidoIA(trofeos[i])){
                            pos=i;
                            break;
                        }
                    }
                    if (pos!=-1){
                        if (esTrofeoComido(trofeos[pos])){
                            Serpiente serp;
                            switch (direccion){
                                case (1):
                                    serp=new Serpiente(serpiente.get(serpiente.size()-1).getColocacionX()-1, serpiente.get(serpiente.size()-1).getColocacionY());
                                    serpiente.add(serp);
                                    break;
                                case (2):
                                    serp=new Serpiente(serpiente.get(serpiente.size()-1).getColocacionX()+1, serpiente.get(serpiente.size()-1).getColocacionY());
                                    serpiente.add(serp);
                                    break;
                                case (3):
                                    serp=new Serpiente(serpiente.get(serpiente.size()-1).getColocacionX(), serpiente.get(serpiente.size()-1).getColocacionY()-1);
                                    serpiente.add(serp);
                                    break;
                                case (4):
                                    serp=new Serpiente(serpiente.get(serpiente.size()-1).getColocacionX(), serpiente.get(serpiente.size()-1).getColocacionY()+1);
                                    serpiente.add(serp);
                                    break;
                            }
                            puntos=(Integer.toString((serpiente.size()-1)*10));
                            trofeosComidos[pos]=true;
                            generaPosiciones(pos);
                        } else if ((esTrofeoComidoIA(trofeos[pos]))&&(valor=="1")){
                            Serpiente serp;
                            switch (direccionIA){
                                case (1):
                                    serp=new Serpiente(serpienteIA.get(serpienteIA.size()-1).getColocacionX()-1, serpienteIA.get(serpienteIA.size()-1).getColocacionY());
                                    serpienteIA.add(serp);
                                    break;
                                case (2):
                                    serp=new Serpiente(serpienteIA.get(serpienteIA.size()-1).getColocacionX()+1, serpienteIA.get(serpienteIA.size()-1).getColocacionY());
                                    serpienteIA.add(serp);
                                    break;
                                case (3):
                                    serp=new Serpiente(serpienteIA.get(serpienteIA.size()-1).getColocacionX(), serpienteIA.get(serpienteIA.size()-1).getColocacionY()-1);
                                    serpienteIA.add(serp);
                                    break;
                                case (4):
                                    serp=new Serpiente(serpienteIA.get(serpienteIA.size()-1).getColocacionX(), serpienteIA.get(serpienteIA.size()-1).getColocacionY()+1);
                                    serpienteIA.add(serp);
                                    break;
                            }
                            puntos=(Integer.toString((serpienteIA.size()-1)*10));
                            trofeosComidos[pos]=true;
                            generaPosiciones(pos);
                        }
                    }
                    Thread.sleep(velocidad*2);
                }catch (Exception ex){}
            }
        }
    }

    /******************** CLASE QUE CONTROLA EL TIEMPO DE JUEGO. *******************
    Esta clase permite llevar el tiempo correctamente, heredando de TimerTask.
    ********************************************************************************/
    class Contador extends TimerTask{
        public void run() {
            segundos++;
            if (segundos==60){
                minutos++;
                segundos=0;
            }
            if (minutos==60){
                horas++;
                minutos=0;
            }
            // Cambios estéticos, para que los números aparezcan con dos cifras.
            String segundo=Integer.toString(segundos);
            if (segundo.length()==1) segundo="0"+Integer.toString(segundos);
            String minuto=Integer.toString(minutos);
            if (minuto.length()==1) minuto="0"+Integer.toString(minutos);
            String hora=Integer.toString(horas);
            if (hora.length()==1) hora="0"+Integer.toString(horas);
            tiempo=(hora+":"+minuto+":"+segundo);
        }
    }
}
