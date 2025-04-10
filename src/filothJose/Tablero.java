package src.filothJose;

import java.util.Random;

public class Tablero {

    private final int numeroDeFilas = 6;
    private final int numeroDeColumnas = 6;
    private final int cantidadDeMinas = 6;

    private final char CASILLA_SIN_DESCUBRIR = '_';
    private final char BANDERA = 'M';
    private final char MINA = '*';
    private final char CASILLA_DESPEJADA = 'D';

    private char[][] tablero;
    private boolean minasVisibles = false;

    public Tablero() {
        tablero = new char[numeroDeFilas][numeroDeColumnas];
        inicializarTablero();
        posicionarMinasAleatoriamente();
    }

    private void inicializarTablero() {
        for (int fila = 0; fila < numeroDeFilas; fila++) {
            for (int columna = 0; columna < numeroDeColumnas; columna++) {
                tablero[fila][columna] = CASILLA_SIN_DESCUBRIR;
            }
        }
    }

    private void posicionarMinasAleatoriamente() {
        Random generadorAleatorio = new Random();
        int minasColocadas = 0;

        while (minasColocadas < cantidadDeMinas) {
            int filaAleatoria = generadorAleatorio.nextInt(numeroDeFilas);
            int columnaAleatoria = generadorAleatorio.nextInt(numeroDeColumnas);

            if (tablero[filaAleatoria][columnaAleatoria] != MINA) {
                tablero[filaAleatoria][columnaAleatoria] = MINA;
                minasColocadas++;
            }
        }
    }

    public void mostrarTablero() {
        System.out.print("    ");
        for (int columna = 1; columna <= numeroDeColumnas; columna++) {
            System.out.print(columna + " ");
        }
        System.out.println();

        for (int fila = 0; fila < numeroDeFilas; fila++) {
            System.out.print((fila + 1) + "   "); 
            for (int columna = 0; columna < numeroDeColumnas; columna++) {
                char casillaActual = tablero[fila][columna];

                if (casillaActual == MINA && !minasVisibles) {
                    System.out.print(CASILLA_SIN_DESCUBRIR + " ");
                } else if (casillaActual == MINA && minasVisibles) {
                    System.out.print(MINA + " ");
                } else {
                    System.out.print(casillaActual + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean despejarCasilla(int fila, int columna) {
        if (tablero[fila - 1][columna - 1] == MINA) { 
            minasVisibles = true;
            return false;
        }

        if (tablero[fila - 1][columna - 1] == CASILLA_SIN_DESCUBRIR) {
            tablero[fila - 1][columna - 1] = CASILLA_DESPEJADA;
        }

        return true;
    }

    public void marcarConBandera(int fila, int columna) {
        if (tablero[fila - 1][columna - 1] == CASILLA_SIN_DESCUBRIR) { 
            tablero[fila - 1][columna - 1] = BANDERA;
        } else if (tablero[fila - 1][columna - 1] == BANDERA) {
            tablero[fila - 1][columna - 1] = CASILLA_SIN_DESCUBRIR;
        }
    }

    public boolean juegoCompletado() {
        for (int fila = 0; fila < numeroDeFilas; fila++) {
            for (int columna = 0; columna < numeroDeColumnas; columna++) {
                char casilla = tablero[fila][columna];
                if (casilla == CASILLA_SIN_DESCUBRIR || casilla == BANDERA) {
                    if (casilla != MINA) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean esCoordenadaValida(int fila, int columna) {
        return fila >= 1 && fila <= numeroDeFilas && columna >= 1 && columna <= numeroDeColumnas; 
    }

    public boolean usarBomba(int fila, int columna) {
        if (!esCoordenadaValida(fila, columna)) {
            System.out.println("Coordenada inválida.");
            return false;
        }

        boolean juegoContinua = true;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int filaAdyacente = fila + i;
                int columnaAdyacente = columna + j;

                if (esCoordenadaValida(filaAdyacente, columnaAdyacente)) {
                    char casilla = tablero[filaAdyacente - 1][columnaAdyacente - 1];

                    if (casilla == BANDERA) continue;

                    if (!despejarCasilla(filaAdyacente, columnaAdyacente)) {
                        juegoContinua = false;
                    }
                }
            }
        }

        return juegoContinua;
    }

}
