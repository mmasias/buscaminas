package maderoCarla;

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

        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                casillas[fila][columna] = '_';
                minas[fila][columna] = false;
                reveladas[fila][columna] = false;
                marcadas[fila][columna] = false;
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
        for (int col = 0; col < 6; col++) {
            System.out.print((col + 1) + " ");
        }
        System.out.println();

        
        for (int fila = 0; fila < 6; fila++) {
            System.out.print((fila + 1) + " ");
            for (int col = 0; col < 6; col++) {
                if (reveladas[fila][col]) {
                    casillas[fila][col] = minas[fila][col] ? 'X' : 'D'; 
                } else if (marcadas[fila][col]) {
                    casillas[fila][col] = 'M'; 
                } else {
                    casillas[fila][col] = '_'; 
                }
                System.out.print(casillas[fila][col] + " ");
            }
            System.out.println();
        }
    }

    
    public boolean revelarCasilla(Coordenada coordenada) {
        int fila = coordenada.getFila() - 1;
        int columna = coordenada.getColumna() - 1;

        reveladas[fila][columna] = true;

        
        return !minas[fila][columna];
    }

    
    public void marcarCasilla(Coordenada coordenada) {
        int fila = coordenada.getFila() - 1;
        int columna = coordenada.getColumna() - 1;
        marcadas[fila][columna] = !marcadas[fila][columna]; 
    }

    
    public boolean yaRevelada(Coordenada coordenada) {
        int fila = coordenada.getFila() - 1;
        int columna = coordenada.getColumna() - 1;
        return reveladas[fila][columna];
    }

    
    public boolean juegoGanado() {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (!minas[fila][columna] && !reveladas[fila][columna]) {
                    return false;
                }
            }
        }
        return true;
    }
}
