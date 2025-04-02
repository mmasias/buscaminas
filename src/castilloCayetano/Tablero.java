package castilloCayetano;

import java.util.Random;

public class Tablero {
    private int[][] tablero;
    private boolean[][] revelado;
    private boolean[][] marcado;
    private int filas;
    private int columnas;
    private int minas;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.tablero = new int[filas][columnas];
        this.revelado = new boolean[filas][columnas];
        this.marcado = new boolean[filas][columnas];
        inicializarTablero();
        colocarMinas();
        calcularNumeros();
    }

    public void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = 0;
                revelado[i][j] = false;
                marcado[i][j] = false;
            }
        }
    }

    public void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < minas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            if (tablero[fila][columna] != -1) {
                tablero[fila][columna] = -1;
                minasColocadas++;
            }
        }
    }

    public void calcularNumeros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == -1)
                    continue;
                tablero[i][j] = contarMinasAdyacentes(i, j);
            }
        }
    }

    private int contarMinasAdyacentes(int fila, int columna) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (esPosicionValida(nuevaFila, nuevaColumna) && tablero[nuevaFila][nuevaColumna] == -1) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public void mostrar(boolean revelarMinas) {

        System.out.print("  ");
        for (int j = 0; j < columnas; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < columnas; j++) {
                if (revelarMinas && tablero[i][j] == -1) {
                    System.out.print("* ");
                } else if (marcado[i][j]) {
                    System.out.print("M ");
                } else if (!revelado[i][j]) {
                    System.out.print("- ");
                } else if (tablero[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean revelarCelda(int fila, int columna) {
        if (!esPosicionValida(fila, columna) || revelado[fila][columna] || marcado[fila][columna]) {
            return false;
        }
        revelado[fila][columna] = true;
        if (tablero[fila][columna] == -1) {
            return true;
        }
        if (tablero[fila][columna] == 0) {
            revelarAdyacentes(fila, columna);
        }
        return false;
    }

    public void marcarCelda(int fila, int columna) {
        if (esPosicionValida(fila, columna) && !revelado[fila][columna]) {
            marcado[fila][columna] = !marcado[fila][columna];
        }
    }

    private void revelarAdyacentes(int fila, int columna) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (esPosicionValida(nuevaFila, nuevaColumna) && !revelado[nuevaFila][nuevaColumna]
                        && tablero[nuevaFila][nuevaColumna] != -1) {
                    revelarCelda(nuevaFila, nuevaColumna);
                }
            }
        }
    }

    public boolean despejado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] != -1 && !revelado[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}