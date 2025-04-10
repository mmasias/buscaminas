package buscaminas.src.vaqueroSara;

import java.util.Random;

public class Tablero {
    
    private Casilla[][] tablero;
    private int filas;
    private int columnas;
    private int minas;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.tablero = new Casilla[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new Casilla();
            }
        }
        
        colocarMinas();
        calcularMinasAdyacentes();
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < minas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            if (!tablero[fila][columna].tieneMina()) {
                tablero[fila][columna].ponerMina();
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAdyacentes() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!tablero[i][j].tieneMina()) {
                    int minasAdyacentes = contarMinasAdyacentes(i, j);
                    tablero[i][j].setMinasAdyacentes(minasAdyacentes);
                }
            }
        }
    }

    private int contarMinasAdyacentes(int fila, int columna) {
        int minasAdyacentes = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (fila + i >= 0 && fila + i < filas && columna + j >= 0 && columna + j < columnas) {
                    if (tablero[fila + i][columna + j].tieneMina()) {
                        minasAdyacentes++;
                    }
                }
            }
        }
        return minasAdyacentes;
    }

    public void descubrirCasilla(int fila, int columna) {
        if (tablero[fila][columna].estaDescubierta() || tablero[fila][columna].estaMarcada()) {
            return;
        }

        tablero[fila][columna].descubrir();
        if (tablero[fila][columna].getMinasAdyacentes() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (fila + i >= 0 && fila + i < filas && columna + j >= 0 && columna + j < columnas) {
                        descubrirCasilla(fila + i, columna + j);
                    }
                }
            }
        }
    }

    public void marcarCasilla(int fila, int columna) {
        if (!tablero[fila][columna].estaDescubierta()) {
            tablero[fila][columna].marcar();
        }
    }

    public boolean esMina(int fila, int columna) {
        return tablero[fila][columna].tieneMina();
    }

    public boolean estaDescubierta(int fila, int columna) {
        return tablero[fila][columna].estaDescubierta();
    }

    public boolean estaMarcada(int fila, int columna) {
        return tablero[fila][columna].estaMarcada();
    }

    public void imprimirTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j].estaDescubierta()) {
                    if (tablero[i][j].tieneMina()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(tablero[i][j].getMinasAdyacentes() + " ");
                    }
                } else if (tablero[i][j].estaMarcada()) {
                    System.out.print("F ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
