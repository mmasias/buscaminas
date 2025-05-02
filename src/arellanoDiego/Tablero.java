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
        minas = new int[MINAS_INICIALES][2];
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
            boolean minaExistente = false;
            
            int i = 0;
            while (i < minasColocadas && !minaExistente) {
                if (minas[i][0] == fila && minas[i][1] == columna) {
                    minaExistente = true;
                }
                i++;
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
        boolean encontrada = false;
        int i = 0;
        
        while (i < MINAS_INICIALES && !encontrada) {
            if (minas[i][0] == fila && minas[i][1] == columna) {
                encontrada = true;
            }
            i++;
        }
        return encontrada;
    }

    public void despejarCasilla(int fila, int columna) {
        if (casillas[fila][columna] == VACIA) {
            casillas[fila][columna] = DESPEJADA;
        }
    }

    public boolean macroDespejar(int fila, int columna) {
        boolean minaEncontrada = false;
        int inicioFila = Math.max(0, fila - 1);
        int finFila = Math.min(DIMENSION - 1, fila + 1);
        int inicioCol = Math.max(0, columna - 1);
        int finCol = Math.min(DIMENSION - 1, columna + 1);
        
        for (int i = inicioFila; i <= finFila && !minaEncontrada; i++) {
            for (int j = inicioCol; j <= finCol && !minaEncontrada; j++) {
                if (i != fila || j != columna) {
                    if (hayMina(i, j)) {
                        minaEncontrada = true;
                        casillas[i][j] = MINA;
                    } else if (casillas[i][j] == VACIA) {
                        casillas[i][j] = DESPEJADA;
                    }
                }
            }
        }
        
        if (minaEncontrada) {
            System.out.println("¡BOOM! Has encontrado una mina al macrodespejar. Juego terminado.");
        } else {
            System.out.println("Macrodespeje realizado con éxito.");
        }
        
        return minaEncontrada;
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