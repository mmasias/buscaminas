package lianoJavier;

public class Tablero {

    private int[][] tablero;

    public Tablero(int[] dimensiones, int minasIniciales) {
        tablero = crearTablero(dimensiones);
        poblarTablero();
    }

    public Tablero (int dimensiones, int minasIniciales) {
        this(new int[] {dimensiones, dimensiones}, minasIniciales);
    }

    private void poblarTablero() {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                tablero[fila][columna] = -1;
            }
        }
    }

    private int[][] crearTablero(int[] dimensiones) {
        return new int[dimensiones[0]][dimensiones[1]];
    }

    public void mostrar() {
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                imprimirFicha(tablero[fila][columna]);
            }
        }
    }

    private void imprimirFicha(int simbolo) {
        System.out.println(parse(simbolo));
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
                if (tablero[fila][columna] < 0 ) return false;
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
                if (tablero[fila][columna] == 2 ) return true;
            }
        }
        return false;
    }

}
