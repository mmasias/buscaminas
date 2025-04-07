package rubioRicardo;

import java.util.Scanner;

public class Jugador {
    private boolean estaVivo;

    public Jugador() {
        estaVivo = true;
    }

    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Quieres (D)espejar o (M)arcar una casilla? ");
        String seleccion = scanner.next().toUpperCase();

        System.out.print("Ingresa fila: ");
        int fila = scanner.nextInt();

        System.out.print("Ingresa columna: ");
        int columna = scanner.nextInt();

        if (!tablero.esCoordenadaValida(fila, columna)) {
            System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
            return;
        }

        if (seleccion.equals("M")) {
            tablero.marcarConBandera(fila, columna);
        } else if (seleccion.equals("D")) {
            boolean resultado = tablero.despejarCasilla(fila, columna);
            if (!resultado) {
                estaVivo = false;
                System.out.println("¡BOOM! Pisaste una mina. Fin del juego.");
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }

    public boolean estaVivo() {
        return estaVivo;
    }
}
