package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author c.vazquezlos
 */
public class SocketServidor {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Creamos un Socket de aceptación en el servidor esperando conexiones
        ServerSocket svrSocket = new ServerSocket(8000);
        System.out.println("Servidor: esperando conexiones ...\n");
        ModeloServidor modeloServidor = new ModeloServidor(50, 50);
        //Vista de servidor con boton para finalizar el servidor
        ServerView serverView = new ServerView(modeloServidor);
        serverView.setLocationRelativeTo(null);
        serverView.setVisible(true);
        System.out.println("");
        // Cuando se genera un nuevo cliente se crea una nueva hebra
        int idClient = 0;
        while (!modeloServidor.esTerminado()) {
            Socket socket = svrSocket.accept();
            System.out.println("Cliente " + idClient + " conectado");
            modeloServidor.añadeJugador(idClient, socket);
            Thread t = new HebraServidor(socket, idClient, modeloServidor);
            t.start();
            idClient++;
        }
        System.out.println("Servidor finalizado");
    }
}
