import java.util.Random;

public class Tablero {

    private char[][] tablero;
    private boolean[][] minas;
    private int[] dimensiones;
    private int minasTotales;

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

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
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

    public void mostrarTablero() {
        int filas = dimensiones[0];
        int columnas = dimensiones[1];

        System.out.print("   ");
        for (int col = 1; col <= columnas; col++){
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
    }
    
}
