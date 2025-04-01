class Tablero {
    private final int filas;
    private final int columnas;
    private final int numMinas;
    private final Celda[][] celdas;

    public Tablero(int filas, int columnas, int numMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.numMinas = numMinas;
        this.celdas = new Celda[filas][columnas];
        inicializarTablero();
        colocarMinas();
        calcularMinasCercanas();
    }

     private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    private void colocarMinas() {
        Random rand = new Random();
        int colocadas = 0;
        while (colocadas < numMinas) {
            int x = rand.nextInt(filas);
            int y = rand.nextInt(columnas);
            if (!celdas[x][y].tieneMina) {
                celdas[x][y].tieneMina = true;
                colocadas++;
            }
        }
    }

    private void calcularMinasCercanas() {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (celdas[i][j].tieneMina) continue;
                int contador = 0;
                for (int d = 0; d < 8; d++) {
                    int ni = i + dx[d], nj = j + dy[d];
                    if (ni >= 0 && ni < filas && nj >= 0 && nj < columnas && celdas[ni][nj].tieneMina) {
                        contador++;
                    }
                }
                celdas[i][j].minasCercanas = contador;
            }
        }
    }