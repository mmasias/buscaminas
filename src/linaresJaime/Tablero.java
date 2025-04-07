package linaresJaime;

import java.util.Random;

public class Tablero {
    private final char[][] visible;
    private final boolean[][] minas;
    private final boolean[][] descubierto;
    private final int filas, columnas, totalMinas;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.totalMinas = minas;
        this.visible = new char[filas][columnas];
        this.minas = new boolean[filas][columnas];
        this.descubierto = new boolean[filas][columnas];
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                visible[i][j] = '_';

        Random rand = new Random();
        int colocadas = 0;
        while (colocadas < totalMinas) {
            int f = rand.nextInt(filas);
            int c = rand.nextInt(columnas);
            if (!minas[f][c]) {
                minas[f][c] = true;
                colocadas++;
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("BUSCAMINAS");
        System.out.print("  ");
        for (int c = 1; c <= columnas; c++) System.out.print(c + " ");
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(visible[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n[D]espejar o [M]arcar mina?");
    }

    public void mostrarTableroFinal() {
        System.out.println("BUSCAMINAS");
        System.out.print("  ");
        for (int c = 1; c <= columnas; c++) System.out.print(c + " ");
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < columnas; j++) {
                if (minas[i][j]) {
                    System.out.print("* ");
                } else if (descubierto[i][j]) {
                    System.out.print("D ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public boolean despejar(int fila, int col) {
        if (minas[fila][col]) {
            return false;
        }
        descubierto[fila][col] = true;
        visible[fila][col] = 'D';
        return true;
    }

    public void marcar(int fila, int col) {
        visible[fila][col] = 'M';
    }

    public boolean juegoGanado() {
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                if (!minas[i][j] && !descubierto[i][j])
                    return false;
        return true;
    }
}
