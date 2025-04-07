import java.util.Random;

public class Tablero {
    private Celda[][] tablero;
    private final int totalFilas = 6;
    private final int totalColumnas = 6;
    private final int totalMinas = 6;

    public Tablero() {
        tablero = new Celda[totalFilas][totalColumnas];
        for (int fila = 0; fila < totalFilas; fila++) {
            for (int columna = 0; columna < totalColumnas; columna++) {
                tablero[fila][columna] = new Celda();
            }
        }
        colocarMinasAleatoriamente();
    }

    private void colocarMinasAleatoriamente() {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < totalMinas) {
            int fila = random.nextInt(totalFilas);
            int columna = random.nextInt(totalColumnas);
            if (!tablero[fila][columna].tieneMina()) {
                tablero[fila][columna].ponerMina();
                minasColocadas++;
            }
        }
    }


    public boolean despejarCasilla(int fila, int columna) {
        if (tablero[fila][columna].casillaRevelada() || tablero[fila][columna].casillaMarcada()) {
            return true;
        }

        tablero[fila][columna].revelar();
        return !tablero[fila][columna].tieneMina();
    }

    public int obtenerFilas() {
        return totalFilas;
    }

    public int obtenerColumnas() {
        return totalColumnas;
    }

    public void marcarCasilla(int fila, int columna) {
        if (!tablero[fila][columna].casillaRevelada()) {
            tablero[fila][columna].alternarMarca();
        }
    }



    public void mostrarTablero() {
        System.out.println("  ");
        System.out.println("BUSCAMINAS");
        for (int i = 1; i <= totalColumnas; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int fila = 0; fila < totalFilas; fila++) {
            System.out.print((fila + 1) + " ");
            for (int columna = 0; columna < totalColumnas; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }
        System.out.println("  ");
    }

    private boolean enRango(int fila, int columna) {
        return fila >= 0 && fila < totalFilas && columna >= 0 && columna < totalColumnas;
    }

    public boolean jugadorGano() {
        for (int fila = 0; fila < totalFilas; fila++) {
            for (int columna = 0; columna < totalColumnas; columna++) {
                if (!tablero[fila][columna].tieneMina() && !tablero[fila][columna].casillaRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }
}
