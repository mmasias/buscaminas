package lianoJavier.v001;

public class Tablero {

        private int[][] tableroMinas;
        private int[][] tableroEstado;
        private int dimensiones;

        private final String MARCADO = "[P]";
        private final String SIN_MOSTRAR = "[ ]";
        private final String MINA = "[*]";
        private final String DESPEJADO = "[D]";

        public Tablero(int dimensiones, int minasIniciales) {
                this.dimensiones = dimensiones;
                tableroMinas = new int[dimensiones][dimensiones];
                tableroEstado = new int[dimensiones][dimensiones];
                crearTablero();
                colocarMinas(minasIniciales);
        }

        private void crearTablero() {
                int casillaVacia = -1;
                for (int fila = 0; fila < dimensiones; fila++) {
                        for (int columna = 0; columna < dimensiones; columna++) {
                                tableroMinas[fila][columna] = casillaVacia;
                                tableroEstado[fila][columna] = casillaVacia;
                        }
                }
        }

        private void colocarMinas(int minasIniciales) {
                int minasPuestas = 0;
                int tieneMina = 1;
                while (minasPuestas < minasIniciales) {
                        int fila = (int) (Math.random() * dimensiones);
                        int columna = (int) (Math.random() * dimensiones);
                        if (tableroMinas[fila][columna] != tieneMina) {
                                tableroMinas[fila][columna] = tieneMina;
                                minasPuestas++;
                        }
                }
        }

        public void mostrarEstadoActual() {
                for (int fila = 0; fila < tableroMinas.length; fila++) {
                        for (int columna = 0; columna < tableroMinas[fila].length; columna++) {
                                String icon = " ";
                                if (tableroEstado[fila][columna] == -1) {
                                        icon = SIN_MOSTRAR;
                                } else if (tableroEstado[fila][columna] == 1) {
                                        icon = MARCADO;
                                } else if (tableroMinas[fila][columna] == -1) {
                                        icon = DESPEJADO;
                                } else if (tableroMinas[fila][columna] == 1) {
                                        icon = MINA;
                                }
                                System.out.print(icon);
                        }
                        System.out.println();
                }
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
                tableroEstado[fila][columna] = 0;
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
                
                if (tableroEstado[fila][columna] == -1) {
                        tableroEstado[fila][columna] = 1; // Marcado
                } else if (tableroEstado[fila][columna] == 1) {
                        tableroEstado[fila][columna] = -1; // Desmarcado
                }
        }

        public void revelarTodasLasMinas() {
                for (int fila = 0; fila < tableroMinas.length; fila++) {
                        for (int columna = 0; columna < tableroMinas[fila].length; columna++) {
                                if (tableroMinas[fila][columna] == 1) {
                                        System.out.print(MINA);
                                } else {
                                        System.out.print(SIN_MOSTRAR);
                                }
                        }
                        System.out.println();
                }
        }

        public void mostrarPosicionesMinas() {
                System.out.println("Posiciones de las minas (modo desarrollo):");
                for (int fila = 0; fila < tableroMinas.length; fila++) {
                        for (int columna = 0; columna < tableroMinas[fila].length; columna++) {
                                System.out.print(tableroMinas[fila][columna] == 1 ? MINA : SIN_MOSTRAR);
                        }
                        System.out.println();
                }
        }

}
