package zhenChao;
import java.util.Random;

public class Tablero {
    private Celda[][] tablero;
    private final int totalFilas = 6;
    private final int totalColumnas = 6;
    private final int totalMinas = 6;

    public Tablero() {
        tablero = new Celda[totalFilas][totalColumnas];
        for (int fila = 0; fila < totalFilas; fila++) {
            for (int columna = 0; columna < totalColumnas; columna++) {
                tablero[fila][columna] = new Celda();
            }
        }
        colocarMinasAleatoriamente();
        calcularMinasCercanas();
    }

    private void colocarMinasAleatoriamente() {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < totalMinas) {
            int fila = random.nextInt(totalFilas);
            int columna = random.nextInt(totalColumnas);
            if (!tablero[fila][columna].tieneMina()) {
                tablero[fila][columna].ponerMina();
                minasColocadas++;
            }
        }
    }

    public boolean despejarCasilla(int fila, int columna) {
        // Verificar si la celda ya está revelada o marcada
        if (tablero[fila][columna].casillaRevelada() || tablero[fila][columna].casillaMarcada()) {
            return true; // No hacemos nada si ya está revelada o marcada
        }

        // Revelar la celda actual
        tablero[fila][columna].revelar();

        // Si la celda contiene una mina, devolver false (el jugador ha perdido)
        if (tablero[fila][columna].tieneMina()) {
            System.out.println("¡Has perdido! Has pisado una mina.");
            return false; // El jugador ha perdido
        }

        // Si la celda no tiene minas cercanas, despejar las celdas adyacentes
        if (tablero[fila][columna].obtenerMinasCercanas() == 0) {
            despejarCeldasAdyacentes(fila, columna);
        }

        return true; // La celda fue despejada y no contiene mina
    }

    private void despejarCeldasAdyacentes(int fila, int columna) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Ignorar la celda actual
                if (i == 0 && j == 0) continue;

                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;

                // Verificar que la nueva posición esté dentro de los límites
                if (enRango(nuevaFila, nuevaColumna)) {
                    // Verificar si la celda adyacente no ha sido revelada
                    if (!tablero[nuevaFila][nuevaColumna].casillaRevelada()) {
                        // Revelar la celda adyacente
                        tablero[nuevaFila][nuevaColumna].revelar();

                        // Si la celda adyacente contiene una mina, el jugador ha perdido
                        if (tablero[nuevaFila][nuevaColumna].tieneMina()) {
                            System.out.println("¡Has perdido! Una mina estaba en una celda adyacente.");
                            return; // Finaliza el juego
                        }

                        // Si la celda adyacente tiene 0 minas cercanas, llama recursivamente
                        if (tablero[nuevaFila][nuevaColumna].obtenerMinasCercanas() == 0) {
                            despejarCeldasAdyacentes(nuevaFila, nuevaColumna);
                        }
                    }
                }
            }
        }
    }
    

    private boolean enRango(int fila, int columna) {
        return fila >= 0 && fila < totalFilas && columna >= 0 && columna < totalColumnas;
    }

    public int obtenerFilas() {
        return totalFilas;
    }

    public int obtenerColumnas() {
        return totalColumnas;
    }

    public void marcarCasilla(int fila, int columna) {
        if (!tablero[fila][columna].casillaRevelada()) {
            tablero[fila][columna].alternarMarca();
        }
    }

    public void mostrarTablero() {
        System.out.println("  ");
        System.out.println("BUSCAMINAS");
        for (int i = 1; i <= totalColumnas; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int fila = 0; fila < totalFilas; fila++) {
            System.out.print((fila + 1) + " ");
            for (int columna = 0; columna < totalColumnas; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }
        System.out.println("  ");
    }

    public boolean jugadorGano() {
        for (int fila = 0; fila < totalFilas; fila++) {
            for (int columna = 0; columna < totalColumnas; columna++) {
                if (!tablero[fila][columna].tieneMina() && !tablero[fila][columna].casillaRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }
}
