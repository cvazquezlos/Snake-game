package servidor;

/**
 * Representa regiones del tablero.
 *
 * @author c.vazquezlos
 */
public class Punto {

    private int x;
    private int y;

    /**
     * Constructor por defecto.
     */
    public Punto() {
        this(0, 0);
    }

    /**
     * Constructor con parámetros para la localización.
     *
     * @param x
     * @param y
     */
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getCoordenadaX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getCoordenadaY() {
        return y;
    }

    /**
     *
     * @param x
     */
    public void setCoordenadaX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setCoordenadaY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.x;
        hash = 41 * hash + this.y;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Punto other = (Punto) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}
