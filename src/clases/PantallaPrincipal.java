/*----------------------------------------
Práctica de Metodología de la Programación
Hecha por: Carlos Vázquez Losada
----------------------------------------*/
package clases;

public class PantallaPrincipal extends javax.swing.JFrame {

    public PantallaPrincipal() {
        initComponents();
        Opciones opcion= new Opciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        opcionesActivar = new javax.swing.JButton();
        botonInstrucciones = new javax.swing.JButton();
        botonJugar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        titulo.setBackground(new java.awt.Color(153, 153, 255));
        titulo.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Juego de la Serpiente");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        opcionesActivar.setBackground(new java.awt.Color(255, 102, 0));
        opcionesActivar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        opcionesActivar.setForeground(new java.awt.Color(255, 255, 255));
        opcionesActivar.setText("Opciones gráficas");
        opcionesActivar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(188, 75, 0)));
        opcionesActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesActivarActionPerformed(evt);
            }
        });

        botonInstrucciones.setBackground(new java.awt.Color(0, 204, 0));
        botonInstrucciones.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonInstrucciones.setForeground(new java.awt.Color(255, 255, 255));
        botonInstrucciones.setText("Instrucciones del juego");
        botonInstrucciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        botonInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInstruccionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcionesActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(botonInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcionesActivar, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(botonInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        botonJugar.setBackground(new java.awt.Color(255, 102, 102));
        botonJugar.setFont(new java.awt.Font("Tahoma", 0, 90)); // NOI18N
        botonJugar.setText("JUGAR");
        botonJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarActionPerformed(evt);
            }
        });

        jLabel1.setText("Carlos Vázquez Losada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(botonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(botonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionesActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesActivarActionPerformed
        Opciones opcion=new Opciones();
        opcion.setVisible(true);
        dispose();
    }//GEN-LAST:event_opcionesActivarActionPerformed

    private void botonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonJugarActionPerformed
        String[] v=new String[1];
        Interfaz interfaz=new Interfaz(v);
        interfaz.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonJugarActionPerformed

    private void botonInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInstruccionesActionPerformed
        Instrucciones instrucciones=new Instrucciones();
        instrucciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonInstruccionesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    public void setResultadosEnInterfaz(String[] resultados){
        Interfaz interfaz=new Interfaz(resultados);
        interfaz.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonInstrucciones;
    private javax.swing.JButton botonJugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton opcionesActivar;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
