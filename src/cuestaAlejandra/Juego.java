lass Juego {
    private final Tablero tablero;
    private boolean juegoTerminado;
    private final Scanner scanner;

    public Juego(int filas, int columnas, int numMinas) {
        this.tablero = new Tablero(filas, columnas, numMinas);
        this.juegoTerminado = false;
        this.scanner = new Scanner(System.in);
    }