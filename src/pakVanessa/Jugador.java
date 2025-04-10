package pakVanessa;

public class Jugador {

    public boolean despejar(Tablero tablero, int fila, int columna) {
        return tablero.despejar(fila, columna);
    }

    public void marcar(Tablero tablero, int fila, int columna) {
        tablero.marcar(fila, columna);
    }

    public void superDespejar(Tablero tablero, int fila, int columna) {
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (tablero.esCoordenadaValida(i, j)) {
                    tablero.despejar(i, j);
                }
            }
        }
    }
}
