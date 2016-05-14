/***********************************************************************************
******************* PRÁCTICA FINAL METODOLOGÍA DE LA PROGRAMACIÓN ******************
******************** Carlos Vázquez Losada y Jorge Galindo Peña ********************
************************************************************************************/
package clases;

/************************** CLASE DEL OBJETO "LANZADOR". ***************************
Esta clase permite lanzar el modelo observado (Modelo.java), las vistas que lo obser-
van (VistaTablero.java y VistaPuntuacion.java) y el controlador (Controlador.java),
implementando así el patrón Observer y el MVC.
************************************************************************************/
public class PantallaPrincipal extends javax.swing.JFrame{

    /***************************** ATRIBUTOS DE CLASE. *****************************
    Tienen acceso privado para facilitar el encapsulamiento. Para acceder a su con-
    tenido emplearemos los métodos get y set.
    ********************************************************************************/
    private String[] resultados;
    // Boolean que se activan si el juego es contra la IA o contra otro jugador
    private String IA, comp, indiv;

    /*************************** CONSTRUCTOR DE LA CLASE. **************************
    Inicializa el JFrame del que hereda y además el String de Resultados (por si no
    se introducen cambios procedentes de las opciones gráficas.
    ********************************************************************************/
    public PantallaPrincipal() {
        initComponents();
        resultados=new String[1];
        indiv="0";
        IA="1";
        comp="2";
    }

    // Código generado automáticamente por el IDE empleado: NetBeans
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        opcionesActivar = new javax.swing.JButton();
        botonInstrucciones = new javax.swing.JButton();
        cerrarapp = new javax.swing.JButton();
        ranking = new javax.swing.JButton();
        botonLanzador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jugadorvsia = new javax.swing.JButton();
        jugadorvsjugador = new javax.swing.JButton();
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

        ranking.setBackground(new java.awt.Color(51, 102, 255));
        ranking.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ranking.setForeground(new java.awt.Color(255, 255, 255));
        ranking.setText("Ranking de puntos");
        ranking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opcionesActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(botonInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(cerrarapp, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cerrarapp, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ranking, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addComponent(botonInstrucciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(opcionesActivar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        botonLanzador.setBackground(new java.awt.Color(51, 153, 255));
        botonLanzador.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        botonLanzador.setForeground(new java.awt.Color(255, 255, 255));
        botonLanzador.setText("1 jugador");
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

        jugadorvsjugador.setBackground(new java.awt.Color(102, 204, 255));
        jugadorvsjugador.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jugadorvsjugador.setForeground(new java.awt.Color(255, 255, 255));
        jugadorvsjugador.setText("1 vs 1");
        jugadorvsjugador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

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
                .addGap(72, 72, 72)
                .addComponent(botonLanzador, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jugadorvsia, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jugadorvsjugador, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonLanzador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugadorvsia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugadorvsjugador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /****************************** MÉTODOS DE CLASE. ******************************
    Agregan funcionalidades al objeto de la clase.
    ********************************************************************************/
    // Este método se activa al pulsar sobre el botón "Opciones gráficas", y su fun-
    // cionalidad es la de implementar cambios sobre la vista del tablero
    private void opcionesActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesActivarActionPerformed
        Opciones opcion=new Opciones();
        opcion.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_opcionesActivarActionPerformed

    // Método lanzador del modelo Observer y MVC para un solo jugador. Se activa pul-
    // sando el botón "1 jugador"
    private void botonLanzadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLanzadorActionPerformed
        Modelo modelo=new Modelo(resultados, indiv);
        VistaTablero vista=new VistaTablero(modelo);
        VistaPuntuacion puntuacion=new VistaPuntuacion("Jugador 1", vista);
        puntuacion.setVisible(true);
        vista.setVisible(true);
        puntuacion.setBounds((modelo.getCols()*15)-(modelo.getCols()/3), 40, 165, 320);
        Controlador controlador=new Controlador(modelo, vista);
        modelo.addObserver(vista);
        modelo.addObserver(puntuacion);
        modelo.notificaCambios();
    }//GEN-LAST:event_botonLanzadorActionPerformed

    // Se activa pulsando el botón "Instrucciones del juego". Lanza la ventana de
    // instrucciones
    private void botonInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInstruccionesActionPerformed
        Instrucciones instrucciones=new Instrucciones();
        instrucciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonInstruccionesActionPerformed

    // Cierra la aplicación si se pulsa el botón "Cerrar aplicación"
    private void cerrarappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarappActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cerrarappActionPerformed

    // Lanza el ranking
    private void rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rankingActionPerformed

    // Método lanzador de un jugador contra la máquina. Lanza un modelo (Modelo.java),
    // y sus vistas asociadas. La serpiente funciona de manera automática
    private void jugadorvsiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadorvsiaActionPerformed
        Modelo modelo=new Modelo(resultados, IA);
        VistaTablero vista=new VistaTablero(modelo);
        VistaPuntuacion puntuacion=new VistaPuntuacion("Jugador 1", vista);
        VistaPuntuacion puntuacionIA=new VistaPuntuacion("Jugador IA", vista);
        puntuacionIA.setVisible(true);
        puntuacion.setVisible(true);
        vista.setVisible(true);
        puntuacionIA.setBounds((modelo.getCols()*15)-(modelo.getCols()/3)+150, 40, 165, 320);
        puntuacion.setBounds((modelo.getCols()*15)-(modelo.getCols()/3), 40, 165, 320);
        Controlador controlador=new Controlador(modelo, vista);
        modelo.addObserver(vista);
        modelo.addObserver(puntuacion);
        modelo.addObserver(puntuacionIA);
        modelo.notificaCambios();
    }//GEN-LAST:event_jugadorvsiaActionPerformed

    // Recopila la información de las opciones gráficas
    public void setResultados(String[] resultados){
        this.resultados=new String[resultados.length];
        for (int i=0; i<resultados.length; i++)
            this.resultados[i]=resultados[i];
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
    private javax.swing.JButton jugadorvsjugador;
    private javax.swing.JButton opcionesActivar;
    private javax.swing.JButton ranking;
    // End of variables declaration//GEN-END:variables

}
