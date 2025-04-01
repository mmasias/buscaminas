package lianoJavier;

public class Buscaminas {

    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        final int DIMENSIONES = 6;
        final int MINAS_INICIALES = 6;

        tablero = new Tablero(DIMENSIONES, MINAS_INICIALES);
        jugador = new Jugador();
    }

    public void jugar() {
        tablero.mostrar();
        do {
            jugador.jugar(tablero);
            tablero.mostrar();
        } while (!tablero.resuelto() && jugador.vivo());
    }
}
