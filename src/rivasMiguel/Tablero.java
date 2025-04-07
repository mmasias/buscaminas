package rivasMiguel;

public class Tablero {
    private char[][] tablero;
    private int[][] minas;
    private int area;

    public Tablero(int area, int cantidadMinas) {
        this.area = area;
        this.tablero = generarTablero(area);
        this.minas = generarMinas(area, cantidadMinas);
    }

    private char[][] generarTablero(int area) {
        char[][] matriz = new char[area + 1][area + 1];

        for (int j = 1; j <= area; j++) {
            matriz[0][j] = (char) ('0' + j);
        }

        for (int i = 1; i <= area; i++) {
            matriz[i][0] = (char) ('0' + i);
            for (int j = 1; j <= area; j++) {
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

    private int[][] generarMinas(int area, int cantidad) {
        if (cantidad > area * area) {
            return new int[0][0];
        }

        int[][] minas = new int[cantidad][2];
        int count = 0;

        while (count < cantidad) {
            int x = (int) (Math.random() * area) + 1;
            int y = (int) (Math.random() * area) + 1;

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

    public boolean comprobarDerrota(int fila, int columna, char accion) {
        if (accion == 'M') {
            return false;
        }

        for (int[] mina : minas) {
            if (mina[0] == fila && mina[1] == columna) {
                return true;
            }
        }
        return false;
    }

    public void hasPerdido() {
        for (int[] m : minas) {
            tablero[m[0]][m[1]] = '*';
        }

        mostrarTablero();

        System.out.println("\n💥 ¡Mina! ¡Has perdido! 💥");
    }

    public boolean comprobarVictoria(int cantidadMinas) {
        int totalDespejadas = 0;
        int objetivo = (area * area) - cantidadMinas;

        for (int i = 1; i <= area; i++) {
            for (int j = 1; j <= area; j++) {
                if (tablero[i][j] == 'D') {
                    totalDespejadas++;
                }
            }
        }

        return totalDespejadas == objetivo;
    }

    public void celebrarVictoria() {
        System.out.println("\n🎉 ¡Has ganado! 🎉");
        mostrarTablero();
    }

    public void marcarCasilla(int fila, int columna, char accion) {
        if (accion == 'D' || accion == 'M') {
            tablero[fila][columna] = accion;
        }
    }

    public int getArea() {
        return area;
    }

    public int getCantidadMinas() {
        return minas.length;
    }
}
