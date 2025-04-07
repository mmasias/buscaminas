package solarAdrian;

import java.util.Scanner;

public class Jugador {
    private boolean vivo = true;

    public void jugar(Tablero tablero, Scanner scanner) {
        System.out.println("Ingrese coordenada (fila y columna) entre 1 y 6:");
        int fila = scanner.nextInt() - 1; 
        int columna = scanner.nextInt() - 1; 

        if (!tablero.coordenadaValida(fila, columna)) {
            System.out.println("Coordenada inválida, por favor intente de nuevo.");
            return;
        }

        if (tablero.esMina(fila, columna)) {
            System.out.println("¡BOOM! Has explotado una mina y has perdido.");
            tablero.mostrarMina(fila, columna);
            vivo = false; 
        } else {
            tablero.despejarCasilla(fila, columna);
            System.out.println("Casilla despejada con éxito.");
        }
    }

    public boolean sigueVivo() {
        return vivo;
    }
}