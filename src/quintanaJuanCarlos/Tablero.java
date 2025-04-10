package quintanaJuanCarlos;

import java.util.Random;

public class Tablero {

    private char[][] casillas;
    private boolean[][] minas;
    private int size = 2;
    private int numMinas = 0;

    public Tablero() {
    }

    public void asignarTablero(int num) {
        this.size = num;
        casillas = new char[size][size];
        minas = new boolean[size][size];
        inicializarTablero();
    }

    public void asignarNumMinas(int num) {
        this.numMinas = num;
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

    public boolean despejar(int fila, int columna, char despejar) {

        if (despejar == 'P') {
            despejarCasilla(casillas, fila, columna);

            if (minas[fila][columna]) {
                return false;
            }

            return true;

        } else if (despejar == 'C') {

            despejarCasilla(casillas, fila, columna);
            despejarCasilla(casillas, fila, columna - 1);
            despejarCasilla(casillas, fila, columna + 1);
            despejarCasilla(casillas, fila + 1, columna - 1);
            despejarCasilla(casillas, fila + 1, columna + 1);
            despejarCasilla(casillas, fila + 1, columna);
            despejarCasilla(casillas, fila - 1, columna - 1);
            despejarCasilla(casillas, fila - 1, columna + 1);
            despejarCasilla(casillas, fila - 1, columna);

            if (comprobaccion(casillas, minas)) {
                return false;
            } else {
                return true;
            }

        }
        return false;

    }

    void despejarCasilla(char[][] casillas, int fila, int columna) {
        int alto = casillas.length;
        int ancho = casillas[0].length;

        if (fila >= 0 && fila < alto && columna >= 0 && columna < ancho) {
            casillas[fila][columna] = 'D';
        }
    }

    public boolean comprobaccion(char[][] casillas, boolean[][] minas) {

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (minas[i][j] && casillas[i][j] == 'D') {
                    System.out.println("Casilla descubierta con X en [" + i + "][" + j + "]");
                    return true;
                }
            }
        }
        return false;
    }

    public void marcar(int fila, int columna) {
        casillas[fila][columna] = casillas[fila][columna] == 'M' ? '_' : 'M';
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

        int filas = casillas.length;
        int columnas = casillas[0].length;

        // Mostrar encabezado de columnas
        System.out.print("   "); // espacio para alinear con números de fila
        for (int j = 0; j < columnas; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        // Mostrar filas con contenido
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " "); // número de fila
            if (i + 1 < 10) {
                System.out.print(" "); // alineación si hay más de 9 filas

            }
            for (int j = 0; j < columnas; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
