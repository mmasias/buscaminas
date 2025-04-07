package martinezDiego;

public class Tablero {
    private String[][] mapaReal = new String[10][10];
    private String[][] mapaVisible = new String[10][10];
    private boolean partidaPerdida = false;

    public Tablero() {
        inicializarMapas();
        generarMinas();
        generarNumeros();
    }

    private void inicializarMapas() {
        for (int i = 0; i < mapaReal.length; i++) {
            for (int j = 0; j < mapaReal[i].length; j++) {
                mapaReal[i][j] = " ";
                mapaVisible[i][j] = "#";
            }
        }
    }

    public void imprimirMapaVisible() {
        for (int i = 0; i < mapaVisible.length; i++) {
            for (int j = 0; j < mapaVisible[i].length; j++) {
                System.out.print(mapaVisible[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void generarMinas() {
        int minas = 0;
        while (minas < 10) {
            int fila = (int) (Math.random() * 10);
            int columna = (int) (Math.random() * 10);
            if (!mapaReal[fila][columna].equals("M")) {
                mapaReal[fila][columna] = "M";
                minas++;
            }
        }
    }

    private void generarNumeros() {
        for (int i = 0; i < mapaReal.length; i++) {
            for (int j = 0; j < mapaReal[i].length; j++) {
                if (mapaReal[i][j].equals("M")) continue;

                int minasCerca = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int ni = i + x, nj = j + y;
                        if (ni >= 0 && ni < 10 && nj >= 0 && nj < 10 && mapaReal[ni][nj].equals("M")) {
                            minasCerca++;
                        }
                    }
                }
                if (minasCerca > 0) mapaReal[i][j] = String.valueOf(minasCerca);
            }
        }
    }

    public void revelarCasilla(int fila, int columna) {
        if (mapaReal[fila][columna].equals("M")) {
            mapaVisible[fila][columna] = "M";
            partidaPerdida = true;
        } else {
            mapaVisible[fila][columna] = mapaReal[fila][columna];
        }
    }

    public void colocarBandera(int fila, int columna) {
        mapaVisible[fila][columna] = "7";
    }

    public boolean partidaTerminada() {
        if (partidaPerdida) return true;

        for (int i = 0; i < mapaVisible.length; i++) {
            for (int j = 0; j < mapaVisible[i].length; j++) {
                if (mapaVisible[i][j].equals("#") && !mapaReal[i][j].equals("M")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean jugadorPerdio() {
        return partidaPerdida;
    }
}