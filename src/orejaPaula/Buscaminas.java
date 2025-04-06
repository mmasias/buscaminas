package orejaPaula;

import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero(8, 8, 10); // Tablero de 8x8 con 10 minas
        
        while (!tablero.esJuegoTerminado()) {
            tablero.imprimirTablero();
            System.out.print("Introduce fila y columna (ejemplo: 3 4): ");
            
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
            
            if (fila < 0 || fila >= 8 || columna < 0 || columna >= 8) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }

            tablero.revelarCelda(fila, columna);
        }

        tablero.imprimirTablero();
        System.out.println("Juego terminado.");
        scanner.close();
    }
}
