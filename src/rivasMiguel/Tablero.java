public class Tablero {
    private char[][] tablero;
    private int[][] minas;

    public Tablero(int filas, int columnas, int minas) {
        this.tablero = generarTablero(filas, columnas);
        this.minas = generarMinas(filas, columnas, minas);
    }

    private char[][] generarTablero(int filas, int columnas) {
        char[][] matriz = new char[filas + 1][columnas + 1];

        for (int j = 1; j <= columnas; j++) {
            matriz[0][j] = (char) ('0' + j);
        }

        for (int i = 1; i <= filas; i++) {
            matriz[i][0] = (char) ('0' + i);
            for (int j = 1; j <= columnas; j++) {
                matriz[i][j] = '_';
            }
        }

        return matriz;
    }

    private boolean casillaDisponible(int[][] minas, int x, int y, int count) {
        for (int i = 0; i < count; i++) {
            if (minas[i][0] == x && minas[i][1] == y) {
                return false;
            }
        }
        return true;
    }

    private int[][] generarMinas(int filas, int columnas, int cantidad) {
        if (cantidad > filas * columnas) {
            return new int[0][0];
        }

        int[][] minas = new int[cantidad][2];
        int count = 0;

        while (count < cantidad) {
            int x = (int) (Math.random() * filas) + 1;
            int y = (int) (Math.random() * columnas) + 1;

            if (casillaDisponible(minas, x, y, count)) {
                minas[count][0] = x;
                minas[count][1] = y;
                count++;
            }
        }
        return minas;
    }

    public void mostrarTablero() {
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Tablero t = new Tablero(6, 6, 6);
        t.mostrarTablero();
    }
}
