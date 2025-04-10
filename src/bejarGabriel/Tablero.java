package bejarGabriel;

public class Tablero {
    private final int[][] tableroMinas;
    private final int[][] tableroEstado;
    private final int dimensiones;

    private static final String MARCADO = "[P]";
    private static final String SIN_MOSTRAR = "[ ]";
    private static final String MINA = "[*]";
    private static final String DESPEJADO = "[D]";

    public Tablero(int dimensiones, int minasIniciales) {
        this.dimensiones = dimensiones;
        tableroMinas = new int[dimensiones][dimensiones];
        tableroEstado = new int[dimensiones][dimensiones];
        crearTablero();
        colocarMinas(minasIniciales);
    }

    private void crearTablero() {
        for (int fila = 0; fila < dimensiones; fila++) {
            for (int columna = 0; columna < dimensiones; columna++) {
                tableroMinas[fila][columna] = -1;
                tableroEstado[fila][columna] = -1;
            }
        }
    }

    private void colocarMinas(int minasIniciales) {
        int minasPuestas = 0;
        while (minasPuestas < minasIniciales) {
            int fila = (int) (Math.random() * dimensiones);
            int columna = (int) (Math.random() * dimensiones);
            if (tableroMinas[fila][columna] != 1) {
                tableroMinas[fila][columna] = 1;
                minasPuestas++;
            }
        }
    }

    public void mostrarEstadoActual() {
        for (int fila = 0; fila < dimensiones; fila++) {
            for (int columna = 0; columna < dimensiones; columna++) {
                String icon = obtenerIcono(fila, columna);
                System.out.print(icon);
            }
            System.out.println();
        }
    }

    private String obtenerIcono(int fila, int columna) {
        if (tableroEstado[fila][columna] == -1) return SIN_MOSTRAR;
        if (tableroEstado[fila][columna] == 1) return MARCADO;
        return tableroMinas[fila][columna] == 1 ? MINA : DESPEJADO;
    }

    public boolean estaCompleto() {
        for (int i = 0; i < dimensiones; i++) {
            for (int j = 0; j < dimensiones; j++) {
                if (tableroMinas[i][j] != 1 && tableroEstado[i][j] == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getDimensionesColumna() {
        return dimensiones;
    }

    public int getDimensionesFila() {
        return dimensiones;
    }

    public void seleccionarCasilla(Coordenada coordenada) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        
        if (tableroMinas[fila][columna] == 1) {
            return;
        }
        
        tableroEstado[fila][columna] = 0;
        despejarCasillasAdyacentes(fila, columna);
    }

    private void despejarCasillasAdyacentes(int fila, int columna) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;

                if (nuevaFila >= 0 && nuevaFila < dimensiones && nuevaColumna >= 0 && nuevaColumna < dimensiones) {
                    if (tableroEstado[nuevaFila][nuevaColumna] == -1 && tableroMinas[nuevaFila][nuevaColumna] != 1) {
                        tableroEstado[nuevaFila][nuevaColumna] = 0;
                        despejarCasillasAdyacentes(nuevaFila, nuevaColumna);
                    }
                }
            }
        }
    }

    public boolean hayBomba() {
        for (int i = 0; i < dimensiones; i++) {
            for (int j = 0; j < dimensiones; j++) {
                if (tableroEstado[i][j] == 0 && tableroMinas[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void marcarCasilla(Coordenada coordenada) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        tableroEstado[fila][columna] = (tableroEstado[fila][columna] == -1) ? 1 : -1;
    }

    public void revelarTodasLasMinas() {
        for (int fila = 0; fila < dimensiones; fila++) {
            for (int columna = 0; columna < dimensiones; columna++) {
                System.out.print(tableroMinas[fila][columna] == 1 ? MINA : SIN_MOSTRAR);
            }
            System.out.println();
        }
    }

    public void mostrarPosicionesMinas() {
        System.out.println("Posiciones de las minas (modo desarrollo):");
        for (int fila = 0; fila < dimensiones; fila++) {
            for (int columna = 0; columna < dimensiones; columna++) {
                System.out.print(tableroMinas[fila][columna] == 1 ? MINA : SIN_MOSTRAR);
            }
            System.out.println();
        }
    }
}