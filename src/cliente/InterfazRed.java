package cliente;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;

/**
 * Ventana que permite recopilar la información sobre el servidor.
 *
 * @author c.vazquezlos
 */
public class InterfazRed extends javax.swing.JFrame {

    private ModeloVistas modelo;
    private String[] resultados;

    /**
     * Constructor de la ventana con el parámetro del modelo del cliente.
     *
     * @param modelo
     */
    public InterfazRed(ModeloVistas modelo) {
        this.modelo = modelo;
        initComponents();
    }

    /**
     * Constructor por defecto sin parámetros.
     */
    public InterfazRed() {
        initComponents();
    }

    /**
     * Devuelve la dirección IP asociada al host.
     *
     * @return
     */
    public String getDireccionIp() {
        return jTextFieldIP.getText();
    }

    /**
     * Devuelve los resultados que son introducidos por la ventana Opciones.
     *
     * @return
     */
    public String[] getResultados() {
        return resultados;
    }

    /**
     * Devuelve el puerto de conexión.
     *
     * @return
     */
    public int getPuerto() {
        return Integer.parseInt(jTextFieldPuerto.getText());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conexion = new javax.swing.JButton();
        jTextFieldIP = new javax.swing.JTextField();
        jTextFieldPuerto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        conexion.setBackground(new java.awt.Color(0, 153, 0));
        conexion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        conexion.setForeground(new java.awt.Color(255, 255, 255));
        conexion.setText("Iniciar cliente");
        conexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conexionActionPerformed(evt);
            }
        });

        jTextFieldIP.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextFieldIP.setText("localHost");

        jTextFieldPuerto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextFieldPuerto.setText("8000");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Dirección IP:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Puerto:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Conexión del Cliente (dejar por defecto si se desconoce)");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(conexion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIP, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jTextFieldPuerto))
                        .addGap(341, 341, 341))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldIP, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addComponent(conexion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conexionActionPerformed
        try {
            modelo.conectar();
        } catch (IOException ex) {
            Logger.getLogger(InterfazRed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_conexionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldPuerto;
    // End of variables declaration//GEN-END:variables

    // Inserta los valores de las opciones gráficas
    /**
     * Introduce los cambios gráficos de la ventana de opciones.
     *
     * @param resultados
     */
    public void insertarOpciones(String[] resultados) {
        this.resultados = resultados;
    }
}
