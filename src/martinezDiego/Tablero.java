package martinezDiego;

public class Tablero {
    private String[][] mapaReal = new String[10][10];
    private String[][] mapaUsuario = new String[10][10];
    private boolean partidaPerdida = false;

    public Tablero() {
        inicializarMapas();
        generarMinas();
        generarNumeros();
    }

    
    private void inicializarMapas() {
        for (int i = 0; i < mapaReal.length; i++) {
            for (int j = 0; j < mapaReal[i].length; j++) {
                
            }
        }
    }

    public void imprimirMapaVisible() {
        for (int i = 0; i < mapaUsuario.length; i++) {
            for (int j = 0; j < mapaUsuario[i].length; j++) {
                System.out.print(mapaUsuario[i][j] + " ");
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
                if (mapaReal[i][j].equals("M"))
                    continue;

                int minasCerca = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int ni = i + x, nj = j + y;
                        if (ni >= 0 && ni < 10 && nj >= 0 && nj < 10 && mapaReal[ni][nj].equals("M")) {
                            minasCerca++;
                        }
                    }
                }
                if (minasCerca > 0)
                    mapaReal[i][j] = String.valueOf(minasCerca);
            }
        }
    }

    public void marcarCasilla(int fila, int columna) {
        if (mapaReal[fila][columna].equals("M")) {
            mapaUsuario[fila][columna] = "M";
            partidaPerdida = true;
        } else {
            mapaUsuario[fila][columna] = mapaReal[fila][columna];
        }
    }

    public boolean comprobarLimites(int fila, int columna) {
        if (fila >= 0 && fila < mapaReal.length && columna >= 0 && columna < mapaReal[fila].length) {
            mapaUsuario[fila][columna] = mapaReal[fila][columna];
        }
        return true;
    }

    public void enseñarCasillas(int fila, int columna) {

        int[][] direcciones = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 0 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int[] direccion : direcciones) {

            int nuevaFila = fila + direccion[0];
            int nuevaColumna = columna + direccion[1];

            if (comprobarLimites(nuevaFila, nuevaColumna)) {
                mapaUsuario[nuevaFila][nuevaColumna] = mapaReal[nuevaFila][nuevaColumna];
            }
        }
    }

    public void colocarBandera(int fila, int columna) {
        mapaUsuario[fila][columna] = "B";
    }

    public boolean partidaTerminada() {
        if (partidaPerdida)
            return true;

        for (int i = 0; i < mapaUsuario.length; i++) {
            for (int j = 0; j < mapaUsuario[i].length; j++) {
                if (mapaUsuario[i][j].equals("#") && !mapaReal[i][j].equals("M")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean jugadorHaPerdido() {
        return partidaPerdida;
    }
}