import java.io.InputStream;

public class Jugador {
    private final String nombre;

    public Jugador(InputStream in) {
        this.nombre = in;
    }

    public String getNombre() {
        return nombre;
    }
}
