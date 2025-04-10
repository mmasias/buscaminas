package caicedoFernando;

import java.util.Random;

public class Tablero {

    private final int filas, columnas, totalMinas;
    private final char[][] tablero;
    private final boolean[][] minas;
    private final boolean[][] revelado;

    public Tablero(int filas, int columnas, int totalMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.totalMinas = totalMinas;
        this.tablero = new char[filas][columnas];
        this.minas = new boolean[filas][columnas];
        this.revelado = new boolean[filas][columnas];
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = '_';
            }
        }

        Random random = new Random();
        int colocadas = 0;
        while (colocadas < totalMinas) {
            int filaAleatoria = random.nextInt(filas);
            int columnaAleatoria = random.nextInt(columnas);
            if (!minas[filaAleatoria][columnaAleatoria]) {
                minas[filaAleatoria][columnaAleatoria] = true;
                colocadas++;
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("\nBUSCAMINAS");
        System.out.print("  ");
        for (int i = 1; i <= columnas; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < columnas; j++) {
                if (revelado[i][j]) {
                    System.out.print("D ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void mostrarFinal() {
        System.out.println("\nTABLERO FINAL");
        System.out.print("  ");
        for (int i = 1; i <= columnas; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < columnas; j++) {
                if (minas[i][j]) {
                    System.out.print("* ");
                } else if (revelado[i][j]) {
                    System.out.print("D ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void explosionMina(Coordenada coordenada) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (minas[i][j]) {
                    revelado[i][j] = true;
                }
            }
        }
        revelado[coordenada.fila][coordenada.columna] = true;
        mostrarFinal();
        System.out.println("¡BOOM! Has perdido.");
    }

    public boolean macrodespeje(Coordenada coordenadaCentral) {
        for (int desplazamientoFila = -1; desplazamientoFila <= 1; desplazamientoFila++) {
            for (int desplazamientoColumna = -1; desplazamientoColumna <= 1; desplazamientoColumna++) {

                boolean esCeldaCentral = desplazamientoFila == 0 && desplazamientoColumna == 0;
                if (!esCeldaCentral) {
                    int filaAdyacente = coordenadaCentral.fila + desplazamientoFila;
                    int columnaAdyacente = coordenadaCentral.columna + desplazamientoColumna;

                    boolean dentroDeLimites = filaAdyacente >= 0 && filaAdyacente < filas
                            && columnaAdyacente >= 0 && columnaAdyacente < columnas;

                    if (dentroDeLimites) {
                        boolean celdaNoRevelada = !revelado[filaAdyacente][columnaAdyacente];
                        boolean celdaNoMarcada = tablero[filaAdyacente][columnaAdyacente] != 'M';

                        if (celdaNoRevelada && celdaNoMarcada) {
                            Coordenada coordenadaAdyacente = new Coordenada(filaAdyacente, columnaAdyacente);
                            if (esMina(coordenadaAdyacente)) {
                                explosionMina(coordenadaAdyacente);
                                System.out.println("¡Has perdido!");
                                return true;
                            } else {
                                revelar(coordenadaAdyacente);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean juegoTerminado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (minas[i][j] && revelado[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estaRevelada(Coordenada coordenada) {
        return revelado[coordenada.fila][coordenada.columna];
    }

    public boolean esValida(Coordenada columnaAleatoria) {
        return columnaAleatoria.fila >= 0 && columnaAleatoria.fila < filas && columnaAleatoria.columna >= 0 && columnaAleatoria.columna < columnas;
    }

    public boolean esMina(Coordenada columnaAleatoria) {
        return minas[columnaAleatoria.fila][columnaAleatoria.columna];
    }

    public void revelar(Coordenada columnaAleatoria) {
        revelado[columnaAleatoria.fila][columnaAleatoria.columna] = true;
    }

    public void marcar(Coordenada columnaAleatoria) {
        if (!revelado[columnaAleatoria.fila][columnaAleatoria.columna]) {
            tablero[columnaAleatoria.fila][columnaAleatoria.columna] = (tablero[columnaAleatoria.fila][columnaAleatoria.columna] == 'M') ? '_' : 'M';
        }
    }

    public boolean condicionVictoria() {
        int descubiertas = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (revelado[i][j]) {
                    descubiertas++;
                }
            }
        }
        return descubiertas == filas * columnas - totalMinas;
    }

}
