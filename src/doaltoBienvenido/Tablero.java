package doaltoBienvenido;

import java.util.Random;

class Tablero {

    private final int NUM_FILAS = 6;
    private final int NUM_COLUMNAS = 6;
    private final int NUM_MINAS = 6;
    private final char CASILLA_VACIA = '_';
    private final char MINA = 'M';
    private final char DESPEJADA = 'D';
    private char casillas[][];

    public Tablero() {
        casillas = new char[NUM_FILAS][NUM_COLUMNAS];
        generarTablero(casillas);
        ponerMinasTablero(casillas, NUM_MINAS);

    }

    private void ponerMinasTablero(char[][] casillas, int nUM_MINAS) {
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

    private void generarTablero(char[][] casillas) {

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(CASILLA_VACIA);
            }
            System.out.println();
        }
    }

    public void mostrar() {
        for (int i = 1; i <= NUM_COLUMNAS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < NUM_FILAS; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                if (casillas[i][j] == MINA) {
                    System.out.print(CASILLA_VACIA);  
                } else {
                    System.out.print(casillas[i][j] + CASILLA_VACIA);
                }
            }
            System.out.println();
        }
    }

    public boolean finalizado() {
        for (int i = 0; i < NUM_FILAS; i++) {
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                if (casillas[i][j] != MINA && casillas[i][j] != DESPEJADA) {
                    return false; 
                }
            }
        }
        return true;
    }
}
