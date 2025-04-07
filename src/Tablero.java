package buscaminas.src;
import java.util.Scanner;
import java.util.Random;


public class Tablero {
private Celda[][] tablero;
private final int totalFilas = 6;
private final int totalColumnas = 6;
private final int totalMinas = 6;

public Tablero(){
    celdas = new Celda[totalFilas][totalColumnas];
    for (int fila = 0; fila < totalFilas; fila++) {
        for (int columna = 0; columna < totalColumnas; columna++) {
            celdas[fila][columna] = new Celda();
        }
    }
     colocarMinasAleatoriamente();
     calcularMinasCercanas();
}

private void colocarMinasAleatoriamente(){
    Random random = new Random();
    int minasColocadas = 0;

    while (minasColocadas < totalMinas) {
        int fila = random.nextInt(totalFilas);
        int columna = random.nextInt(totalColumnas);
        if (!celdas[fila][columna].tieneMina()) {

            celdas[fila][columna].ponerMina(true);
            minasColocadas++;
        }
    }
}

private void calcularMinasCercanas(){
    for (int fila = 0; fila < totalFilas; i++) {
        for (int columna = 0; columna < totalColumnas; cowlumna++) {
            if (!celdas[fila][columna].tieneMina()) {
                int minasCercanas = contarMinasCercanas(fila, columna);
                celdas[fila][columna].colocarMinasCercanas(minasCercanas);
            }
        }
    }

}

public boolean despejarCasilla(int fila,int columna){
  if (celdas[fila][columna].casillaRevelada() || celdas[fila][columna].casillaMarcada()) {
            return true;
        }

        celdas[fila][columna].revelar();
        return !celdas[fila][columna].tieneMina();

}

public void marcarCasilla(int fila, int columna) {
        if (!celdas[fila][columna].casillaRevelada()) {
            celdas[fila][columna].alternarMarca();
        }
    }


}

private int contarMinasCercanas(int fila, int columna) {
    int minasCercanas = 0;
    for (int fila = -1; fila <= 1; fila++) {
        for (int columna = -1; columna <= 1; columna++) {
            if (fila == 0 && columna == 0) continue; 
            int nuevaFila = fila + fila;
            int nuevaColumna = columna + columna;
            if (nuevaFila >= 0 && nuevaFila < totalFilas && nuevaColumna >= 0 && nuevaColumna < totalColumnas) {
                if (celdas[nuevaFila][nuevaColumna].tieneMina()) {
                    minasCercanas++;
                }
            }
        }
    }
    return minasCercanas;
}

