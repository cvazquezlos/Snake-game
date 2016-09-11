package servidor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * Representa el socket del servidor.
 *
 * @author c.vazquezlos
 */
public class ServerView extends javax.swing.JFrame {

    private ModeloServidor modelo;
    private ArrayList<Integer> jugadores;
    private DefaultTableModel model;

    /**
     *
     * @param modelo
     */
    public ServerView(ModeloServidor modelo) {
        this.modelo = modelo;
        jugadores = new ArrayList<Integer>();
        initComponents();
        estadoServidor.setText("Actualmente hay 0 jugadores conectados.");
        model = (DefaultTableModel) tablaJugadores.getModel();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        acabar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        estadoServidor = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        acabar.setBackground(new java.awt.Color(255, 0, 0));
        acabar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        acabar.setForeground(new java.awt.Color(255, 255, 255));
        acabar.setText("Finalizar juego");
        acabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acabarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Servidor");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        estadoServidor.setText("Default");

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jugador", "Puntuación"
            }
        ));
        jScrollPane2.setViewportView(tablaJugadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(estadoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(acabar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estadoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acabar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actualizaTabla(int idJugador, int puntuacion, String nickJugador) {
        if (esNickBasico(nickJugador)) {
            Object[] fila = {("Jugador " + String.valueOf(idJugador)), String.valueOf(puntuacion)};
            model.addRow(fila);
        } else {
            Object[] fila = {nickJugador, String.valueOf(puntuacion)};
            model.addRow(fila);
        }
        jugadores.add(idJugador);
        estadoServidor.setText("Actualmente hay " + jugadores.size() + " jugadores conectados.");
    }

    public void actualizaPuntuacion(int idJugador, int nuevaPuntuacion, String nickJugador) {
        if (buscaJugador(idJugador) == -1) {
            actualizaTabla(idJugador, 0, nickJugador);
        } else if (esNickBasico(nickJugador)) {
            Object[] filaActualizada = {("Jugador " + String.valueOf(idJugador)), String.valueOf(nuevaPuntuacion)};
            model.removeRow(idJugador);
            model.insertRow(idJugador, filaActualizada);
        } else {
            Object[] filaActualizada = {nickJugador, String.valueOf(nuevaPuntuacion)};
            model.removeRow(idJugador);
            model.insertRow(idJugador, filaActualizada);
        }
    }

    private boolean esNickBasico(String nick) {
        return nick.equals("Jugador");
    }

    private int buscaJugador(int idJugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i) == idJugador) {
                return i;
            }
        }
        return -1;
    }

    public void eliminaFila(int posicion){
        model.removeRow(posicion);
        jugadores.remove(posicion);
        estadoServidor.setText("Actualmente hay " + jugadores.size() + " jugadores conectados.");
    }

    private void acabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acabarActionPerformed
        //modelo.finalizaConexion();
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_acabarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acabar;
    private java.awt.Label estadoServidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables
}
