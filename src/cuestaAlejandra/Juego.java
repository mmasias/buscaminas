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
            System.out.print("Ingrese fila, columna y acción (r: revelar, m: marcar, x: macrodespeje) (ej: 2 3 r): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String accion = scanner.next();

            switch (accion) {
                case "r":
                    if (tablero.revelarCelda(x, y)) {
                        System.out.println("¡Has pisado una mina! Fin del juego.");
                        juegoTerminado = true;
                    }
                    break;
                case "m":
                    tablero.marcarCelda(x, y);
                    break;
                case "x":
                    if (tablero.macroDespeje(x, y)) {
                        System.out.println("¡Has revelado una mina no marcada! Fin del juego.");
                        juegoTerminado = true;
                    }
                    break;
                default:
                    System.out.println("Acción no válida. Use 'r', 'm' o 'x'.");
            }
        }
        scanner.close();
    }
}