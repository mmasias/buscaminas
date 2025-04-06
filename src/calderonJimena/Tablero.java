package calderonJimena;

import java.util.Random;

public class Tablero {
    private Celda[][] celdas;
    private int filas;
    private int columnas;
    private int cantidadMinas;

    public Tablero(int filas, int columnas, int cantidadMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.cantidadMinas = cantidadMinas;
        celdas = new Celda[filas][columnas];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda();
            }
        }

        colocarMinas();
        calcularMinasAlrededorDeCadaCelda();
    }

    private void colocarMinas() {
        Random generadorAleatorio = new Random();
        int minasColocadas = 0;

        while (minasColocadas < cantidadMinas) {
            int filaAleatoria = generadorAleatorio.nextInt(filas);
            int columnaAleatoria = generadorAleatorio.nextInt(columnas);
            if (!celdas[filaAleatoria][columnaAleatoria].tieneMina()) {
                celdas[filaAleatoria][columnaAleatoria].ponerMina();
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAlrededorDeCadaCelda() {
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                if (!celdas[fila][columna].tieneMina()) {
                    int contadorMinas = 0;
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int filaVecina = fila + dx;
                            int columnaVecina = columna + dy;
                            if (coordenadaValida(filaVecina, columnaVecina) && celdas[filaVecina][columnaVecina].tieneMina()) {
                                contadorMinas++;
                            }
                        }
                    }
                    celdas[fila][columna].establecerCantidadMinasAlrededor(contadorMinas);
                }
            }
        }
    }

    public void mostrarTablero() {
        System.out.print("   ");
        for (int columna = 1; columna <= columnas; columna++) {
            System.out.print(columna + " ");
        }
        System.out.println();

        for (int fila = 0; fila < filas; fila++) {
            System.out.print(fila + 1 + "  ");
            for (int columna = 0; columna < columnas; columna++) {
                System.out.print(celdas[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    public boolean coordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public boolean descubrirCelda(int fila, int columna) {
        if (!coordenadaValida(fila, columna) || celdas[fila][columna].estaDescubierta()) {
            return false;
        }

        celdas[fila][columna].descubrir();

        if (celdas[fila][columna].tieneMina()) {
            return true;
        }

        if (celdas[fila][columna].obtenerCantidadMinasAlrededor() == 0) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    int filaVecina = fila + dx;
                    int columnaVecina = columna + dy;
                    if ((filaVecina != fila || columnaVecina != columna) && coordenadaValida(filaVecina, columnaVecina)) {
                        descubrirCelda(filaVecina, columnaVecina);
                    }
                }
            }
        }

        return false;
    }

    public void marcarCelda(int fila, int columna) {
        if (coordenadaValida(fila, columna)) {
            celdas[fila][columna].marcar();
        }
    }

    public boolean jugadorGano() {
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                if (!celdas[fila][columna].tieneMina() && !celdas[fila][columna].estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }
}
