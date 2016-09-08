package servidor;

import java.net.Socket;
import java.util.Random;
import java.util.ArrayList;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c.vazquezlos
 */
public class ModeloServidor {

    private ArrayList<Jugador> jugadores;
    private int longitudX;
    private int longitudY;
    private int velocidad = 3000;
    private Punto tesoro;
    private Punto tesoroTemporal;
    Thread hilo = iniciar();
    private boolean terminar;
    private ServerView vistaServidor;

    /**
     *
     * @param longitudX
     * @param longitudY
     * @throws IOException
     */
    public ModeloServidor(int longitudX, int longitudY) throws IOException {
        terminar = false;
        jugadores = new ArrayList<>();
        this.longitudX = longitudX;
        this.longitudY = longitudY;
        // Genera un tesoro en una posición aleatoria
        Random rnd = new Random();
        this.tesoro = new Punto(rnd.nextInt(this.longitudX - 1), rnd.nextInt(this.longitudY - 1));
        this.tesoroTemporal = new Punto();
        // Comienza el hilo
        hilo.start();
    }

    public void setVistaServidor(ServerView vistaServidor) {
        this.vistaServidor = vistaServidor;
    }

    /**
     *
     * @param idJugador
     * @param socket
     * @throws IOException
     */
    public void añadeJugador(int idJugador, Socket socket) throws IOException {
        Random rnd = new Random();
        // Inserta al jugador en una posición aleatoria en el tablero
        Punto punto = new Punto(rnd.nextInt(longitudX), rnd.nextInt(longitudY));
        LinkedList serpiente = new LinkedList();
        serpiente.add(punto);
        Jugador jugador = new Jugador(serpiente, idJugador, socket);
        jugador.setDireccion(rnd.nextInt(4));
        jugadores.add(jugador);
    }

    /**
     *
     * @param idJugador
     * @throws IOException
     */
    public void conecta(int idJugador) throws IOException {
        String cabecera = "IDC";
        String cuerpo = idJugador + ";" + longitudX + ";" + longitudY;
        enviarMensaje(cabecera + ";" + cuerpo);
        pintarTesoro(tesoro.getCoordenadaX(), tesoro.getCoordenadaY(), 1);
    }

    /**
     *
     * @param mensaje
     * @throws IOException
     */
    public void enviarMensaje(String mensaje) throws IOException {
        System.out.println("a clientes:" + mensaje);
        for (Jugador j : jugadores) {
            j.getStreamOut().writeBytes(mensaje + "\n");
            j.getStreamOut().flush();
        }
    }

    /**
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void finalizaConexion() throws IOException, InterruptedException {
        String cabecera = "FIN";
        for (int i = 0; i < jugadores.size(); i++) {
            enviarMensaje(cabecera);
            jugadores.get(i).getStreamOut().close();
            jugadores.get(i).getSocket().close();
        }
        this.terminar = true;
    }

    /**
     *
     * @return
     */
    public boolean esTerminado() {
        return terminar;
    }

    public String buscaNickJugador(int idJugador){
        String resultado="";
        for (int i=0; i<jugadores.size(); i++)
            if (jugadores.get(i).getIdCliente()==idJugador)
                resultado=jugadores.get(i).getNick();
        return resultado;
    }

    /**
     *
     * @param nuevaDir
     * @param idJugador
     */
    public void cambiarDireccion(String nuevaDir, int idJugador) {
        switch (nuevaDir) {
            case "ARRIBA":
                arriba(idJugador);
                break;
            case "ABAJO":
                abajo(idJugador);
                break;
            case "IZQUIERDA":
                izquierda(idJugador);
                break;
            case "DERECHA":
                derecha(idJugador);
                break;
        }
    }

    private void arriba(int idJugador) {
        if (jugadores.get(idJugador).getDireccion() != 3) {
            jugadores.get(idJugador).setDireccion(1);
        }
    }

    private void abajo(int idJugador) {
        if (jugadores.get(idJugador).getDireccion() != 1) {
            jugadores.get(idJugador).setDireccion(3);
        }
    }

    private void izquierda(int idJugador) {
        if (jugadores.get(idJugador).getDireccion() != 2) {
            jugadores.get(idJugador).setDireccion(0);
        }
    }

    private void derecha(int idJugador) {
        if (jugadores.get(idJugador).getDireccion() != 0) {
            jugadores.get(idJugador).setDireccion(2);
        }
    }

    private void pintarTesoro(int coordenadaX, int coordenadaY, int t) throws IOException {
        String cabecera = "TSR";
        String cuerpo = t + ";" + coordenadaX + ";" + coordenadaY;
        enviarMensaje(cabecera + ";" + cuerpo);
    }

    private void puntuacion(int idJugador) throws IOException {
        String cabecera = "PTS";
        String cuerpo = Integer.toString((jugadores.get(idJugador).getSerpiente().size()) * 10);
        enviarMensaje(cabecera + ";" + cuerpo);
        vistaServidor.actualizaPuntuacion(idJugador, ((jugadores.get(idJugador).getSerpiente().size()) * 10), buscaNickJugador(idJugador));
    }

