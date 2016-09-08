package servidor;

import java.io.DataOutputStream;
import java.util.LinkedList;
import java.io.IOException;
import java.util.Random;
import java.net.Socket;

/**
 * Representa al jugador. Cada socket cliente es un jugador.
 *
 * @author c.vazquezlos
 */
public class Jugador {

    // Serpiente que manejará el jugador
    private LinkedList serpiente;
    // ID asociado al cliente
    private int idCliente;
    // Socket asociado al cliente
    private Socket socket;
    // Dirección en la que se mueve la serpiente
    private int direccion;
    // Nick del jugador
    private String nick;
    private DataOutputStream streamOut;

    /**
     * Constructor del jugador con los parámetros esenciales de éste.
     *
     * @param serpiente
     * @param idCliente
     * @param sc
     * @throws IOException
     */
    public Jugador(LinkedList serpiente, int idCliente, Socket sc) throws IOException {
        this.serpiente = serpiente;
        this.idCliente = idCliente;
        Random rnd = new Random();
        this.direccion = rnd.nextInt(4);
        this.socket = sc;
        streamOut = new DataOutputStream(socket.getOutputStream());
    }

    /**
     * Devuelve la serpiente.
     *
     * @return
     */
    public LinkedList getSerpiente() {
        return serpiente;
    }

    /**
     * Devuelve el ID del cliente.
     *
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    public String getNick(){
        return nick;
    }

    /**
     * Devuelve el socket.
     *
     * @return
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * Devuelve la dirección a la que se dirige.
     *
     * @return
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * Devuelve el streamOut (socket servidor).
     *
     * @return
     */
    public DataOutputStream getStreamOut() {
        return streamOut;
    }

    /**
     * Permite asignarle un ID (si no lo tiene).
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Permite asignarle una dirección (si no la tiene).
     *
     * @param direccion
     */
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    /**
     * Permite asignarle un socket (si no lo tiene).
     *
     * @param socket
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * Permite asignarle un streamOut (si no lo tiene).
     *
     * @param streamOut
     */
    public void setStreamOut(DataOutputStream streamOut) {
        this.streamOut = streamOut;
    }

    /**
     * Realiza una copia del jugador.
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Jugador copia() throws CloneNotSupportedException {
        return (Jugador) this.clone();
    }
}
