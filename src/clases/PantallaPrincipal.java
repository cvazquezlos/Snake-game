/*----------------------------------------
Práctica de Metodología de la Programación
Hecha por: Carlos Vázquez Losada
----------------------------------------*/
package clases;

<<<<<<< HEAD
public class PantallaPrincipal extends javax.swing.JFrame{
=======
import java.util.Observable;
import java.util.Observer;

public class PantallaPrincipal extends javax.swing.JFrame implements Observer{
>>>>>>> Snake-game/master

    String[] resultados;

    public PantallaPrincipal() {
        initComponents();
        resultados=new String[1];
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        opcionesActivar = new javax.swing.JButton();
        botonInstrucciones = new javax.swing.JButton();
        cerrarapp = new javax.swing.JButton();
        ranking = new javax.swing.JButton();
<<<<<<< HEAD
        botonLanzador = new javax.swing.JButton();
=======
        solojugador = new javax.swing.JButton();
>>>>>>> Snake-game/master
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
                .addGap(33, 33, 33)
                .addComponent(botonInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(cerrarapp, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cerrarapp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ranking, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionesActivar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

<<<<<<< HEAD
        botonLanzador.setBackground(new java.awt.Color(51, 153, 255));
        botonLanzador.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        botonLanzador.setForeground(new java.awt.Color(255, 255, 255));
        botonLanzador.setText("1 jugador");
        botonLanzador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        botonLanzador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonLanzador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLanzadorActionPerformed(evt);
=======
        solojugador.setBackground(new java.awt.Color(51, 153, 255));
        solojugador.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        solojugador.setForeground(new java.awt.Color(255, 255, 255));
        solojugador.setText("1 jugador");
        solojugador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        solojugador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        solojugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solojugadorActionPerformed(evt);
>>>>>>> Snake-game/master
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
<<<<<<< HEAD
                .addComponent(botonLanzador, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                .addComponent(solojugador, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> Snake-game/master
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
<<<<<<< HEAD
                    .addComponent(botonLanzador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                    .addComponent(solojugador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> Snake-game/master
                    .addComponent(jugadorvsia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugadorvsjugador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionesActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesActivarActionPerformed
        Opciones opcion=new Opciones();
        opcion.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_opcionesActivarActionPerformed

<<<<<<< HEAD
    private void botonLanzadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLanzadorActionPerformed
        Modelo modelo=new Modelo();
        Vista vista=new Vista();
        vista.setVisible(true);
        Controlador controlador=new Controlador(modelo, vista);
        modelo.addObserver(vista);
        modelo.notificaCambios();
    }//GEN-LAST:event_botonLanzadorActionPerformed
=======
    private void solojugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solojugadorActionPerformed
        Interfaz interfaz=new Interfaz(resultados);
        interfaz.setVisible(true);
        this.setVisible(false);
        Interfaz interfaz1=new Interfaz(resultados);
        interfaz1.setVisible(true);
        interfaz1.setLocation(interfaz.getX()*20, 0);
    }//GEN-LAST:event_solojugadorActionPerformed
>>>>>>> Snake-game/master

    private void botonInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInstruccionesActionPerformed
        Instrucciones instrucciones=new Instrucciones();
        instrucciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonInstruccionesActionPerformed

    private void jugadorvsiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadorvsiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jugadorvsiaActionPerformed

    private void cerrarappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarappActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cerrarappActionPerformed

    private void rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rankingActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    public void setResultados(String[] resultados){
        this.resultados=new String[resultados.length];
        for (int i=0; i<resultados.length; i++)
            this.resultados[i]=resultados[i];
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonInstrucciones;
<<<<<<< HEAD
    private javax.swing.JButton botonLanzador;
=======
>>>>>>> Snake-game/master
    private javax.swing.JButton cerrarapp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jugadorvsia;
    private javax.swing.JButton jugadorvsjugador;
    private javax.swing.JButton opcionesActivar;
    private javax.swing.JButton ranking;
<<<<<<< HEAD
    // End of variables declaration//GEN-END:variables

=======
    private javax.swing.JButton solojugador;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
>>>>>>> Snake-game/master
}
