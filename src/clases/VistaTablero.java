/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

/******************************* PAQUETES IMPORTADOS *******************************/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**************************** CLASE DEL OBJETO "VISTA 2". **************************
Esta clase es el modelo que observa a modelo. Como tal, implementa el patrón Observer
y su método update.
************************************************************************************/
public class VistaTablero extends javax.swing.JFrame implements Observer {

    /***************************** ATRIBUTOS DE CLASE. *****************************
    Tienen acceso privado para facilitar el encapsulamiento. Para acceder a su con-
    tenido emplearemos los métodos get y set (si es necesario).
    ********************************************************************************/
    private Modelo modelo;
    private JPanel[][] paneles;
    private Color colorSerpiente, colorFondo, colorTrofeo;
    private ArrayList<Serpiente> serpiente, serpienteIA;
    private Trofeo[] trofeos;

    /*************************** CONSTRUCTOR DE LA CLASE. **************************
    Recibe como argumento el modelo para inicializarlo con algunos parámetros nece-
    sarios.
    ********************************************************************************/
    public VistaTablero(Modelo modelo) {
        initComponents();
        this.modelo=modelo;
        tablero.setLayout(new GridLayout(modelo.getFilas(), modelo.getCols()));
        tablero.setBackground(new java.awt.Color(240, 240, 240));
        paneles=new JPanel[modelo.getFilas()][modelo.getCols()];
        for (int i=0; i<modelo.getFilas(); i++)
            for (int j=0; j<modelo.getCols(); j++){
                JPanel pixel=new JPanel();
                pixel.setBackground(modelo.getColorFondo());
                tablero.add(pixel);
                paneles[i][j]=pixel;
            }
        Dimension d=new Dimension(modelo.getFilas()*15, modelo.getCols()*15);
        this.setSize(d);
    }

    /*************************** MÉTODOS GETTER Y SETTER. **************************
    Los métodos getter y setter permiten acceder a los elementos de la clase (métodos
    getter) y modificarlos (métodos setter).
    ********************************************************************************/
    public Modelo getModelo(){
        return modelo;
    }

    private void setSerpiente(ArrayList<Serpiente> serpiente){
        this.serpiente=serpiente;
    }

    private void setSerpienteIA(ArrayList<Serpiente> serpienteIA){
        this.serpienteIA=serpienteIA;
    }

    private void setTrofeos(Trofeo[] trofeos){
        this.trofeos=new Trofeo[trofeos.length];
        for (int i=0; i<trofeos.length; i++){
            this.trofeos[i]=new Trofeo();
            this.trofeos[i].setColocacionX(trofeos[i].getColocacionX());
            this.trofeos[i].setColocacionY(trofeos[i].getColocacionY());
        }
    }
    /****************************** MÉTODOS DE CLASE. ******************************
    Agregan funcionalidades al objeto de la clase.
    ********************************************************************************/
    // Restablece el tablero con el tamaño original
    private void restablecerTablero(){
        for (int i=0; i<modelo.getFilas(); i++)
            for (int j=0; j<modelo.getCols(); j++){
                paneles[i][j].setBackground(colorFondo);
            }
    }

    // Incluye un mensaje en la vista
    public void setOptionPanel(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
        System.exit(1);
    }

    // Dibuja la vista
    private void dibujarElementos(String valor){
        this.restablecerTablero();
        for (int i=0; i<serpiente.size(); i++)
            paneles[serpiente.get(i).getColocacionX()][serpiente.get(i).getColocacionY()].setBackground(colorSerpiente);
        for (int i=0; i<trofeos.length; i++)
            paneles[trofeos[i].getColocacionX()][trofeos[i].getColocacionY()].setBackground(colorTrofeo);
        if (valor=="1"){
            for (int i=0; i<serpienteIA.size(); i++)
                paneles[serpienteIA.get(i).getColocacionX()][serpienteIA.get(i).getColocacionY()].setBackground(Color.cyan);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Modelo modelo=(Modelo) o;
        this.modelo=modelo;
        setSerpiente(modelo.getSerpiente());
        setTrofeos(modelo.getTrofeos());
        if (modelo.getMensaje()=="Choque")
                setOptionPanel("Te has chocado contigo mismo.");
        else if (modelo.getMensaje()=="Choque con IA")
                setOptionPanel("Te has chocado con la serpiente automática.");
        colorSerpiente=modelo.getColorSerpiente();
        colorFondo=modelo.getColorFondo();
        colorTrofeo=modelo.getColorTrofeo();
        switch (modelo.getValor()){
            case ("1"):
                setSerpienteIA(modelo.getSerpienteIA());
                break;
        }
        dibujarElementos(modelo.getValor());
    }

    // Código generado automáticamente por el IDE empleado: NetBeans
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tablero.setBackground(new java.awt.Color(255, 255, 255));
        tablero.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
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

}
