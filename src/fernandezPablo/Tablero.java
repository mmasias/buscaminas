import java.util.Random;

public class Tablero {
    private Casilla[][] casillas;
    private int filas;
    private int columnas;
    private int minas;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.casillas = new Casilla[filas][columnas];
        inicializarTablero();
        colocarMinas();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    private void colocarMinas() {
        Random random = new Random();
        int colocadas = 0;
        while (colocadas < minas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            if (!casillas[fila][columna].tieneMina()) {
                casillas[fila][columna].colocarMina();
                colocadas++;
            }
        }
    }

    public void imprimirTablero() {
        System.out.println("  1 2 3 4 5 6");
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(casillas[i][j].mostrar() + " ");
            }
            System.out.println();
        }
    }

    public boolean despejarCasilla(int fila, int columna) {
        if (casillas[fila][columna].tieneMina()) {
            return true; // El jugador pierde
        }
        casillas[fila][columna].revelar();
        return false;
    }

    public void marcarCasilla(int fila, int columna) {
        casillas[fila][columna].marcar();
    }

    public boolean esVictoria() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].tieneMina() && !casillas[i][j].estaRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void revelarTodo() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j].revelar();
            }
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}
