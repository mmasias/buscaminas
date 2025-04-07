import java.util.Random;

public class Tablero {
    private final int FILAS = 6;
    private final int COLUMNAS = 6;
    private final int NUM_MINAS = 6;
    private Celda[][] celdas;

    public Tablero() {
        celdas = new Celda[FILAS][COLUMNAS];
        inicializarCeldas();
        colocarMinas();
    }

    private void inicializarCeldas() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int col = 0; col < COLUMNAS; col++) {
                celdas[fila][col] = new Celda();
            }
        }
    }

    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;

        while (minasColocadas < NUM_MINAS) {
            int fila = rand.nextInt(FILAS);
            int col = rand.nextInt(COLUMNAS);

            if (!celdas[fila][col].tieneMina()) {
                celdas[fila][col] = new Celda(true);
                minasColocadas++;
            }
        }
    }

    public boolean despejar(int fila, int columna) {
        fila--;
        columna--;
        if (esPosicionValida(fila, columna)) {
            Celda celda = celdas[fila][columna];
            celda.revelar();
            return !celda.tieneMina();
        }
        return true; // no pierde si es posición inválida
    }

    public void marcar(int fila, int columna) {
        fila--;
        columna--;
        if (esPosicionValida(fila, columna)) {
            celdas[fila][columna].marcar();
        }
    }

    public boolean haGanado() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int col = 0; col < COLUMNAS; col++) {
                Celda celda = celdas[fila][col];
                if (!celda.tieneMina() && !celda.estaRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrarTablero() {
        System.out.print("   ");
        for (int col = 1; col <= COLUMNAS; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int fila = 0; fila < FILAS; fila++) {
            System.out.print((fila + 1) + "  ");
            for (int col = 0; col < COLUMNAS; col++) {
                System.out.print(celdas[fila][col].mostrar() + " ");
            }
            System.out.println();
        }
    }

    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS;
    }
}