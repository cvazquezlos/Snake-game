package cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.net.Socket;
import java.io.IOException;
import java.util.Observable;
import java.io.DataOutputStream;

/**
 * Clase que implementa el objeto observado por las vistas. Modelo del MVC y del
 * Observer.
 *
 * @author c.vazquezlos
 */
public class ModeloVistas extends Observable {

    private Socket socket;
    private int idCliente;
    private HebraCliente hebra;
    private VistaTablero tablero;
    private VistaPuntuacion puntuacion;
    private Controlador controlador;
    private DataOutputStream streamOut;
    private InterfazRed iuRed = new InterfazRed(this);
    private String[] resultados;
    private String nickJugador;

    /**
     * Lanza las vistas asociadas a él y recibe los movimientos del controlador.
     *
     * @param texto
     * @param texto1
     * @param texto2
     */
    public void empezar(String texto, String texto1, String texto2) {
        this.idCliente = Integer.parseInt(texto);
        int x = Integer.parseInt(texto1);
        int y = Integer.parseInt(texto2);
        if (tablero == null) {
            tablero = new VistaTablero(x, y, idCliente, this, getColorFondo(), getDimension());
            controlador = new Controlador(tablero, this);
            // Genera el tablero de puntuación
            puntuacion = new VistaPuntuacion();
            puntuacion.setBounds((x * 13), 40, 174, 200);
            puntuacion.setVisible(true);
            // Asigna el controlador a la vista
            tablero.setControlador(controlador);
            // Una vez lo ha creado, entonces lo muestra
            tablero.setVisible(true);
            // Inserta al tablero para observar a esta clase
            addObserver(tablero);
        }
    }

    /**
     * Permite lanzar la interfaz de interacción con el usuario.
     */
    public void iniciar() {
        PantallaPrincipal pp = new PantallaPrincipal(iuRed);
        pp.setVisible(true);
    }

    /**
     * Finaliza la ejecución del cliente.
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void finalizar() throws IOException, InterruptedException {
        tablero.dispose();
        puntuacion.dispose();
        enviarMensaje("FIN;" + Integer.toString(idCliente));
        hebra.acabar();
        streamOut.close();
        socket.close();
        System.exit(0);
    }

    /**
     * El nuevo cliente conecta con el servidor.
     *
     * @throws IOException
     */
    public void conectar() throws IOException {
        iuRed.dispose();
        socket = new Socket(iuRed.getDireccionIp(), iuRed.getPuerto());
        resultados = iuRed.getResultados();
        nickJugador = iuRed.getNick();
        streamOut = new DataOutputStream(socket.getOutputStream());
        enviarMensaje("CON;");
        hebra = new HebraCliente(socket, this);
        hebra.start();
    }

    /**
     * El servidor corta la conexión con el cliente.
     *
     * @param id
     * @throws IOException
     */
    public void finalizaCliente(String id) throws IOException {
        int idJugador = Integer.parseInt(id);
        this.socket.close();
        tablero.dispose();
        puntuacion.dispose();
        streamOut.close();
        iuRed.dispose();
    }

    /**
     * Movimiento hacia arriba.
     *
     * @throws IOException
     */
    public void arriba() throws IOException {
        enviarMensaje("DIR;ARRIBA");
    }

    /**
     * Movimiento hacia abajo.
     *
     * @throws IOException
     */
    public void abajo() throws IOException {
        enviarMensaje("DIR;ABAJO");
    }

    /**
     * Movimiento hacia la izquierda.
     *
     * @throws IOException
     */
    public void izquierda() throws IOException {
        enviarMensaje("DIR;IZQUIERDA");
    }

    /**
     * Movimiento hacia la derecha.
     *
     * @throws IOException
     */
    public void derecha() throws IOException {
        enviarMensaje("DIR;DERECHA");
    }

    /**
     * Notifica a los observadores sobre los cambios producidos.
     *
     * @param i
     * @param j
     * @param k
     * @param l
     * @param m
     */
    public void mover(String i, String j, String k, String l, String m) {
        setChanged();
        notifyObservers(true + ";" + i + ";" + j + ";" + k + ";" + l + ";" + m);
    }

    /**
     * Si algún tesoro no está, lo muestra.
     *
     * @param i
     * @param j
     * @param k
     */
    public void muestraTesoro(String i, String j, String k) {
        setChanged();
        System.out.println("info:" + i);
        System.out.println("info:" + j);
        System.out.println("info:" + k);
        notifyObservers(false + ";" + i + ";" + j + ";" + k);
    }

    /**
     * Emplea las opciones gráficas para devolver el color de fondo.
     */
    private Color getColorFondo() {
        if (resultados.length != 1) {
            switch (resultados[0]) {
                case ("Azul verdoso"):
                    return new java.awt.Color(46, 254, 200);
                case ("Azul claro"):
                    return new java.awt.Color(129, 218, 245);
                case ("Verde"):
                    return Color.green;
                case ("Negro"):
                    return Color.black;
                case ("Blanco"):
                    return Color.white;
            }
        }
        return new java.awt.Color(204, 255, 204);
    }

    /**
     * Emplea las opciones gráficas para devolver la dimensión del tablero.
     */
    private Dimension getDimension() {
        if (resultados.length != 1) {
            switch (resultados[4]) {
                case ("20x20"):
                    return new Dimension(20 * 13, 20 * 13);
                case ("25x25"):
                    return new Dimension(25 * 13, 25 * 13);
                case ("30x30"):
                    return new Dimension(30 * 13, 30 * 13);
                case ("35x35"):
                    return new Dimension(35 * 13, 35 * 13);
                case ("40x40"):
                    return new Dimension(40 * 13, 40 * 13);
                case ("50x50"):
                    return new Dimension(50 * 13, 50 * 13);
                case ("60x60"):
                    return new Dimension(60 * 13, 60 * 13);
            }
        }
        return new Dimension(50 * 13, 50 * 13);
    }

    /**
     * Conecta con la hebra del servidor.
     */
    private void enviarMensaje(String mensaje) throws IOException {
        // Muestra el mensaje por consola para ver si se ha enviado correctamente
        System.out.println(mensaje + " al servidor ");
        streamOut.writeBytes(mensaje + "\n");
        streamOut.flush();
    }

    /**
     * Modifica los puntos de la vista.
     *
     * @param puntos
     */
    public void puntos(String puntos) {
        puntuacion.getPuntuacion().setText(puntos);
    }

}
