package calderonJimena;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Scanner entrada;

    public Buscaminas() {
        tablero = new Tablero(6, 6, 6); 
        entrada = new Scanner(System.in);
    }

    public void iniciarJuego() {
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            tablero.mostrarTablero();
            System.out.print("[D]espejar o [M]arcar mina? ");
            String accion = entrada.nextLine().toUpperCase();

            if (!accion.equals("D") && !accion.equals("M")) {
                System.out.println("Acción no válida. Elija 'D' para despejar o 'M' para marcar.");
                continue;
            }
      
            System.out.print("Elija coordenada: ");
            System.err.println();
            System.out.print("Fila: ");
            int filaSeleccionada = entrada.nextInt() - 1;
            System.out.print("Columna: ");
            int columnaSeleccionada = entrada.nextInt() - 1;
            entrada.nextLine();

            if (accion.equals("M")) {
                tablero.marcarCelda(filaSeleccionada, columnaSeleccionada);
                System.out.println("Coordenada marcada.");
            } else {
                if (tablero.descubrirCelda(filaSeleccionada, columnaSeleccionada)) {
                    tablero.mostrarTablero();
                    System.out.println("¡Has pisado una mina! Fin del juego.");
                    juegoTerminado = true;
                } else if (tablero.jugadorGano()) {
                    tablero.mostrarTablero();
                    System.out.println("¡Felicidades! Has ganado.");
                    juegoTerminado = true;
                }
            }
        }
    }
}
