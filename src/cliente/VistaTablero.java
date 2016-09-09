package cliente;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.util.Observer;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa la vista del tablero. Implementa la vista del MVC y del Observer.
 *
 * @author c.vazquezlos
 */
public class VistaTablero extends javax.swing.JFrame implements Observer {

    private GridLayout layout;
    private JPanel[][] referencia;
    private Color[] coloresTablero = {new java.awt.Color(204, 255, 204), Color.BLACK, Color.ORANGE};
    private Color[] coloresJugador = {Color.RED, Color.BLUE, Color.PINK, Color.BLUE, Color.YELLOW};
    private ModeloVistas modelo;

    /**
     * Constructor con diferentes parámetros que recibe del modelo.
     *
     * @param filas
     * @param columnas
     * @param idJugador
     * @param modelo
     * @param colorFondo
     * @param dimension
     */
    public VistaTablero(int filas, int columnas, int idJugador, ModeloVistas modelo, Color colorFondo, Dimension dimension) {
        initComponents();
        jButtonFinalizar.setFocusable(false);
        layout = new GridLayout(filas, columnas);
        referencia = new JPanel[filas][columnas];
        tablero.setLayout(layout);
        for (int i = 0; i < layout.getRows(); i++) {
            for (int j = 0; j < layout.getColumns(); j++) {
                JPanel p = new JPanel();
                p.setBackground(colorFondo);
                referencia[i][j] = p;
                tablero.add(p);
            }
        }
        this.modelo = modelo;
        this.setSize(dimension);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablero = new javax.swing.JPanel();
        jButtonFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jButtonFinalizar.setBackground(new java.awt.Color(255, 0, 0));
        jButtonFinalizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jButtonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Permite asignarle un controlador.
     *
     * @param controlador
     */
    public void setControlador(Controlador controlador) {
        addKeyListener(controlador);
    }

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        try {
            modelo.finalizar();
        } catch (IOException ex) {
            Logger.getLogger(VistaTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables

    /**
     * Lanza la vista.
     */
    public void arrancar() {
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * Pinta la serpiente en el tablero.
     */
    private void pintaSerpiente(String info) {
        String[] args = info.split(";");
        Color color = (Boolean.parseBoolean(args[0])) ? coloresJugador[Integer.parseInt(args[1])] : coloresTablero[Integer.parseInt(args[1])];
        int x = Integer.parseInt(args[2]);
        int y = Integer.parseInt(args[3]);
        referencia[x][y].setBackground(color);
        if (args.length > 4) {
            x = Integer.parseInt(args[4]);
            y = Integer.parseInt(args[5]);
            referencia[x][y].setBackground(coloresTablero[0]);
        }
    }

    /**
     * Redefine el método update debido a que hereda de Observer.
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        String info = (String) arg;
        if (info != "puntuacion") {
            pintaSerpiente(info);
        }
    }
}
