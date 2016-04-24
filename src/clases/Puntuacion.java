/*----------------------------------------
Práctica de Metodología de la Programación
Hecha por: Carlos Vázquez Losada
----------------------------------------*/
package clases;

import javax.swing.JTextField;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.Timer;
import java.util.TimerTask;

public class Puntuacion extends javax.swing.JFrame {

    private Timer timer = new Timer();
    private int segundos=0;
    private int minutos=0;
    private int horas=0;

    public Puntuacion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        puntos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addComponent(puntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contador, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puntuacion().setVisible(true);
            }
        });
    }

    public void actualizarPuntos(String puntuacion){
        puntos.setText(puntuacion);
    }

    public void activarContador(boolean valor){
        if (valor){
            timer = new Timer();
            timer.schedule(new Contador(), 0, 1000);
        } else
            timer.cancel();
    }

    class Contador extends TimerTask {
        public void run() {
            segundos++;
            if (segundos==60){
                minutos++;
                segundos=0;
            }
            if (minutos==60){
                horas++;
                minutos=0;
            }
            // Cambios estéticos, para que los números aparezcan con dos cifras.
            String segundo=Integer.toString(segundos);
            if (segundo.length()==1) segundo="0"+Integer.toString(segundos);
            String minuto=Integer.toString(minutos);
            if (minuto.length()==1) minuto="0"+Integer.toString(minutos);
            String hora=Integer.toString(horas);
            if (hora.length()==1) hora="0"+Integer.toString(horas);
            contador.setText(hora+":"+minuto+":"+segundo);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contador;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel puntos;
    // End of variables declaration//GEN-END:variables

}

