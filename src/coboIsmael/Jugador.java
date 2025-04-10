package coboIsmael;

import java.util.Scanner;

public class Jugador {

    private Scanner entrada;

    public Jugador() {
        entrada = new Scanner(System.in);
    }

    public void hacerJugada(Tablero tablero) {
        System.out.println("\n[D]espejar, [M]arcar mina o [X] Macrodespeje?");
        String opcion = entrada.nextLine().toUpperCase();

        System.out.println("\nElija coordenada:");
        System.out.print("> Fila: ");
        int fila = entrada.nextInt();
        System.out.print("> Columna: ");
        int columna = entrada.nextInt();
        entrada.nextLine();

        if (opcion.equals("D")) {
            tablero.despejar(fila - 1, columna - 1);
            System.out.println("\nCoordenada despejada");
        } else if (opcion.equals("M")) {
            tablero.marcar(fila - 1, columna - 1);
            System.out.println("\nCoordenada marcada");
        } else if (opcion.equals("X")) {
            MacroDespeje.hacerMacrodespeje(tablero, fila - 1, columna - 1);
            System.out.println("\nMacrodespeje realizado (celdas sin mina despejadas).");
        } else {
            System.out.println("Opción no válida.");
        }
    }
}