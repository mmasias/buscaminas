package calderonJimena;

import java.util.Random;

public class Tablero {
    private static final int CELDA_ADYACENTE_MIN = -1;
    private static final int CELDA_ADYACENTE_MAX = 1;

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
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                celdas[fila][columna] = new Celda();
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
        for (int filaActual = 0; filaActual < filas; filaActual++) {
            for (int columnaActual = 0; columnaActual < columnas; columnaActual++) {
                if (!celdas[filaActual][columnaActual].tieneMina()) {
                    int totalMinasCercanas = 0;

                    for (int desplazamientoFila = CELDA_ADYACENTE_MIN; desplazamientoFila <= CELDA_ADYACENTE_MAX; desplazamientoFila++) {
                        for (int desplazamientoColumna = CELDA_ADYACENTE_MIN; desplazamientoColumna <= CELDA_ADYACENTE_MAX; desplazamientoColumna++) {
                            int filaVecina = filaActual + desplazamientoFila;
                            int columnaVecina = columnaActual + desplazamientoColumna;

                            boolean esCeldaVecinaValida = coordenadaValida(filaVecina, columnaVecina);
                            boolean esCeldaConMina = esCeldaVecinaValida && celdas[filaVecina][columnaVecina].tieneMina();

                            if (esCeldaConMina) {
                                totalMinasCercanas++;
                            }
                        }
                    }

                    celdas[filaActual][columnaActual].establecerCantidadMinasAlrededor(totalMinasCercanas);
                }
            }
        }
    }

    public void mostrarTablero() {
        System.out.print("   ");
        for (int numeroColumna = 1; numeroColumna <= columnas; numeroColumna++) {
            System.out.print(numeroColumna + " ");
        }
        System.out.println();

        for (int fila = 0; fila < filas; fila++) {
            System.out.print((fila + 1) + "  ");
            for (int columna = 0; columna < columnas; columna++) {
                System.out.print(celdas[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    public boolean coordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public boolean descubrirCelda(int filaObjetivo, int columnaObjetivo) {
        if (!coordenadaValida(filaObjetivo, columnaObjetivo) || 
            celdas[filaObjetivo][columnaObjetivo].estaDescubierta()) {
            return false;
        }
 
        celdas[filaObjetivo][columnaObjetivo].descubrir();

        if (celdas[filaObjetivo][columnaObjetivo].tieneMina()) {
            revelarMinasAdyacentes(filaObjetivo, columnaObjetivo);
            return true;
        }

        boolean minaEncontrada = false;
        
        for (int desplazamientoFila = CELDA_ADYACENTE_MIN; desplazamientoFila <= CELDA_ADYACENTE_MAX; desplazamientoFila++) {
            for (int desplazamientoColumna = CELDA_ADYACENTE_MIN; desplazamientoColumna <= CELDA_ADYACENTE_MAX; desplazamientoColumna++) {
                int filaVecina = filaObjetivo + desplazamientoFila;
                int columnaVecina = columnaObjetivo + desplazamientoColumna;
    
                if (coordenadaValida(filaVecina, columnaVecina) && 
                    !(filaVecina == filaObjetivo && columnaVecina == columnaObjetivo)) {
                    
                    celdas[filaVecina][columnaVecina].descubrir();

                    if (celdas[filaVecina][columnaVecina].tieneMina()) {
                        minaEncontrada = true;
                    }
                }
            }
        }
    
        if (minaEncontrada) {
            revelarMinasAdyacentes(filaObjetivo, columnaObjetivo);
            return true;
        }
    
        return false;
    }
    
    private void revelarMinasAdyacentes(int filaCentral, int columnaCentral) {
        for (int desplazamientoFila = CELDA_ADYACENTE_MIN; desplazamientoFila <= CELDA_ADYACENTE_MAX; desplazamientoFila++) {
            for (int desplazamientoColumna = CELDA_ADYACENTE_MIN; desplazamientoColumna <= CELDA_ADYACENTE_MAX; desplazamientoColumna++) {
                int fila = filaCentral + desplazamientoFila;
                int columna = columnaCentral + desplazamientoColumna;
    
                if (coordenadaValida(fila, columna) && 
                    celdas[fila][columna].tieneMina()) {
                    
                    celdas[fila][columna].descubrir();
                }
            }
        }
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
