package cliente;

/**
 * Representa la interfaz en la que el usuario introduce el modo de juego.
 *
 * @author c.vazquezlos
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private String[] resultados;
    // Boolean que se activan si el juego es contra la IA o contra otro jugador
    private String IA, comp, indiv;
    private InterfazRed iuRed;

    /**
     * Constructor con la interfaz de red y los resultados gráficos.
     *
     * @param resultados
     * @param iuRed
     */
    public PantallaPrincipal(String[] resultados, InterfazRed iuRed) {
        initComponents();
        this.iuRed = iuRed;
        this.resultados = resultados;
        indiv = "0";
        IA = "1";
        comp = "2";
    }

    /**
     * Constructor con la interfaz de red
     *
     * @param iuRed
     */
    public PantallaPrincipal(InterfazRed iuRed) {
        initComponents();
        this.iuRed = iuRed;
        resultados = new String[1];
        indiv = "0";
        IA = "1";
        comp = "2";
    }

    /**
     * Constructor con los resultados
     *
     * @param resultados
     */
    public PantallaPrincipal(String[] resultados) {
        initComponents();
        this.resultados = resultados;
        indiv = "0";
        IA = "1";
        comp = "2";
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        opcionesActivar = new javax.swing.JButton();
        botonInstrucciones = new javax.swing.JButton();
        cerrarapp = new javax.swing.JButton();
        botonLanzador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jugadorvsia = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

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

        cerrarapp.setBackground(new java.awt.Color(255, 0, 0));
        cerrarapp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cerrarapp.setForeground(new java.awt.Color(255, 255, 255));
        cerrarapp.setText("Cerrar aplicación");
        cerrarapp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        cerrarapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarappActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(opcionesActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(botonInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(cerrarapp, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(cerrarapp, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionesActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        botonLanzador.setBackground(new java.awt.Color(51, 153, 255));
        botonLanzador.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        botonLanzador.setForeground(new java.awt.Color(255, 255, 255));
        botonLanzador.setText("Juego en red");
        botonLanzador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        botonLanzador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonLanzador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLanzadorActionPerformed(evt);
            }
        });

        jLabel1.setText("Carlos Vázquez Losada y Jorge Galindo Peña");

        jugadorvsia.setBackground(new java.awt.Color(97, 176, 255));
        jugadorvsia.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jugadorvsia.setForeground(new java.awt.Color(255, 255, 255));
        jugadorvsia.setText("1 vs IA");
        jugadorvsia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        jugadorvsia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadorvsiaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 70)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Juego de la Serpiente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(botonLanzador, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jugadorvsia, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonLanzador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugadorvsia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionesActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesActivarActionPerformed
        Opciones opcion = new Opciones(iuRed);
        opcion.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_opcionesActivarActionPerformed


    private void botonLanzadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLanzadorActionPerformed
        iuRed.setVisible(true);
        iuRed.insertarOpciones(resultados);
        this.dispose();
    }//GEN-LAST:event_botonLanzadorActionPerformed

    private void botonInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInstruccionesActionPerformed
        Instrucciones instrucciones = new Instrucciones(iuRed);
        instrucciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonInstruccionesActionPerformed

    private void cerrarappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarappActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cerrarappActionPerformed

    private void jugadorvsiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadorvsiaActionPerformed

    }//GEN-LAST:event_jugadorvsiaActionPerformed

    /**
     * Introduce el valor de los resultados.
     *
     * @param resultados
     */
    public void setResultados(String[] resultados) {
        this.resultados = new String[resultados.length];
        for (int i = 0; i < resultados.length; i++) {
            this.resultados[i] = resultados[i];
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonInstrucciones;
    private javax.swing.JButton botonLanzador;
    private javax.swing.JButton cerrarapp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jugadorvsia;
    private javax.swing.JButton opcionesActivar;
    // End of variables declaration//GEN-END:variables

}
