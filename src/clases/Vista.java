
package clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class Vista extends javax.swing.JFrame implements Observer {

    private JPanel[][] paneles;
    private Color colorSerpiente;
    private ArrayList<Serpiente> serpiente;

    public Vista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
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

    public void setPaneles(int numFilas, int numColumnas, Color colorPanel){
        paneles=new JPanel[numFilas][numColumnas];
        for(int i=0; i<numFilas; i++)
            for(int j=0; j<numColumnas; j++){
                JPanel panel=new JPanel();
                panel.setBackground(colorPanel);
                panel.setPreferredSize(new Dimension(tablero.getWidth()/numColumnas,tablero.getHeight()/numFilas));
                tablero.add(panel);
                paneles[i][j]=panel;
            }
        for (int i=0; i<serpiente.size(); i++)
            paneles[serpiente.get(i).colocacionX][serpiente.get(i).colocacionY].setBackground(colorSerpiente);
    }

    public void setSerpiente(ArrayList<Serpiente> serp){
        serpiente=(ArrayList<Serpiente>) serp.clone();
    }

    @Override
    public void update(Observable o, Object arg) {
        Modelo modelo = (Modelo) o;
        tablero.setLayout(new GridLayout(modelo.getFilas(), modelo.getCols()));
        tablero.setBackground(modelo.getColorFondo());
        colorSerpiente=modelo.getColorSerpiente();
        this.setSerpiente(modelo.getSerpiente());
        this.setPaneles(modelo.getFilas(), modelo.getCols(), modelo.getColorFondo());
    }
}
