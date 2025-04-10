package puenteSergio;

import java.util.Scanner;

public class Jugador {
    private boolean vivo = true;

    public boolean sigueVivo() {
        return vivo;
    }

    public void jugar(Tablero tablero, Scanner input) {
        System.out.print("Ingresa acción (d/m/x) y coordenadas (fila columna): ");
        String accion = input.next().toLowerCase();
        int fila = input.nextInt() - 1;
        int columna = input.nextInt() - 1;

        switch (accion) {
            case "d":
                if (!tablero.despejar(fila, columna)) {
                    vivo = false;
                }
                break;
            case "m":
                tablero.marcar(fila, columna);
                break;
            case "x":
                tablero.macroDespejar(fila, columna);
                break;
            default:
                System.out.println("Acción no válida. Usa 'd', 'm' o 'x'.");
        }
    }
}
