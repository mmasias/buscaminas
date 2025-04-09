package alvaradoCarlos;

import java.util.Random;

public class Tablero {

    private char[][] tablero;
    private boolean[][] minas;
    private int[] dimensiones;
    private int minasTotales;
    private static final int[] ADYACENTES_X = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] ADYACENTES_Y = {-1, 0, 1, -1, 1, -1, 0, 1};

    public Tablero(int[] dimensiones, int minasTotales) {
        this.dimensiones = dimensiones;
        this.tablero = crearTablero(dimensiones);
        this.minasTotales = minasTotales;
        this.minas = new boolean[dimensiones[0]][dimensiones[1]];
        colocarMinas(dimensiones, minasTotales);
    }

    private char[][] crearTablero(int[] dimensiones) {
        int filas = dimensiones[0];
        int columnas = dimensiones[1];
        char[][] matriz = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = '_';
            }
        }
        return matriz;
    }

    private void colocarMinas(int[] dimensiones, int cantidadMinas) {
        int filas = dimensiones[0];
        int columnas = dimensiones[1];
        int minasColocadas = 0;
        Random random = new Random();

        while (minasColocadas < cantidadMinas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);

            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }

    public int[] dimensiones() {
        return dimensiones;
    }

    public int minasTotales() {
        return minasTotales;
    }

    public boolean estaEnRango(int fila, int columna) {
        return fila >= 0 && fila < dimensiones[0] && columna >= 0 && columna < dimensiones[1];
    }
    

    public void mostrarTablero() {
        int filas = dimensiones[0];
        int columnas = dimensiones[1];

        System.out.print("   ");
        for (int col = 1; col <= columnas; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int fila = 0; fila < filas; fila++) {
            System.out.print((fila + 1) + "  ");
            for (int col = 0; col < columnas; col++) {
                System.out.print(tablero[fila][col] + " ");
            }
            System.out.println();
        }
    }

    public void actualizarTablero(char opcion, int[] coordenadas) {
        int fila = coordenadas[0] - 1;
        int columna = coordenadas[1] - 1;
        
        if (!estaEnRango(fila, columna)) {
            System.out.println("Coordenadas fuera de rango.");
            return;
        }

        if (opcion == 'D') {
            if (!celdaOcupada(fila, columna)) {
                if (minas[fila][columna]) {
                    explotar(fila, columna);
                } else {
                    descubrir(fila, columna);
                }
            } else {
                ocupado(fila, columna);
            }
        } else if (opcion == 'M') {
            if (tablero[fila][columna] == '_') {
                marcar(fila, columna);
            } else {
                ocupado(fila, columna);
            }
        } else if (opcion == 'R') {
            if (tablero[fila][columna] == 'M') {
                desmarcar(fila, columna);
            } else {
                System.out.println("No hay marca en esta celda para retirar.");
            }
        } else if (opcion == 'X') {
            macroDescubrir(fila, columna);
        }
         else {
            System.out.println("Opción no válida. Usa 'D' para descubrir 'X' para macrodescubrir, 'M' para marcar o 'R' para retirar marca.");
        }
    }

    public void marcar(int fila, int columna) {
        tablero[fila][columna] = 'M';
    }

    public void desmarcar(int fila, int columna) {
        tablero[fila][columna] = '_';
    }

    public void descubrir(int fila, int columna) {
        int minasCercanas = contarMinasCercanas(fila, columna);
        tablero[fila][columna] = (char) ('0' + minasCercanas);
    }

    public void macroDescubrir(int fila, int columna) {
        for (int i = 0; i < ADYACENTES_X.length; i++){
            int nuevaFila = fila + ADYACENTES_X[i];
            int nuevaColumna = columna + ADYACENTES_Y[i]; 

            if (estaEnRango(nuevaFila, nuevaColumna)) {
                if (!minas[nuevaFila][nuevaColumna]) {
                    descubrir(nuevaFila, nuevaColumna);
                }
            }
        }
    }

    public void explotar(int fila, int columna) {
        tablero[fila][columna] = '*';
        System.out.println("¡Has descubierto una mina!");
        mostrarTablero();
    }

    public void ocupado(int fila, int columna) {
        if (celdaOcupada(fila, columna)) {
            System.out.println("Esta celda ya está marcada o descubierta.");
        }
    }

    private boolean celdaOcupada(int fila, int columna) {
        return tablero[fila][columna] != '_';
    }

    private int contarMinasCercanas(int fila, int columna) {
        int minasCercanas = 0;
        for (int i = 0; i < ADYACENTES_X.length; i++) {
            int nuevaFila = fila + ADYACENTES_X[i];
            int nuevaColumna = columna + ADYACENTES_Y[i];
            if (estaEnRango(nuevaFila, nuevaColumna) && minas[nuevaFila][nuevaColumna]) {
                minasCercanas++;
            }
        }
        return minasCercanas;
    }

    public boolean todasLasCeldasDescubiertas() {
        for (int fila = 0; fila < dimensiones[0]; fila++) {
            for (int columna = 0; columna < dimensiones[1]; columna++) {
                if (!minas[fila][columna] && tablero[fila][columna] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public char mostrarCelda(int[] coordenadas) {
        int fila = coordenadas[0] - 1;
        int columna = coordenadas[1] - 1;

        if (!estaEnRango(fila, columna)) {
            System.out.println("Coordenadas fuera de rango.");
        }

        return tablero[fila][columna];
    }
}
