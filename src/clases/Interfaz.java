/*----------------------------------------
Práctica de Metodología de la Programación
Hecha por: Carlos Vázquez Losada
----------------------------------------*/
package clases;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interfaz extends javax.swing.JFrame implements KeyListener{

    // Tamaño del tablero de juego
    final int numFilas=30;
    final int numColumnas=30;
    // Panel de los trofeos que se colocan en posiciones aleatorias
    JPanel trofeo=new JPanel();
    JPanel trofeo1=new JPanel();
    JPanel[][] arraypanel=new JPanel[numFilas][numColumnas];
    // Como el snake debe lanzarse con la serpiente estática, entonces dirección vale 0
    int direccion=0;
    // Como dirección vale 0, entonces la última dirección la inicializamos a 0
    int ultimadir=0;
    // Permite la reanudación de la partida volviendo a pulsar P después de haberla detenido
    int direccionAnterior=0;
    /* Como al inicializar el tablero no hay trofeos, entonces inicializamos la posición a false.
    Inicializando la posición a false, en la primera llamada a run(), se generará automáticamente
    el panel trofeo, y el valor de esta variable se vuelve a true. Cuando la serpiente se coma el
    nuevo trofeo, volverá a false, se seguirá ejecutando run() y, como está en false, se volverá
    a producir un nuevo panel aleatorio. */
    boolean posicionTrofeo=false;
    boolean posicionTrofeo1=false;
    int i=0;
    Puntuacion panelPuntuacion;
    // Velocidad inicial. Podrá ser modificada con las teclas "+" y "-" del teclado numérico
    int vel=90;
    private ArrayList<Serpiente> arraySerpiente=new ArrayList<Serpiente>();
    // Posición de los dos trofeos
    int posX=0, posY=0, posX1=0, posY1=0;
    Color colorFondo=new java.awt.Color(204, 255, 204);
    Color colorSerpiente=new java.awt.Color(254, 46, 46);
    Color colorTrofeo1=new java.awt.Color(46, 154, 254);
    Color colorTrofeo2=Color.blue;

    public Interfaz(String[] resultados) {
        if (resultados.length!=1)
            setResultados(resultados);
        else{
            colorFondo=new java.awt.Color(204, 255, 204);
            colorSerpiente=new java.awt.Color(254, 46, 46);
            colorTrofeo1=new java.awt.Color(46, 154, 254);
            colorTrofeo2=Color.blue;
        }
        initComponents();
        addKeyListener(this);
        // Creamos el tablero
        tablero.setLayout(new GridLayout(numFilas,numColumnas));
        tablero.setBackground(colorFondo);
        panelPuntuacion=new Puntuacion();
        panelPuntuacion.setVisible(true);
        panelPuntuacion.setBounds(460, 30, 170, 270);
        // Con este for le damos sus propiedades estéticas
        for(int i=0; i<numFilas; i++){
            for(int j=0; j<numColumnas; j++){
                JPanel panel=new JPanel();
                panel.setBackground(colorFondo);
                panel.setBorder(javax.swing.BorderFactory.createLineBorder(colorFondo));
                panel.setPreferredSize( new Dimension(tablero.getWidth()/numColumnas,tablero.getHeight()/numFilas));
                tablero.add(panel);
                arraypanel[i][j]=panel;
            }
        }
        // Creamos la serpiente y la posicionamos en la parte superior izquierda
        Serpiente serp=new Serpiente(arraypanel[5][5],5,5);
        /* Añadimos el primer "bloque" de la serpiente al lanzar el tablero. Este ArrayList de Serpiente se irá incrementando
        a medida que consumamos premios */
        arraySerpiente.add(serp);
        arraySerpiente.get(0).panelC.setBackground(colorSerpiente);
        // Controlamos si la serpiente se sale de los límites del tablero
        ActualizaTablero actualiza=new ActualizaTablero();
        actualiza.start();
        // Controlamos el choque de la serpiente consigo misma
        Chocar choque=new Chocar();
        choque.start();
        // Lanzamos añadir puntos, que ampliará el tamaño de la serpiente cada vez que se "coma" un punto verde
        AñadePuntos ap=new AñadePuntos();
        ap.start();
    }

    // Aquí se produce el movimiento del snake
    @Override
    public void keyTyped(KeyEvent e){ }

    @Override
    public void keyReleased(KeyEvent e){ }

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            // Pulsamos hacia arriba
            case (KeyEvent.VK_UP):
                // Si pulsamos hacia arriba, no podemos pulsar hacia abajo, debemos girar antes
                if (ultimadir!=2)
                    direccion=1;
                break;
            // Pulsamos hacia abajo
            case (KeyEvent.VK_DOWN):
                // Si pulsamos hacia abajo, no podemos pulsar hacia arriba, debemos girar antes
                if (ultimadir!=1)
                    direccion=2;
                break;
            // Pulsamos hacia la izquierda
            case (KeyEvent.VK_LEFT):
                // Si pulsamos hacia la izquierda, debemos ir hacia arriba o hacia abajo antes de girar hacia la derecha
                if (ultimadir!=4)
                    direccion=3;
                break;
            // Pulsamos hacia la derecha
            case (KeyEvent.VK_RIGHT):
                // Si pulsamos hacia la derecha, debemos ir hacia arriba o hacia abajo antes de girar hacia la izquierda
                if (ultimadir!=3)
                    direccion=4;
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
                break;
            // Pulsamos la tecla + (del teclado numérico)
            case (KeyEvent.VK_ADD):
                // La velocidad incrementa en 10 unidades (drecementa el número de píxeles necesarios para recorrer una unidad)
                vel-=10;
                break;
            // Pulsamos la tecla + (del teclado numérico)
            case (KeyEvent.VK_SUBTRACT):
                // La velocidad decrementa en 10 unidades (incrementa el número de píxeles necesarios para recorrer una unidad)
                vel+=10;
                break;
        }
    }

    private void setResultados(String[] resultados){
        switch(resultados[0]){
            case ("Azul verdoso"):
                colorFondo=new java.awt.Color(46, 254, 200);
                break;
            case ("Azul claro"):
                colorFondo=new java.awt.Color(129, 218, 245);
                break;
            case ("Verde"):
                colorFondo=Color.green;
                break;
            case ("Negro"):
                colorFondo=Color.black;
                break;
            case ("Blanco"):
                colorFondo=Color.white;
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
            case ("Naranja"):
                colorTrofeo1=new java.awt.Color(255, 128, 0);
                break;
            case ("Verde oscuro"):
                colorTrofeo1=new java.awt.Color(11, 59, 11);
                break;
            case ("Amarillo"):
                colorTrofeo1=Color.yellow;
                break;
            case ("Gris"):
                colorTrofeo1=Color.gray;
        }
        switch(resultados[3]){
            case ("Naranja"):
                colorTrofeo2=new java.awt.Color(255, 128, 0);
                break;
            case ("Verde oscuro"):
                colorTrofeo2=new java.awt.Color(11, 59, 11);
                break;
            case ("Amarillo"):
                colorTrofeo2=Color.yellow;
                break;
            case ("Gris"):
                colorTrofeo2=Color.gray;
        }
    }

    /* Si se coloca un trofeo donde se encuentra la serpiente, el programa finaliza porque detecta que la serpiente se choca
    consigo misma. Este método arregla eso. Nunca se colocará un trofeo en aquellos paneles donde se encuentre la serpiente */
    // Trofeo 1
    public boolean pisado(){
        for(int i=0; i<arraySerpiente.size(); i++){
            if(trofeo==arraySerpiente.get(i).panelC) return true;
        }
        return false;
    }

    // Trofeo 2
    public boolean pisado1(){
        for(int i=0; i<arraySerpiente.size(); i++){
            if (trofeo1==arraySerpiente.get(i).panelC) return true;
        }
        return false;
    }

    // Método que indica si la serpiente se ha comido uno de los dos trofeos. Devuelve true si lo ha hecho y false en caso contrario
    // Trofeo 1
    public boolean esTrofeoComido(){
        // Si la serpiente se come el trofeo, entonces el panel de la cabeza de la serpiente coincide con el panel del trofeo
        if(arraySerpiente.get(arraySerpiente.size()-1).panelC==trofeo)return true;
        else return false;
    }

    // Trofeo 2
    public boolean esTrofeo1Comido(){
        if(arraySerpiente.get(arraySerpiente.size()-1).panelC==trofeo1)return true;
        else return false;
    }

    // Método que permite desplazar a la serpiente por el frame
    public void actualizaPosicion(){
        Serpiente serp;
        switch (direccion){
            case (1):
                serp=new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC-1][arraySerpiente.get(arraySerpiente.size()-1).anchoC],arraySerpiente.get(arraySerpiente.size()-1).altoC-1,arraySerpiente.get(arraySerpiente.size()-1).anchoC);
                serp.panelC.setBackground(colorSerpiente);
                arraySerpiente.add(serp);
                ultimadir=1;
                break;
            case (2):
                serp=new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC+1][arraySerpiente.get(arraySerpiente.size()-1).anchoC],arraySerpiente.get(arraySerpiente.size()-1).altoC+1,arraySerpiente.get(arraySerpiente.size()-1).anchoC);
                serp.panelC.setBackground(colorSerpiente);
                arraySerpiente.add(serp);
                ultimadir=2;
                break;
            case (3):
                serp=new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC][arraySerpiente.get(arraySerpiente.size()-1).anchoC-1],arraySerpiente.get(arraySerpiente.size()-1).altoC,arraySerpiente.get(arraySerpiente.size()-1).anchoC-1);
                serp.panelC.setBackground(colorSerpiente);
                arraySerpiente.add(serp);
                ultimadir=3;
                break;
            case (4):
                serp=new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC][arraySerpiente.get(arraySerpiente.size()-1).anchoC+1],arraySerpiente.get(arraySerpiente.size()-1).altoC,arraySerpiente.get(arraySerpiente.size()-1).anchoC+1);
                serp.panelC.setBackground(colorSerpiente);
                arraySerpiente.add(serp);
                ultimadir=4;
                break;
        }
        // Eliminamos el panel de su posición anterior, porque hemos creado el panel en la nueva posición, luego ha habido movimiento
        if(direccion!=0){
            arraySerpiente.get(0).panelC.setBackground(colorFondo);
            arraySerpiente.remove(0);
            i++;
            if (i==1)
                panelPuntuacion.activarContador(true);
        } else{
            i=0;
            panelPuntuacion.activarContador(false);
        }
    }

    // Detecta el choque de la serpiente consigo misma
    public boolean chocar(){
        for(int i=0; i<arraySerpiente.size()-1; i++){
            if(arraySerpiente.get(arraySerpiente.size()-1).panelC==arraySerpiente.get(i).panelC) return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));
        setBounds(new java.awt.Rectangle(0, 0, 450, 500));

        tablero.setBackground(new java.awt.Color(255, 255, 255));
        tablero.setForeground(new java.awt.Color(255, 255, 255));
        tablero.setPreferredSize(new java.awt.Dimension(450, 450));

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables

    /* ----- CLASES QUE CONTROLAN CHOQUES ----- */

    // Controla el choque de la serpiente con los límites del tablero
    class ActualizaTablero extends Thread{

        @Override
        public void run(){
            // Mientras no se choque con los límites, sigue funcionando
            while (true){
                try {
                    // Suspende el subproceso durante la velocidad indicada
                    Thread.sleep(vel);
                    // Llamamos a actualizar la posición de la serpiente
                    actualizaPosicion();
                } catch (Exception ex) {
                    // Si no suspendemos el subproceso, entonces nos hemos chocado (la velocidad es 0), luego el programa termina
                    JOptionPane.showMessageDialog(null, "¡Te has salido de los límites del tablero!\n\nHas conseguido "+(arraySerpiente.size()-1)*10+" puntos");
                    System.exit(1);
                }
            }
        }

    }

    // Controla el choque de la serpiente consigo misma
    class Chocar extends Thread{

        @Override
        public void run(){
            while (true){
                try{
                    if(chocar()){
                        direccion = 0;
                        JOptionPane.showMessageDialog(null, "¡Te has chocado contigo mismo!\n\nHas conseguido "+(arraySerpiente.size()-1)*10+" puntos");
                        System.exit(1);
                    }
                    // Suspende el subproceso
                    Thread.sleep(2);
                }
                catch(Exception e){}
            }
        }

    }

    /* ----- CLASES SERPIENTE Y ACTUALIZACIÓN DE LA SERPIENTE ----- */

    // Clase serpiente
    class Serpiente{

        public JPanel panelC;
        public int altoC,anchoC;

        // Constructor de la clase serpiente. Se coloca en el panel indicado
        public Serpiente(JPanel p,int numFilas,int numColumnas){
            panelC=p;
            altoC=numFilas;
            anchoC=numColumnas;
        }

    }

    // Esta clase es la encargada de añadir puntos a la serpiente (aumenta su longitud)
    class AñadePuntos extends Thread{

        @Override
        public void run(){
            while (true){
                try{
                    // Si no se ha colocado todavía un trofeo, los colocamos
                    if((posicionTrofeo==false)||(posicionTrofeo1==false)){
                        /* Comprobación primera. Cuando se genera por primera vez la celda de los dos
                        trofeos, evitamos que esta celda sea la misma.*/
                        if (posX==0){
                            // Generamos las coordenadas aleatorias de su primera colocación
                            posX=(int) (Math.random()*numFilas+1);
                            posX1=(int) (Math.random()*numFilas+1);
                            posY=(int) (Math.random()*numFilas+1);
                            posY1=(int) (Math.random()*numFilas+1);
                            // Si alguna coordenada del trofeo 1 coincide con la del 2, se genera otra
                            if ((posX==posX1)||(posY==posY1))
                                posX1=(int) (Math.random()*numFilas+1);
                        }
                        // Tratamos el caso de que al serpiente se coma al trofeo 1
                        if (posicionTrofeo==false){
                            // Generamos las coordenadas aleatorias de su posicionamiento
                            posX=(int) (Math.random()*numFilas+1);
                            posY=(int) (Math.random()*numFilas+1);
                            // Nuevamente aplicamos la comprobación de que son diferentes a las del trofeo 2
                            if ((posX==posX1)||(posY==posY1))
                                posX=(int) (Math.random()*numFilas+1);
                            do
                                trofeo=arraypanel[posX][posY];
                            while(pisado());
                            trofeo.setBackground(colorTrofeo1);
                            // Como ahora lo hemos colocado, ya existe posición
                            posicionTrofeo=true;
                        // Tratamos el caso de que al serpiente se coma al trofeo 2
                        } else {
                            posX1=(int) (Math.random()*numFilas+1);
                            posY1=(int) (Math.random()*numFilas+1);
                            // Aplicamos la comprobación de que las coordenadas diferen del trofeo 1
                            if ((posX1==posX)||(posY1==posY))
                                posX1=(int) (Math.random()*numFilas+1);
                            do
                                trofeo1=arraypanel[posX1][posY1];
                            while(pisado1());
                            trofeo1.setBackground(colorTrofeo2);
                            // Como ahora lo hemos colocado, ya existe posición
                            posicionTrofeo1=true;
                        }
                    }
                    // Si se ha comido el trofeo, entonces debemos incrementar el tamaño de la serpiente
                    if(esTrofeoComido()){
                        Serpiente serp;
                        /* Dependiendo de hacia qué dirección esté moviéndose, el nuevo panel será añadido:
                        - Si se mueve hacia abajo, arriba.
                        - Si se mueve hacia arriba, abajo.
                        - Si se mueve hacia la derecha, a la izquierda.
                        - Si se mueve hacia la izquierda, a la derecha.
                        Se añadirá detrás de todos los paneles, si hay más de uno. */
                        switch(direccion){
                            // Se mueve hacia arriba
                            case (1):
                                serp = new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC-1][arraySerpiente.get(arraySerpiente.size()-1).anchoC],arraySerpiente.get(arraySerpiente.size()-1).altoC-1,arraySerpiente.get(arraySerpiente.size()-1).anchoC);
                                serp.panelC.setBackground(colorSerpiente);
                                arraySerpiente.add(serp);
                                break;
                            // Se mueve hacia abajo
                            case (2):
                                serp = new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC+1][arraySerpiente.get(arraySerpiente.size()-1).anchoC],arraySerpiente.get(arraySerpiente.size()-1).altoC+1,arraySerpiente.get(arraySerpiente.size()-1).anchoC);
                                serp.panelC.setBackground(colorSerpiente);
                                arraySerpiente.add(serp);
                                break;
                            // Se mueve hacia la izquierda
                            case (3):
                                serp = new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC][arraySerpiente.get(arraySerpiente.size()-1).anchoC-1],arraySerpiente.get(arraySerpiente.size()-1).altoC,arraySerpiente.get(arraySerpiente.size()-1).anchoC-1);
                                serp.panelC.setBackground(colorSerpiente);
                                arraySerpiente.add(serp);
                                break;
                            // Se mueve hacia la derecha
                            case (4):
                                serp = new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC][arraySerpiente.get(arraySerpiente.size()-1).anchoC+1],arraySerpiente.get(arraySerpiente.size()-1).altoC,arraySerpiente.get(arraySerpiente.size()-1).anchoC+1);
                                serp.panelC.setBackground(colorSerpiente);
                                arraySerpiente.add(serp);
                                break;
                        }
                        // Si se ha comido el trofeo 1, entonces actualizamos la puntuación.
                        panelPuntuacion.actualizarPuntos(Integer.toString((arraySerpiente.size()-1)*10));
                        posicionTrofeo=false;
                    }
                    if(esTrofeo1Comido()){
                        Serpiente serp;
                        switch(direccion){
                            // Se mueve hacia arriba
                            case (1):
                                serp = new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC-1][arraySerpiente.get(arraySerpiente.size()-1).anchoC],arraySerpiente.get(arraySerpiente.size()-1).altoC-1,arraySerpiente.get(arraySerpiente.size()-1).anchoC);
                                serp.panelC.setBackground(colorSerpiente);
                                arraySerpiente.add(serp);
                                break;
                            // Se mueve hacia abajo
                            case (2):
                                serp = new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC+1][arraySerpiente.get(arraySerpiente.size()-1).anchoC],arraySerpiente.get(arraySerpiente.size()-1).altoC+1,arraySerpiente.get(arraySerpiente.size()-1).anchoC);
                                serp.panelC.setBackground(colorSerpiente);
                                arraySerpiente.add(serp);
                                break;
                            // Se mueve hacia la izquierda
                            case (3):
                                serp = new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC][arraySerpiente.get(arraySerpiente.size()-1).anchoC-1],arraySerpiente.get(arraySerpiente.size()-1).altoC,arraySerpiente.get(arraySerpiente.size()-1).anchoC-1);
                                serp.panelC.setBackground(colorSerpiente);
                                arraySerpiente.add(serp);
                                break;
                            // Se mueve hacia la derecha
                            case (4):
                                serp = new Serpiente(arraypanel[arraySerpiente.get(arraySerpiente.size()-1).altoC][arraySerpiente.get(arraySerpiente.size()-1).anchoC+1],arraySerpiente.get(arraySerpiente.size()-1).altoC,arraySerpiente.get(arraySerpiente.size()-1).anchoC+1);
                                serp.panelC.setBackground(colorSerpiente);
                                arraySerpiente.add(serp);
                                break;
                        }
                        // Si se ha comido el trofeo 2, entonces actualizamos la puntuación.
                        panelPuntuacion.actualizarPuntos(Integer.toString((arraySerpiente.size()-1)*10));
                        posicionTrofeo1=false;
                    }
                    Thread.sleep(0);
                }
                catch (Exception ex) {}
            }
        }

    }

}
