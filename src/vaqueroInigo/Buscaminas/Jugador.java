package vaqueroInigo.Buscaminas;

public class Jugador {
    public boolean despejar(Tablero tablero, int fila, int columna) {
        return tablero.despejar(fila, columna);
    }

    public void marcar(Tablero tablero, int fila, int columna) {
        tablero.marcar(fila, columna);
    }

}
