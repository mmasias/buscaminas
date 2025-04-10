package uretaAaron;

import java.util.Random;

public class Tablero {
    public char[][] casillas;
    private boolean[][] minas;
    private int size = 6;
    private int numMinas = 6;

    public Tablero() {}

    public void asignarTablero(int size) {
        this.size = size;
        casillas = new char[size][size];
        minas = new boolean[size][size];
        inicializarTablero();
    }

    public void asignarNumMinas(int numMinas) {
        this.numMinas = numMinas;
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
        int colocadas = 0;
        while (colocadas < numMinas) {
            int fila = rand.nextInt(size);
            int columna = rand.nextInt(size);
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                colocadas++;
            }
        }
    }

    public boolean despejar(int fila, int columna, char modo) {
        if (modo == 'P') {
            despejarCasilla(fila, columna);
            return !minas[fila][columna];
        } else if (modo == 'C') {
            despejarCuadrado(fila, columna);
            return !comprobacion();
        } else if (modo == 'X') {
            macroDespeje(fila, columna);
            return !comprobacion();
        }
        return true;
    }

    private void despejarCasilla(int fila, int columna) {
        if (fila >= 0 && fila < size && columna >= 0 && columna < size) {
            casillas[fila][columna] = 'D';
        }
    }

    private void despejarCuadrado(int fila, int columna) {
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                despejarCasilla(i, j);
            }
        }
    }

    private void macroDespeje(int fila, int columna) {
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < size && j >= 0 && j < size && casillas[i][j] != 'M') {
                    casillas[i][j] = 'D';
                }
            }
        }
    }

    private boolean comprobacion() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (minas[i][j] && casillas[i][j] == 'D') {
                    return true;
                }
            }
        }
        return false;
    }

    public void marcar(int fila, int columna) {
        if (casillas[fila][columna] == 'M') {
            casillas[fila][columna] = '_';
        } else {
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

    public void revelarTodo() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (minas[i][j]) {
                    casillas[i][j] = '*';
                }
            }
        }
    }

    public void mostrar() {
        System.out.print("   ");
        for (int j = 0; j < size; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < size; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
    }
}
