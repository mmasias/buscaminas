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