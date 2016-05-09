/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

/******************************* PAQUETES IMPORTADOS *******************************/
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.Timer;
import java.util.TimerTask;

/**************************** CLASE DEL OBJETO "VISTA 1". **************************
Esta clase es el modelo que observa a modelo. Como tal, implementa el patrón Observer
y su método update.
************************************************************************************/
public class VistaPuntuacion extends javax.swing.JFrame implements Observer{

    /***************************** ATRIBUTOS DE CLASE. *****************************
    Tienen acceso privado para facilitar el encapsulamiento. Para acceder a su con-
    tenido emplearemos los métodos get y set (si es necesario).
    ********************************************************************************/
    private String id;
    private VistaTablero vista;

    /*************************** CONSTRUCTOR DE LA CLASE. **************************
    Recibe como argumento el ID que le permite dar nombre para identificar a los dis-
    tintos jugadores.
    ********************************************************************************/
    public VistaPuntuacion(String id, VistaTablero vista) {
        initComponents();
        this.id=id;
        jID.setText(this.id);
    }

    // Código generado automáticamente por el IDE empleado: NetBeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        puntos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jID = new javax.swing.JLabel();
        endProccess = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        puntos.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        puntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntos.setText("0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Puntos totales");

        contador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        contador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contador.setText("00:00:00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tiempo partida");

        jID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jID.setText("#ID");

        endProccess.setBackground(new java.awt.Color(255, 0, 0));
        endProccess.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        endProccess.setForeground(new java.awt.Color(255, 255, 255));
        endProccess.setText("Finalizar");
        endProccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endProccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(endProccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(contador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(puntos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contador, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endProccess, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void endProccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endProccessActionPerformed
        vista.dispose();
    }//GEN-LAST:event_endProccessActionPerformed

    /****************************** MÉTODOS DE CLASE. ******************************
    Agregan funcionalidades al objeto de la clase.
    ********************************************************************************/
    private void actualizarPuntos(String puntuacion){
        puntos.setText(puntuacion);
    }

    private void actualizarContador(String tiempo){
        contador.setText(tiempo);
    }

    @Override
    public void update(Observable o, Object o1) {
        Modelo modelo=(Modelo) o;
        actualizarContador(modelo.getTiempo());
        if (id=="Jugador IA")
            actualizarPuntos(modelo.getPuntosIA());
        else
            actualizarPuntos(modelo.getPuntos());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contador;
    private javax.swing.JButton endProccess;
    private javax.swing.JLabel jID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel puntos;
    // End of variables declaration//GEN-END:variables

}

