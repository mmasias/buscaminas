package solarAdrian;

import java.util.Random;

public class Tablero {

    private final int filas = 6;
    private final int columnas = 6;
    private final int totalMinas = 6;

    private final char CASILLA_OCULTA = '_';
    private final char MARCA = 'M';
    private final char MINA = '*';
    private final char CASILLA_LIBRE = 'D';

    private char[][] matrizTablero;
    private boolean revelarMinas = false;

    public Tablero() {
        matrizTablero = new char[filas][columnas];
        inicializar();
        colocarMinas();
    }

    private void inicializar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizTablero[i][j] = CASILLA_OCULTA;
            }
        }
    }

    private void colocarMinas() {
        Random aleatorio = new Random();
        int minasActuales = 0;

        while (minasActuales < totalMinas) {
            int f = aleatorio.nextInt(filas);
            int c = aleatorio.nextInt(columnas);

            if (matrizTablero[f][c] != MINA) {
                matrizTablero[f][c] = MINA;
                minasActuales++;
            }
        }
    }

    public void mostrarTablero() {
        System.out.print("    ");
        for (int c = 1; c <= columnas; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (int f = 0; f < filas; f++) {
            System.out.print((f + 1) + "   ");
            for (int c = 0; c < columnas; c++) {
                char actual = matrizTablero[f][c];

                if (actual == MINA && !revelarMinas) {
                    System.out.print(CASILLA_OCULTA + " ");
                } else if (actual == MINA && revelarMinas) {
                    System.out.print(MINA + " ");
                } else {
                    System.out.print(actual + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean despejarCasilla(int f, int c) {
        if (matrizTablero[f - 1][c - 1] == MINA) {
            revelarMinas = true;
            return false;
        }

        if (matrizTablero[f - 1][c - 1] == CASILLA_OCULTA) {
            matrizTablero[f - 1][c - 1] = CASILLA_LIBRE;
        }

        return true;
    }

    public void alternarBandera(int f, int c) {
        if (matrizTablero[f - 1][c - 1] == CASILLA_OCULTA) {
            matrizTablero[f - 1][c - 1] = MARCA;
        } else if (matrizTablero[f - 1][c - 1] == MARCA) {
            matrizTablero[f - 1][c - 1] = CASILLA_OCULTA;
        }
    }

    public boolean juegoCompletado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                char celda = matrizTablero[i][j];
                if ((celda == CASILLA_OCULTA || celda == MARCA) && celda != MINA) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean coordenadaValida(int f, int c) {
        return f >= 1 && f <= filas && c >= 1 && c <= columnas;
    }

    public boolean usarBomba(int f, int c) {
        if (!coordenadaValida(f, c)) {
            System.out.println("Coordenada inválida. Intente nuevamente.");
            return false;
        }

        boolean seguirJugando = true;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int filaAdj = f + i;
                int colAdj = c + j;

                if (coordenadaValida(filaAdj, colAdj)) {
                    char celda = matrizTablero[filaAdj - 1][colAdj - 1];

                    if (celda == MARCA) continue;

                    if (!despejarCasilla(filaAdj, colAdj)) {
                        seguirJugando = false;
                    }
                }
            }
        }

        return seguirJugando;
    }
}
