package gonzalezMarcos;

public class Tablero {
    private final int FILAS = 6;
    private final int COLUMNAS = 6;
    private final int NUM_MINAS = 6;
    private Celda[][] celdas;

    public Tablero() {
        celdas = new Celda[FILAS][COLUMNAS];
        inicializarCeldas();
        colocarMinasSinRandom();
    }

    private void inicializarCeldas() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                celdas[fila][columna] = new Celda();
            }
        }
    }

    private void colocarMinasSinRandom() {
        int total = FILAS * COLUMNAS;
        int[] posiciones = new int[total];
        for (int i = 0; i < total; i++) {
            posiciones[i] = i;
        }

        for (int i = 0; i < total - 1; i++) {
            int j = (i * 3 + 7) % total; 
            int temp = posiciones[i];
            posiciones[i] = posiciones[j];
            posiciones[j] = temp;
        }

        for (int i = 0; i < NUM_MINAS; i++) {
            int posicion = posiciones[i];
            int fila = posicion / COLUMNAS;
            int columna = posicion % COLUMNAS;
            celdas[fila][columna] = new Celda(true);
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
        return true;
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
            for (int columna = 0; columna < COLUMNAS; columna++) {
                Celda celda = celdas[fila][columna];
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