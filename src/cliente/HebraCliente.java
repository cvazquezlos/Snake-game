package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la hebra del cliente (Thread del modelo del cliente).
 *
 * @author c.vazquezlos
 */
public class HebraCliente extends Thread {

    private Socket socket;
    private int idClient;
    private ModeloVistas vistas;
    private BufferedReader streamIn;
    private boolean fin;

    /**
     * Constructor de la hebra.
     *
     * @param socket
     * @param vistas
     */
    HebraCliente(Socket socket, ModeloVistas vistas) throws IOException {
        this.vistas = vistas;
        this.socket = socket;
        this.fin = true;
        streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Redefinición del método Thread asociado a la hebra. Interpreta los
     * mensajes enviados por el servidor.
     */
    @Override
    public void run() {
        try {
            while (fin) {
                String mensaje = streamIn.readLine();
                System.out.println("del servidor: " + mensaje);
                String[] info = mensaje.split(";");
                String cabecera = info[0];
                switch (cabecera) {
                    case ("IDC"):
                        vistas.empezar(info[1], info[2], info[3]);
                        break;
                    case ("FIN"):
                        this.acabar();
                        break;
                    case ("TSR"):
                        vistas.muestraTesoro(info[1], info[2], info[3]);
                        break;
                    case ("MOV"):
                        vistas.mover(info[1], info[2], info[3], info[4], info[5]);
                        break;
                    case ("PTS"):
                        vistas.puntos(info[1]);
                        break;
                    case ("ERR"):
                        vistas.finalizaCliente(info[1]);
                        break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HebraCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(HebraCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Finaliza y termina la ejecución.
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void acabar() throws IOException, InterruptedException {
        this.fin = false;
        Thread.sleep(100);
        streamIn.close();
        socket.close();
        vistas.finalizar();
    }
}
