package pakVanessa;

import java.util.Random;

public class Tablero {
    private char[][] casillas;
    private boolean[][] minas;
    private final int size = 6;
    private final int numMinas = 6;

    public Tablero() {
        casillas = new char[size][size];
        minas = new boolean[size][size];
        inicializarTablero();
        colocarMinas();
    }

    private void inicializarTablero() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                casillas[i][j] = '_';
                minas[i][j] = false;
            }
        }
    }

    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < numMinas) {
            int fila = rand.nextInt(size);
            int columna = rand.nextInt(size);
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }

    public boolean despejar(int fila, int columna) {
        if (!esCoordenadaValida(fila, columna)) {
            return true; 
        }

        if (casillas[fila][columna] == 'M' || casillas[fila][columna] == 'D') {
            return true; 
        }

        if (minas[fila][columna]) {
            casillas[fila][columna] = 'X'; 
            return false;
        }

        casillas[fila][columna] = 'D';
        return true;
    }

    public void marcar(int fila, int columna) {
        if (casillas[fila][columna] == 'M') {
            casillas[fila][columna] = '_';
        } else if (casillas[fila][columna] == '_') {
            casillas[fila][columna] = 'M';
        }
    }

    public boolean haGanado() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!minas[i][j] && casillas[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrar() {
        limpiarPantalla();
        System.out.println("  1 2 3 4 5 6");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(" " + casillas[i][j]);
            }
            System.out.println();
        }
    }

    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean esCoordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < size && columna >= 0 && columna < size;
    }
}
