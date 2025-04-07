package arellanoDiego;

import java.util.Random;

public class Tablero {
    public static final int DIMENSION = 6; 
    private static final int MINAS_INICIALES = 6;
    private static final char VACIA = '_';
    private static final char MINA = 'M';
    private static final char DESPEJADA = 'D';
    private char[][] casillas;
    private int[][] minas;

    public Tablero() {
        casillas = new char[DIMENSION][DIMENSION];
        minas = new int[MINAS_INICIALES][2]; // [minas][coordenadas]
        generarTablero();
        ponerMinas();
    }

    private void generarTablero() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                casillas[i][j] = VACIA;
            }
        }
    }

    private void ponerMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        
        while (minasColocadas < MINAS_INICIALES) {
            int fila = rand.nextInt(DIMENSION);
            int columna = rand.nextInt(DIMENSION);
            
            // Verificar que no haya mina ya en esta posición
            boolean minaExistente = false;
            for (int i = 0; i < minasColocadas; i++) {
                if (minas[i][0] == fila && minas[i][1] == columna) {
                    minaExistente = true;
                    break;
                }
            }
            
            if (!minaExistente) {
                minas[minasColocadas][0] = fila;
                minas[minasColocadas][1] = columna;
                minasColocadas++;
            }
        }
    }

    public void mostrar() {
        System.out.print("  ");
        for (int i = 0; i < DIMENSION; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        
        for (int i = 0; i < DIMENSION; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean hayMina(int fila, int columna) {
        for (int[] mina : minas) {
            if (mina[0] == fila && mina[1] == columna) {
                return true;
            }
        }
        return false;
    }

    public void despejarCasilla(int fila, int columna) {
        if (casillas[fila][columna] == VACIA) {
            casillas[fila][columna] = DESPEJADA;
        }
    }

    public boolean resuelto() {
        int casillasDespejadas = 0;
        int casillasSeguras = DIMENSION * DIMENSION - MINAS_INICIALES;
        
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (casillas[i][j] == DESPEJADA) {
                    casillasDespejadas++;
                }
            }
        }
        
        return casillasDespejadas == casillasSeguras;
    }
}