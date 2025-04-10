package puenteSergio;

import java.util.Random;

class CampoMinado {

    private final int FILAS = 6;
    private final int COLUMNAS = 6;
    private final int TOTAL_MINAS = 6;
    private final char VACIO = '_';
    private final char MINA = 'X';
    private final char LIMPIO = 'O';

    private char[][] mapa;
    private boolean[][] descubiertas;

    public CampoMinado() {
        mapa = new char[FILAS][COLUMNAS];
        descubiertas = new boolean[FILAS][COLUMNAS];
        prepararCampo();
        sembrarExplosivos();
    }

    private void prepararCampo() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int col = 0; col < COLUMNAS; col++) {
                mapa[fila][col] = VACIO;
                descubiertas[fila][col] = false;
            }
        }
    }

    private void sembrarExplosivos() {
        Random rng = new Random();
        int colocadas = 0;

        while (colocadas < TOTAL_MINAS) {
            int f = rng.nextInt(FILAS);
            int c = rng.nextInt(COLUMNAS);

            if (mapa[f][c] != MINA) {
                mapa[f][c] = MINA;
                colocadas++;
            }
        }
    }

    public void mostrarCampo(boolean revelarMinas) {
        System.out.print("   ");
        for (int i = 1; i <= COLUMNAS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int fila = 0; fila < FILAS; fila++) {
            System.out.print((fila + 1) + "  ");
            for (int col = 0; col < COLUMNAS; col++) {
                if (descubiertas[fila][col]) {
                    System.out.print(mapa[fila][col] + " ");
                } else if (revelarMinas && mapa[fila][col] == MINA) {
                    System.out.print(MINA + " ");
                } else {
                    System.out.print(VACIO + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean juegoFinalizado() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int col = 0; col < COLUMNAS; col++) {
                if (mapa[fila][col] != MINA && !descubiertas[fila][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hayMinaEn(int fila, int columna) {
        return mapa[fila][columna] == MINA;
    }

    public void revelarCasilla(int fila, int columna) {
        if (esValida(fila, columna) && !descubiertas[fila][columna]) {
            descubiertas[fila][columna] = true;
            mapa[fila][columna] = LIMPIO;
        }
    }

    public boolean esValida(int fila, int columna) {
        return fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS;
    }

    public void revelarMina(int fila, int columna) {
        descubiertas[fila][columna] = true;
        mapa[fila][columna] = MINA;
    }
    
    public void macroDespejar(int fila, int columna) {
    for (int dx = -1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
            if (dx == 0 && dy == 0) continue;

            int nuevaFila = fila + dx;
            int nuevaCol = columna + dy;

            if (enRango(nuevaFila, nuevaCol)) {
                Casilla c = tablero[nuevaFila][nuevaCol];
                if (!c.estaMarcada() && !c.estaRevelada()) {
                    c.revelar();
                }
            }
        }
    }
}

private boolean enRango(int f, int c) {
    return f >= 0 && f < tablero.length && c >= 0 && c < tablero[0].length;
}

}
