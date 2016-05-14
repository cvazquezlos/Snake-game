
package cliente;


import java.io.IOException;
import java.util.logging.Level;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

/**
 * Clase que implementa el controlador del patrón MVC.
 * @author c.vazquezlos
 */
public class Controlador implements KeyListener{

    private VistaTablero vista;
    private ModeloVistas modelo;

    /**
     * Constructor del controlador que permite al jugador mover su serpiente.
     * @param vista
     * @param modelo
     */
    public Controlador(VistaTablero vista, ModeloVistas modelo){
       this.vista=vista;
       this.modelo=modelo;
    }

    /**
     * Implementa el KeyTyped del KeyListener.
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e){}

    /**
     * Implementa el keyReleased del keyReleased.
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e){}

    /**
     * Implementa el keyPressed del keyPressed.
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case (VK_UP):
                try {
                    modelo.arriba();
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case (VK_DOWN):
                try {
                    modelo.abajo();
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case (VK_LEFT):
                try {
                    modelo.izquierda();
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case (VK_RIGHT):
                try {
                    modelo.derecha();
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
    }
}
