package arellanoDiego;

import java.util.Scanner;

public class Jugador {
    private boolean estaVivo = true;

    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);
        int fila, columna;
        
        System.out.println("Ingresa las coordenadas (fila y columna) para despejar:");
        System.out.print("Fila (1-" + Tablero.DIMENSION + "): ");
        fila = scanner.nextInt() - 1;
        System.out.print("Columna (1-" + Tablero.DIMENSION + "): ");
        columna = scanner.nextInt() - 1;
        
        if (fila < 0 || fila >= Tablero.DIMENSION || columna < 0 || columna >= Tablero.DIMENSION) {
            System.out.println("Coordenadas inválidas. Intenta de nuevo.");
            return;
        }
        
        if (tablero.hayMina(fila, columna)) {
            estaVivo = false;
            System.out.println("¡BOOM! Has pisado una mina. Juego terminado.");
        } else {
            tablero.despejarCasilla(fila, columna);
            System.out.println("Casilla despejada con éxito.");
        }

    }

    public boolean vivo() {
        return estaVivo;
    }
}