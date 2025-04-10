package coboIsmael;

import java.util.Random;
public class Tablero {
    private final int TAMANO = 6;
    private final int NUM_MINAS = 6;

    private char[][] estado;
    private boolean[][] minas;

    private int casillasDespejadas;
    private boolean explotado;

    public Tablero() {
        estado = new char[TAMANO][TAMANO];
        minas = new boolean[TAMANO][TAMANO];
        casillasDespejadas = 0;
        explotado = false;
        inicializarTablero();
        colocarMinas();
    }

    private void inicializarTablero() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                estado[i][j] = '_';
            }
        }
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < NUM_MINAS) {
            int fila = random.nextInt(TAMANO);
            int columna = random.nextInt(TAMANO);
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }

    public void mostrar() {
        System.out.print("   ");
        for (int col = 1; col <= TAMANO; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int i = 0; i < TAMANO; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < TAMANO; j++) {
                System.out.print(estado[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void despejar(int fila, int columna) {
        if (fila < 0 || fila >= TAMANO || columna < 0 || columna >= TAMANO) {
            System.out.println("Coordenadas fuera de rango.");
            return;
        }
        if (estado[fila][columna] != '_') {
            System.out.println("Esta casilla ya está despejada o marcada.");
            return;
        }
        if (minas[fila][columna]) {
            estado[fila][columna] = '*';
            explotado = true;
        } else {
            estado[fila][columna] = 'D';
            casillasDespejadas++;
        }
    }

    public void marcar(int fila, int columna) {
        if (fila < 0 || fila >= TAMANO || columna < 0 || columna >= TAMANO) {
            System.out.println("Coordenadas fuera de rango.");
            return;
        }
        if (estado[fila][columna] == 'D') {
            System.out.println("Esta casilla ya fue despejada.");
            return;
        }
        if (estado[fila][columna] == 'M') {
            System.out.println("Esta casilla ya está marcada.");
            return;
        }
        estado[fila][columna] = 'M';
    }

    public boolean juegoTerminado() {
        return explotado || (casillasDespejadas == (TAMANO * TAMANO - NUM_MINAS));
    }

    public boolean gano() {
        return casillasDespejadas == (TAMANO * TAMANO - NUM_MINAS);
    }

    public boolean hayMina(int fila, int columna) {
        if (fila < 0 || fila >= TAMANO || columna < 0 || columna >= TAMANO) {
            return false;
        }
        return minas[fila][columna];
    }

    public void forzarDespeje(int fila, int columna) {
        if (fila < 0 || fila >= TAMANO || columna < 0 || columna >= TAMANO) {
            return;
        }
        if (estado[fila][columna] == '_') {
            estado[fila][columna] = 'D';
            casillasDespejadas++;
        }
    }
}