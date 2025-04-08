package buscaminas.src.vaqueroSara;

import java.util.Random;

public class Tablero {

    private Casilla[][] tablero;
    private int filas;
    private int columnas;
    private int minas;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.tablero = new Casilla[filas][columnas];
    }

    for (int i = 0;
    i< filas ;
    i
        

    ++) {
        for (int j = 0; j < columnas; j++) {
            tablero[i][j] = new Casilla();
        }
    }

    colocarMinas();

    calcularMinasAdyacentes();

    private void colocarMinas() {

        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < minas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            if (!tablero[fila][columna].tieneMina()) {
                tablero[fila][columna].ponerMina();
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAdyacentes() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!tablero[i][j].tieneMina()) {
                    int minasAdyacentes = contarMinasAdyacentes(i, j);
                    tablero[i][j].setMinasAdyacentes(minasAdyacentes);
                }
            }
        }
    }

}
