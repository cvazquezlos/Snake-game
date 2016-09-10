package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author c.vazquezlos
 */
public class SocketServidor {

    private static ArrayList<Jugador> jugadores;
    private static ArrayList<Socket> socketJugadores;
    private static ArrayList<Integer> idJugadores;
    private static ArrayList<Thread> threadJugadores;

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
        idJugadores = new ArrayList<Integer>();
        socketJugadores = new ArrayList<Socket>();
        jugadores = new ArrayList<Jugador>();
        System.out.println("");
        modeloServidor.setVistaServidor(serverView);
        // Cuando se genera un nuevo cliente se crea una nueva hebra
        int idClient = 0;
        while (!modeloServidor.esTerminado()) {
            Socket socket = svrSocket.accept();
            System.out.println("Cliente " + idClient + " conectado");
            serverView.actualizaTabla(idClient, 0, modeloServidor.buscaNickJugador(idClient));
            modeloServidor.añadeJugador(idClient, socket);
            Thread t = new HebraServidor(socket, idClient, modeloServidor);
            t.start();
            jugadores = modeloServidor.getArrayJugadores();
            socketJugadores.add(socket);
            idJugadores.add(idClient);
            eliminaJugadoresDesconectados();
            idClient++;
        }
        System.out.println("Servidor finalizado");
        svrSocket.close();
    }

    private static void eliminaJugadoresDesconectados() throws IOException {
        for (int i = 0; i < idJugadores.size(); i++) {
            if (!existeJugador(idJugadores.get(i))) {
                System.out.println("Jugador "+idJugadores.get(i)+" eliminado.");
                idJugadores.remove(i);
                socketJugadores.get(i).close();
                socketJugadores.remove(i);
                threadJugadores.remove(i);
            }
        }
    }

    private static boolean existeJugador(int idCliente) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getIdCliente() == idCliente) {
                return true;
            }
        }
        return false;
    }
}
