package zablahBernardo;

public class Tablero {

    private char[][] casillas;
    private final int DIMENSIONES = 6;
    private final int MINAS = 6;

    public Tablero() {
        casillas = new char[DIMENSIONES][DIMENSIONES];
        generarTablero(casillas);
        ponerMinas(casillas, MINAS);

    }

    private void ponerMinas(char[][] casillas2, int mINAS2) {
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
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(" " + casillas[i][j]);
            }
            System.out.println();
        }

    }

    public boolean despejado() {

        return false;
    }

    private void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean descubrir(int fila, int columna) {
        if (casillas[fila][columna] == '*') {
            return false; 
        } else {
            casillas[fila][columna] = '0'; 
            return true;
        }
    }

}
