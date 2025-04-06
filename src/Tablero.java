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
    for (int fila = 0; fila < totalFilas; i++) {
        for (int columna = 0; columna < totalColumnas; j++) {
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




}