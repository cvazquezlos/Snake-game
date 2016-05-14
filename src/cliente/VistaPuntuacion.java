
package cliente;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * Vista de la puntuación obtenida por cada jugador. Implementa la vista del MVC y del Observer.
 * @author c.vazquezlos
 */
public class VistaPuntuacion extends javax.swing.JFrame implements Observer{

    /**
     * Constructor del tablero de la puntuación.
     */
    public VistaPuntuacion() {
        initComponents();
    }

    /**
     * Devuelve el valor de la puntuación.
     * @return
     */
    public JLabel getPuntuacion(){
        return puntuacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        puntuacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Puntuación");

        puntuacion.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        puntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacion.setText("0");
        puntuacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(puntuacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntuacion, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel puntuacion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        ModeloVistas modelo=(ModeloVistas) o;
    }
}
