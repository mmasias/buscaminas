package orejaPaula;

public class Tablero {
    private final int filas;
    private final int columnas;
    private final int minas;
    private final Celda[][] cuadricula;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.cuadricula = new Celda[filas][columnas];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cuadricula[i][j] = new Celda();
            }
        }
    }
}
