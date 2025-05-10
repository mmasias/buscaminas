package orozcoBeatriz;

import java.util.Random;

public class Tablero {
    private final int TAMANIO = 6;
    private final int MINAS = 6;
    private Celda[][] tablero;

    public Tablero() {
        tablero = new Celda[TAMANIO][TAMANIO];
        inicializar();
        colocarMinas();
    }

    public void inicializar() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                tablero[i][j] = new Celda();
            }
        }
    }

    public void colocarMinas() {
        Random rand = new Random();
        int colocadas = 0;
        while (colocadas < MINAS) {
            int f = rand.nextInt(TAMANIO);
            int c = rand.nextInt(TAMANIO);
            if (!tablero[f][c].tieneMina()) {
                tablero[f][c].tieneMina(true);
                colocadas++;
            }
        }
    }

    public void imprimir(boolean revelar) {
        System.out.println("\nBUSCAMINAS");
        System.out.print("  ");
        for (int i = 1; i <= TAMANIO; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < TAMANIO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANIO; j++) {
                Celda celda = tablero[i][j];
                if (celda.estaDescubierta() || revelar) {
                    if (celda.tieneMina()) System.out.print("* ");
                    else System.out.print("D ");
                } else if (celda.estaMarcada()) {
                    System.out.print("M ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public boolean coordenadaValida(int fila, int col) {
        return fila >= 0 && fila < TAMANIO && col >= 0 && col < TAMANIO;
    }

    public int contarMinasVecinas(int fila, int col) {
        int minas = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (coordenadaValida(i, j) && !(i == fila && j == col) && tablero[i][j].tieneMina()) {
                    minas++;
                }
            }
        }
        return minas;
    }

    public boolean verificarVictoria() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                if (!tablero[i][j].tieneMina() && !tablero[i][j].estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Celda getCelda(int fila, int col) {
        return tablero[fila][col];
    }
}
