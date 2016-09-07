package cliente;

/**
 * Permite lanzar el snake en el cliente. Habrá tantos snake como clientes en el
 * servidor.
 *
 * @author c.vazquezlos
 */
public class SnakeCliente {

    /**
     * Método lanzador de la parte del cliente.
     *
     * @param args
     */
    public static void main(String[] args) {
        ModeloVistas vista = new ModeloVistas();
        vista.iniciar();
    }
}
