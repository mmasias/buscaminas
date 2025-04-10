package arceMarina;

import java.util.Random;

class Tablero {

    private final int NUM_FILAS = 6;
    private final int NUM_COLUMNAS = 6;
    private final int NUM_MINAS = 6;
    private final char CASILLA_VACIA = '_';
    private final char MINA = 'M';
    private final char DESPEJADA = 'D';
    private char[][] casillas;
    private boolean[][] reveladas; 

    public Tablero() {
        casillas = new char[NUM_FILAS][NUM_COLUMNAS];
        reveladas = new boolean[NUM_FILAS][NUM_COLUMNAS]; 
        inicializarTablero();
        colocarMinas();
    }

    private void inicializarTablero() {
        for (int i = 0; i < NUM_FILAS; i++) {
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                casillas[i][j] = CASILLA_VACIA; 
                reveladas[i][j] = false;
            }
        }
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < NUM_MINAS) {
            int fila = random.nextInt(NUM_FILAS);
            int columna = random.nextInt(NUM_COLUMNAS);

            if (casillas[fila][columna] != MINA) {
                casillas[fila][columna] = MINA; 
                minasColocadas++;
            }
        }
    }

    public void mostrarTablero(boolean mostrarMinas) {
        System.out.print("  ");
        for (int i = 1; i <= NUM_COLUMNAS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < NUM_FILAS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                if (reveladas[i][j]) {
                    System.out.print(casillas[i][j] + " "); 
                } else if (mostrarMinas && casillas[i][j] == MINA) {
                    System.out.print(MINA + " "); 
                } else {
                    System.out.print(CASILLA_VACIA + " "); 
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean juegoTerminado() {
        for (int i = 0; i < NUM_FILAS; i++) {
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                if (casillas[i][j] != MINA && !reveladas[i][j]) {
                    return false; 
                }
            }
        }
        return true; 
    }

    public boolean esMina(int fila, int columna) {
        return casillas[fila][columna] == MINA;
    }

    public void despejarCasilla(int fila, int columna) {
        if (coordenadaValida(fila, columna) && !reveladas[fila][columna]) {
            reveladas[fila][columna] = true; 
            casillas[fila][columna] = DESPEJADA;

            if (casillas[fila][columna] == CASILLA_VACIA) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        despejarCasilla(fila + i, columna + j);
                    }
                }
            }
        }
    }

    public boolean coordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < NUM_FILAS && columna >= 0 && columna < NUM_COLUMNAS; 
    }

    public void mostrarMina(int fila, int columna) {
        reveladas[fila][columna] = true;
        casillas[fila][columna] = MINA;
    }
}
