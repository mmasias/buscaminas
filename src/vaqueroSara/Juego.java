package buscaminas.src.vaqueroSara;

import java.util.Scanner;

public class Juego {

    private Tablero tablero;
    private boolean juegoTerminado;

    public Juego(int filas, int columnas, int minas) {

        tablero = new Tablero(filas, columnas, minas);
        juegoTerminado = false;
    }

    public void iniciarJuego() {

        Scanner scanner = new Scanner(System.in);

        while (!juegoTerminado) {
            
            tablero.imprimirTablero();
            System.out.println("Elige una acción:");
            System.out.println("1. Descubrir casilla");
            System.out.println("2. Marcar casilla");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingresa fila y columna (separados por espacio): ");
                int fila = scanner.nextInt();
                int columna = scanner.nextInt();
                if (tablero.esMina(fila, columna)) {
                    System.out.println("¡Perdiste! Has tocado una mina.");
                    tablero.imprimirTablero();
                    juegoTerminado = true;
                } else {
                    tablero.descubrirCasilla(fila, columna);
                }
            } else if (opcion == 2) {
                System.out.print("Ingresa fila y columna para marcar: ");
                int fila = scanner.nextInt();
                int columna = scanner.nextInt();
                tablero.marcarCasilla(fila, columna);
            } else if (opcion == 3) {
                System.out.println("Saliendo del juego...");
                juegoTerminado = true;
            }
        }
    }
}