    private void addTesoro(int tesoroAAñadir) throws IOException {
        Random rnd = new Random();
        if (tesoroAAñadir == 1) {
            int x = rnd.nextInt(longitudX);
            int y = rnd.nextInt(longitudY);
            tesoro = new Punto(x, y);
            pintarTesoro(tesoro.getCoordenadaX(), tesoro.getCoordenadaY(), 1);
        } else {
            int x = rnd.nextInt(longitudX);
            int y = rnd.nextInt(longitudY);
            tesoroTemporal = new Punto(x, y);
            pintarTesoro(tesoroTemporal.getCoordenadaX(), tesoroTemporal.getCoordenadaY(), 2);
        }
    }

    /**
     *
     * @param t
     * @param id
     * @throws IOException
     */
    public void tesoroComido(int t, int id) throws IOException {
        if (t == 1) {
            //actualizar puntuacion jugador id con puntuacion tesoro tipo 1;
            addTesoro(1);
        } else {
            //actualizar puntuacion jugador id con puntuacion tesoro tipo 2;
            addTesoro(2);
        }
        // Se genera un nuevo punto
        jugadores.get(id).getSerpiente().add(new Punto());
    }

    /**
     *
     * @param idJugador
     * @param mensaje
     * @throws IOException
     */
    public void gameOver(int idJugador, String mensaje) throws IOException {
        String cabecera = "ERR";
        String contenido = idJugador + ";" + mensaje;
        enviarMensaje(cabecera + ";" + contenido);
    }

    private void distancia(int id, int coordenadaXInicial, int coordenadaYInicial, int coordenadaXFinal, int coordenadaYFinal) throws IOException {
        String cabecera = "MOV";
        String contenido = id + ";" + coordenadaXInicial + ";" + coordenadaYInicial + ";" + coordenadaXFinal + ";" + coordenadaYFinal;
        enviarMensaje(cabecera + ";" + contenido);
    }

    /**
     *
     * @return
     */
    public Thread iniciar() {
        return new Thread() {
            @Override
            public void run() {
                int mostrarTesoro = 0;
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }
                    // En cada Thread recorre los jugadores, actualizando sus posiciones
                    for (Jugador j : jugadores) {
                        try {
                            actualizarPosicion(j.getIdCliente());
                            tesoroComido(j.getIdCliente());
                        } catch (Exception e) {
                        }
                    }
                    mostrarTesoro++;
                    if (mostrarTesoro == 10) {
                        try {
                            pintarTesoro(tesoroTemporal.getCoordenadaX(), tesoroTemporal.getCoordenadaY(), 0);
                        } catch (IOException ex) {
                            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            addTesoro(2);
                        } catch (IOException ex) {
                            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            // Si el jugador se ha movido, se actualiza su posición
            private void actualizarPosicion(int idJugador) throws IOException {
                int xi = ((Punto) jugadores.get(idJugador).getSerpiente().getFirst()).getCoordenadaX();
                int yi = ((Punto) jugadores.get(idJugador).getSerpiente().getFirst()).getCoordenadaY();
                int xf = ((Punto) jugadores.get(idJugador).getSerpiente().getLast()).getCoordenadaX();
                int yf = ((Punto) jugadores.get(idJugador).getSerpiente().getLast()).getCoordenadaY();
                LinkedList ll = (LinkedList) jugadores.get(idJugador).getSerpiente().clone();
                ll.removeFirst();
                // Si se choca contra si mismo entonces para
                if (ll.contains(jugadores.get(idJugador).getSerpiente().getFirst())) {
                    gameOver(idJugador, "Choque consigo mismo");
                    // Si se choca contra otros jugadores entonces para
                } else if (chocaContraJugador(idJugador)) {
                    gameOver(idJugador, "Choque con otro jugador");
                } else {
                    // Si no se choca contra otros jugadores, entonces se mueve
                    jugadores.get(idJugador).getSerpiente().removeLast();
                    // Controlamos que se salga del tablero
                    puntuacion(idJugador);
                    int direccion = jugadores.get(idJugador).getDireccion();
                    switch (direccion) {
                        case (0):
                            if (yi > 0) {
                                yi--;
                            } else {
                                gameOver(idJugador, "Salida del tablero");
                            }
                            break;
                        case (1):
                            if (xi > 0) {
                                xi--;
                            } else {
                                gameOver(idJugador, "Salida del tablero");
                            }
                            break;
                        case (2):
                            if (yi < longitudY) {
                                yi++;
                            } else {
                                gameOver(idJugador, "Salida del tablero");
                            }
                            break;
                        case (3):
                            if (xf < longitudX) {
                                xi++;
                            } else {
                                gameOver(idJugador, "Salida del tablero");
                            }
                            break;
                    }
                    jugadores.get(idJugador).getSerpiente().addFirst(new Punto(xi, yi));
                    distancia(jugadores.get(idJugador).getIdCliente(), xi, yi, xf, yf);
                }
            }

            private boolean chocaContraJugador(int idJugador) {
                boolean chocar = false;
                for (Jugador j : jugadores) {
                    if (j.getIdCliente() != idJugador && !chocar) {
                        if (j.getSerpiente().contains(jugadores.get(idJugador).getSerpiente().getFirst())) {
                            chocar = true;
                        }
                    }
                }
                return chocar;
            }

            private void tesoroComido(int idJugador) throws IOException {
                if (tesoro.equals((Punto) jugadores.get(idJugador).getSerpiente().getFirst())) {
                    ModeloServidor.this.tesoroComido(1, idJugador);
                }
                if (tesoroTemporal.equals((Punto) jugadores.get(idJugador).getSerpiente().getFirst())) {
                    ModeloServidor.this.tesoroComido(2, idJugador);
                }
            }
        };
    }
}
