package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa la hebra del servidor, que escucha a los clientes.
 * @author c.vazquezlos
 */
public class HebraServidor extends Thread {

    private Socket socket;
    private int idClient;
    private BufferedReader streamIn;
    private boolean fin;
    private ModeloServidor modeloServidor;

    /**
     * Constructor de la hebra del servidor.
     * @param socket
     * @param idClient
     * @param modelo
     */
    public HebraServidor(Socket socket, int idClient, ModeloServidor modelo) {
        this.socket=socket;
        this.idClient=idClient;
        this.fin=true;
        this.modeloServidor=modelo;
    }

    /**
     * Detiene el funcionamiento.
     */
    public void parar(){
        fin=false;
    }

    /**
     * Redefine el método run() debido a que hereda de Thread.
     */
    @Override
    public void run() {
        try {
            // Creamos los streams para la lectura y escritura de objetos a traves de la conexion
            streamIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje;
            // Hasta que no se indique que pare, itera
            while (fin) {
                // Escuchamos el mensaje enviado por el socket del cliente
                mensaje=streamIn.readLine();
                // Fragmentamos el contenido del mensaje
                String[] contenidos=mensaje.split(";");
                // Mostramos el mensaje por consola para comprobar que se ha recibido correctamente
                System.out.println("del cliente: "+mensaje);
                String cabecera=contenidos[0];
                switch (cabecera){
                    case ("CON"):
                        // Se conecta con el cliente
                        modeloServidor.conecta(idClient);
                        break;
                    case ("DIR"):
                        // Cambia la dirección del Modelo
                        modeloServidor.cambiarDireccion(contenidos[1], idClient);
                        break;
                    case ("FIN"):
                        try {
                            // Si ha recibido un FIN, entonces ordena el corte de conexión con el cliente
                            modeloServidor.finalizaConexion();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(HebraServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HebraServidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                streamIn.close();
            } catch (IOException ex) {
                Logger.getLogger(HebraServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
