package coboIsmael;

import java.util.Random;

public class Tablero {

    private String[][] casillas;
    private boolean[][] minas;
    private boolean juegoTerminado;
    private int casillasDespejadas;

    public Tablero() {
        casillas = new String[6][6]; 
        minas = new boolean[6][6];   
        juegoTerminado = false;
        casillasDespejadas = 0;

        inicializarTablero();
        colocarMinas();
    }

    private void inicializarTablero() {
        for (int fila = 0; fila < 6; fila++) {
            for (int col = 0; col < 6; col++) {
                casillas[fila][col] = "_";
                minas[fila][col] = false;
            }
        }
    }

    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;

        while (minasColocadas < 6) {
            int fila = rand.nextInt(6);
            int col = rand.nextInt(6);
            if (!minas[fila][col]) {
                minas[fila][col] = true;
                minasColocadas++;
            }
        }
    }

    public void mostrar() {
        System.out.println("\nBUSCAMINAS");
        System.out.println("  1 2 3 4 5 6");
        for (int fila = 0; fila < 6; fila++) {
            System.out.print((fila + 1) + " ");
            for (int col = 0; col < 6; col++) {
                System.out.print(casillas[fila][col] + " ");
            }
            System.out.println();
        }
    }

    public void despejar(int fila, int col) {
        if (!casillas[fila][col].equals("_")) return;

        if (minas[fila][col]) {
            casillas[fila][col] = "X";  
            juegoTerminado = true;
        } else {
            casillas[fila][col] = "D";
            casillasDespejadas++;
        }
    }

    public void marcar(int fila, int col) {
        if (casillas[fila][col].equals("_")) {
            casillas[fila][col] = "M";
        }
    }

    public boolean juegoTerminado() {
        return juegoTerminado || casillasDespejadas == (36 - 6);
    }

    public boolean gano() {
        return casillasDespejadas == (36 - 6);
    }
}
