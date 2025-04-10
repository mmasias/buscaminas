package morenoSara;

import java.util.Random;

class Tablero {

    private char[][] casillas;
    private boolean[][] minas;
    private boolean[][] reveladas;
    private boolean[][] marcadas;

    public Tablero() {
        casillas = new char[6][6];
        minas = new boolean[6][6];
        reveladas = new boolean[6][6];
        marcadas = new boolean[6][6];

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = '_';
                minas[i][j] = false;
                reveladas[i][j] = false;
                marcadas[i][j] = false;
            }
        }

        colocarMinas();
    }

    private void colocarMinas() {
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int fila = random.nextInt(6);
            int columna = random.nextInt(6);
            minas[fila][columna] = true;
        }
    }

    public void mostrar() {
        System.out.println("BUSCAMINAS");
        System.out.print("  ");
        for (int i = 0; i < 6; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < casillas.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < casillas[i].length; j++) {
                if (reveladas[i][j]) {
                    casillas[i][j] = minas[i][j] ? 'X' : 'D'; 
                } else if (marcadas[i][j]) {
                    casillas[i][j] = 'M';  
                } else {
                    casillas[i][j] = '_';  
                }
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean despejar(Coordenada coordenada) {
        int fila = coordenada.getFila() - 1;
        int columna = coordenada.getColumna() - 1;

        if (minas[fila][columna]) {
            return false;  
            reveladas[fila][columna] = true;  
            return true;
        }
    }

    public void marcar(Coordenada coordenada) {
        int fila = coordenada.getFila() - 1;
        int columna = coordenada.getColumna() - 1;
        marcadas[fila][columna] = !marcadas[fila][columna];  
    }

    
    public void macroDespejar(Coordenada coordenada) {
        int fila = coordenada.getFila() - 1;
        int columna = cordenada.getColumna() - 1;

        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i < 0 || i >= 6 || j < 0 || j >= 6) continue;
                if (i == fila && j == columna) continue;
                if (!marcadas[i][j] && !reveladas[i][j]) {
                    if (minas[i][j]) {
                        reveladas[i][j] = true;
                        mostrar();
                        System.out.println("¡Has pisado una mina durante el macrodespeje! Fin del juego.");
                        System.exit(0);
                    } else {
                        reveladas[i][j] = true;
                    }
                }
            }
        }
    }
}

