package castilloCayetano;

import java.util.Scanner;

public class Jugador {
    private boolean vivo;

    public Jugador() {
        this.vivo = true;
    }

    public void jugador(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué deseas hacer? (1: Despejar, 2: Marcar):");
        int accion = scanner.nextInt();

        System.out.println("Introduce la fila y columna (separadas por un espacio):");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();

        if (accion == 1) {
            if (tablero.revelarCelda(fila, columna)) {
                System.out.println("¡Has pisado una mina! Fin del juego.");
                vivo = false;
            }
        } else if (accion == 2) {
            tablero.marcarCelda(fila, columna);
        } else {
            System.out.println("Acción no válida.");
        }
    }

    public boolean vivo() {
        return vivo;
    }
}