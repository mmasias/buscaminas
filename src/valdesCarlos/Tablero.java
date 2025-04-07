package valdesCarlos;

import java.util.Random;

public class Tablero {

    private Celda[][] celdas;
    private final int TAMANIO = 6;
    private final int MINAS = 6;

    public Tablero() {
        celdas = new Celda[TAMANIO][TAMANIO];
        inicializarTablero();
        colocarMinas();
        calcularNumeros();
    }

    private void inicializarTablero() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;

        while (minasColocadas < MINAS) {
            int fila = rand.nextInt(TAMANIO);
            int columna = rand.nextInt(TAMANIO);

            if (!celdas[fila][columna].tieneMina()) {
                celdas[fila][columna].ponerMina();
                minasColocadas++;
            }
        }
    }

    private void calcularNumeros() {
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                if (!celdas[i][j].tieneMina()) {
                    int minasCerca = contarMinasAlrededor(i, j);
                    celdas[i][j].setNumeroAlrededor(minasCerca);
                }
            }
        }
    }

    private int contarMinasAlrededor(int fila, int col) {
        int minas = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < TAMANIO && j >= 0 && j < TAMANIO) {
                    if (celdas[i][j].tieneMina()) {
                        minas++;
                    }
                }
            }
        }
        return minas;
    }

    public void mostrar() {
        System.out.println("BUSCAMINAS");
        System.out.print("  ");
        for (int i = 1; i <= TAMANIO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < TAMANIO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANIO; j++) {
                Celda celda = celdas[i][j];
                if (celda.estaMarcada()) {
                    System.out.print("M ");
                } else if (!celda.estaRevelada()) {
                    System.out.print("_ ");
                } else if (celda.tieneMina()) {
                    System.out.print("* ");
                } else if (celda.getNumeroAlrededor() == 0) {
                    System.out.print("D ");
                } else {
                    System.out.print(celda.getNumeroAlrededor() + " ");
                }
            }
            System.out.println();
        }
    }
}
