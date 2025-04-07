package alonsoDiego;

public class Tablero {
    private Casilla[][] casillas;
    private int filas;
    private int columnas;
    private int totalMinas;

    public Tablero(int filas, int columnas, int totalMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.totalMinas = totalMinas;
        this.casillas = new Casilla[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    public void colocarMinas() {
        int minasColocadas = 0;
        while (minasColocadas < totalMinas) {
            int filaRandom = (int) (Math.random() * filas);
            int columnaRandom = (int) (Math.random() * columnas);

            if (!casillas[filaRandom][columnaRandom].tieneMina()) {
                casillas[filaRandom][columnaRandom].setTieneMina(true);
                minasColocadas++;
            }
        }
    }

    public void calcularMinasAdyacentes() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].tieneMina()) {
                    int contador = 0;

                    for (int x = Math.max(0, i - 1); x <= Math.min(filas - 1, i + 1); x++) {
                        for (int y = Math.max(0, j - 1); y <= Math.min(columnas - 1, j + 1); y++) {
                            if (casillas[x][y].tieneMina()) {
                                contador++;
                            }
                        }
                    }

                    casillas[i][j].setMinasAlrededor(contador);
                }
            }
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casillas[i][j].estaRevelada()) {
                    if (casillas[i][j].tieneMina()) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" " + casillas[i][j].getMinasAlrededor() + " ");
                    }
                } else if (casillas[i][j].esBandera()) {
                    System.out.print(" P ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}
