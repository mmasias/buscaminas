package orejaPaula;

import java.util.Random;
public class Tablero {
    private final int filas;
    private final int columnas;
    private final int minas;
    private final Celda[][] cuadricula;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.cuadricula = new Celda[filas][columnas];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cuadricula[i][j] = new Celda();
            }
        }
    }
}
private void colocarMinas() {
    Random rand = new Random();
    int minasColocadas = 0;
    while (minasColocadas < minas) {
        int r = rand.nextInt(filas);
        int c = rand.nextInt(columnas);
        if (!cuadricula[r][c].esMina) {
            cuadricula[r][c].esMina = true;
            minasColocadas++;
        }
    }
}


