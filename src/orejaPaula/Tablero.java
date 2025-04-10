import java.util.Random;

public class Tablero {
    private final int filas;
    private final int columnas;
    private final int minas;
    private final Celda[][] cuadricula;
    private boolean juegoTerminado;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.cuadricula = new Celda[filas][columnas];
        this.juegoTerminado = false;
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cuadricula[i][j] = new Celda();
            }
        }
        colocarMinas();
        calcularAdyacencias();
    }

    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < minas) {
            int r = rand.nextInt(filas);
            int c = rand.nextInt(columnas);
            if (!cuadricula[r][c].esMina) {
                cuadricula[r][c].esMina = true;
                minasColocadas++;
            }
        }
    }

    private void calcularAdyacencias() {
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!cuadricula[i][j].esMina) {
                    int contador = 0;
                    for (int k = 0; k < 8; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < filas && nc >= 0 && nc < columnas && cuadricula[nr][nc].esMina) {
                            contador++;
                        }
                    }
                    cuadricula[i][j].minasAdyacentes = contador;
                }
            }
        }
    }

    public void revelarCelda(int r, int c) {
        if (r < 0 || r >= filas || c < 0 || c >= columnas || cuadricula[r][c].estaRevelada) {
            return;
        }
        cuadricula[r][c].estaRevelada = true;
        if (cuadricula[r][c].esMina) {
            juegoTerminado = true;
            System.out.println("¡Has perdido!");
            return;
        }
        if (cuadricula[r][c].minasAdyacentes == 0) {
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr != 0 || dc != 0) {
                        revelarCelda(r + dr, c + dc);
                    }
                }
            }
        }
    }

    public void macroDespeje(int r, int c) {
        if (r < 0 || r >= filas || c < 0 || c >= columnas || !cuadricula[r][c].estaRevelada) {
            System.out.println("No se puede hacer macrodespeje en esta celda.");
            return;
        }

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < filas && nc >= 0 && nc < columnas && !cuadricula[nr][nc].estaRevelada) {
                revelarCelda(nr, nc);
            }
        }
    }

    public void imprimirTablero() {
        System.out.println("Tablero:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!cuadricula[i][j].estaRevelada) {
                    System.out.print("[ ]");
                } else if (cuadricula[i][j].esMina) {
                    System.out.print("[*]");
                } else {
                    System.out.print("[" + cuadricula[i][j].minasAdyacentes + "]");
                }
            }
            System.out.println();
        }
    }

    public boolean esJuegoTerminado() {
        return juegoTerminado;
    }
}





