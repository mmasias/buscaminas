package zablahBernardo;

public class Tablero {

    private char[][] casillas;
    private final int DIMENSIONES = 6;
    private final int MINAS = 6;
    private boolean mostrarMinas = false;

    public Tablero() {
        casillas = new char[DIMENSIONES][DIMENSIONES];
        generarTablero(casillas);
        ponerMinas(casillas, MINAS);
    }

    private void ponerMinas(char[][] casillas, int minas) {
        int colocadas = 0;
        int fila = 0, columna = 0;

        while (colocadas < MINAS) {
            if (casillas[fila][columna] != '*') {
                casillas[fila][columna] = '*';
                colocadas++;
            }

            fila = (fila + 1) % DIMENSIONES;
            columna = (columna + 2) % DIMENSIONES;
        }
    }

    private void generarTablero(char[][] casillas) {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = '_';
            }
        }
    }

    public void mostrar() {
        cleanScreen();
        System.out.print("   ");
        for (int col = 0; col < DIMENSIONES; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int fila = 0; fila < DIMENSIONES; fila++) {
            System.out.print(fila + "  ");
            for (int col = 0; col < DIMENSIONES; col++) {
                char actual = casillas[fila][col];

                if (actual == '*' && !mostrarMinas) {
                    System.out.print("_ ");
                } else {
                    System.out.print(actual + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean despejado() {
        for (int i = 0; i < DIMENSIONES; i++) {
            for (int j = 0; j < DIMENSIONES; j++) {
                if (casillas[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    private void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean despejar(int fila, int columna) {
        if (casillas[fila][columna] == '*') {
            mostrarMinas = true;
            return false;
        }

        if (casillas[fila][columna] == '_') {
            casillas[fila][columna] = '0';
        }
        return true;
    }

    public void marcar(int fila, int columna) {
        if (casillas[fila][columna] == '_') {
            casillas[fila][columna] = 'F';
        } else if (casillas[fila][columna] == 'F') {
            casillas[fila][columna] = '_';
        } else if (casillas[fila][columna] == '*') {
            casillas[fila][columna] = 'F';
        }
    }

}
