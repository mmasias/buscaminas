package lianoJavier;

import java.util.Random;
public class Tablero {

    private int[][] tablero;
    private Random random;

    public Tablero(int[] dimensiones, int minasIniciales) {
        tablero = crearTablero(dimensiones);
        random = new Random();
        poblarTablero();
        poblarMinas(minasIniciales);
    }
    
    public Tablero(int dimensiones, int minasIniciales) {
        this(new int[] { dimensiones, dimensiones }, minasIniciales);
    }
    
    private void poblarTablero() {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                tablero[fila][columna] = -1;
            }
        }
    }
    
    private void poblarMinas(int minasIniciales) {
        for (int i = 0; i < minasIniciales; i++) {
            int columna = Random(0, tablero[0].length - 1);
            int fila = Random(0, tablero.length - 1);
            if (tablero[fila][columna] != -2) {
                tablero[fila][columna] = -2;
            };
        }
    }

    private int Random(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    private int[][] crearTablero(int[] dimensiones) {
        return new int[dimensiones[0]][dimensiones[1]];
    }

    public void mostrar() {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                imprimirFicha(tablero[fila][columna]);
            }
            System.out.println();
        }
    }

    private void imprimirFicha(int simbolo) {
        System.out.print(parse(simbolo));
    }

    private String parse(int simbolo) {
        return switch (simbolo) {
            case 1 -> "[P]";
            case 2 -> "[M]";
            default -> "[ ]";
        };
    }

    public boolean resuelto() {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if (tablero[fila][columna] < 0)
                    return false;
            }
        }
        return true;
    }

    public void seleccionarCasilla(Coordenada coordenada) {
        tablero[coordenada.getFila()][coordenada.getColumna()] *= -1;
    }

    public boolean hayBomba() {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if (tablero[fila][columna] == 2)
                    return true;
            }
        }
        return false;
    }

    public int[] getExtremosFila() {
        return new int[] { 0, tablero.length };
    }

    public int[] getExtremosColumna() {
        return new int[] { 0, tablero[0].length };
    }

}
