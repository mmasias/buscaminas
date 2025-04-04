class Juego {
    private final Tablero tablero;
    private boolean juegoTerminado;
    private final Scanner scanner;

    public Juego(int filas, int columnas, int numMinas) {
        this.tablero = new Tablero(filas, columnas, numMinas);
        this.juegoTerminado = false;
        this.scanner = new Scanner(System.in);
    }
    
    public void iniciar() {
        while (!juegoTerminado) {
            tablero.mostrarTablero();
            System.out.print("Ingrese fila y columna (ejemplo: 2 3): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (tablero.revelarCelda(x, y)) {
                System.out.println("¡Has pisado una mina! Fin del juego.");
                juegoTerminado = true;
            }
        }
        scanner.close();
    }
}