import java.util.Random;

class Tablero {
    private int[][] tablero;
    private boolean[][] minas;
    private boolean[][] descubiertas;
    private int filas, columnas, numMinas;
    
    public Tablero(int filas, int columnas, int numMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.numMinas = numMinas;
        this.tablero = new int[filas][columnas];
        this.minas = new boolean[filas][columnas];
        this.descubiertas = new boolean[filas][columnas];
        colocarMinas();
        calcularNumeros();
    }
    
    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < numMinas) {
            int fila = rand.nextInt(filas);
            int columna = rand.nextInt(columnas);
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }
    
    private void calcularNumeros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!minas[i][j]) {
                    tablero[i][j] = contarMinasAlrededor(i, j);
                } else {
                    tablero[i][j] = -1;
                }
            }
        }
    }
    
    private int contarMinasAlrededor(int fila, int columna) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas) {
                    if (minas[nuevaFila][nuevaColumna]) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }
    public boolean descubrir(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas || descubiertas[fila][columna]) {
            return false;
        }
        descubiertas[fila][columna] = true;
        return minas[fila][columna];
    }

    public boolean[][] getDescubiertas() {
        return descubiertas;
    }
}

