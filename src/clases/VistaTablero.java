/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VistaTablero extends javax.swing.JFrame implements Observer {

    private Modelo modelo;
    private JPanel[][] paneles;
    private Color colorSerpiente, colorFondo, colorTrofeo;
    private ArrayList<Serpiente> serpiente, serpienteIA;
    private Trofeo[] trofeos;

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

    private void restablecerTablero(){
        for (int i=0; i<modelo.getFilas(); i++)
            for (int j=0; j<modelo.getCols(); j++){
                paneles[i][j].setBackground(colorFondo);
            }
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

    // Controla el choque de la serpiente consigo misma una vez ésta ha sido dibujada
    private boolean chocar(){
        for(int i=0; i<serpiente.size()-1; i++){
            if (paneles[serpiente.get(serpiente.size()-1).getColocacionX()][serpiente.get(serpiente.size()-1).getColocacionY()]
                    ==paneles[serpiente.get(i).getColocacionX()][serpiente.get(i).getColocacionY()]) return true;
        }
        return false;
    }

    // Controla el choque de la serpiente controlada por el usuario con la IA
    private boolean chocarPlayerEnIA(){
        for (int i=0; i<serpienteIA.size(); i++){
            if (paneles[serpiente.get(0).getColocacionX()][serpiente.get(0).getColocacionY()]
                    ==paneles[serpienteIA.get(i).getColocacionX()][serpienteIA.get(i).getColocacionY()])
                return true;
        }
        return false;
    }

    private void dibujarElementos(String valor){
        this.restablecerTablero();
        for (int i=0; i<serpiente.size(); i++)
            paneles[serpiente.get(i).getColocacionX()][serpiente.get(i).getColocacionY()].setBackground(colorSerpiente);
        for (int i=0; i<trofeos.length; i++)
            paneles[trofeos[i].getColocacionX()][trofeos[i].getColocacionY()].setBackground(colorTrofeo);
        if (valor=="1"){
            for (int i=0; i<serpienteIA.size(); i++)
                paneles[serpienteIA.get(i).getColocacionX()][serpienteIA.get(i).getColocacionY()].setBackground(Color.cyan);
            if (chocarPlayerEnIA()){
                JOptionPane.showMessageDialog(null, "Te has chocado con la serpiente.\n\nPuntuación:  "+(serpiente.size()-1)*10);
                System.exit(1);
            }
        }
        if (chocar()){
            JOptionPane.showMessageDialog(null, "Te has chocado contigo mismo.\n\nPuntuación:  "+(serpiente.size()-1)*10);
            System.exit(1);
        }
    }

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



    @Override
    public void update(Observable o, Object arg) {
        Modelo modelo=(Modelo) o;
        colorSerpiente=modelo.getColorSerpiente();
        colorFondo=modelo.getColorFondo();
        colorTrofeo=modelo.getColorTrofeo();
        setSerpiente(modelo.getSerpiente());
        setTrofeos(modelo.getTrofeos());
        switch (modelo.getValor()){
            case ("1"):
                setSerpienteIA(modelo.getSerpienteIA());
                break;
        }
        dibujarElementos(modelo.getValor());
    }
}
