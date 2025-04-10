package uretaAaron;

public class Jugador {

    public boolean despejar(Tablero tablero, int fila, int columna, char despejar) {
        return tablero.despejar(fila, columna, despejar);
    }

    public void marcar(Tablero tablero, int fila, int columna) {
        tablero.marcar(fila, columna);
    }
}
