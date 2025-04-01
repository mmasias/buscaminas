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