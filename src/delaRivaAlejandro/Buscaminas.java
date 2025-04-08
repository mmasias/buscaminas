package delarivaAlejandro.Buscaminas;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        this.tablero = new Tablero();
        this.jugador = new Jugador();
    }

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            tablero.mostrar();
            System.out.print("[D]espejar o [M]arcar mina? ");
            char accion = scanner.next().charAt(0);

            System.out.println("\nIngrese coordenada:");
            System.out.print("> Fila: ");
            int fila = scanner.nextInt() - 1;
            System.out.print("> Columna: ");
            int columna = scanner.nextInt() - 1;

            if (Character.toUpperCase(accion) == 'D') {
                if (!jugador.despejar(tablero, fila, columna)) {
                    System.out.println("¡Boom! Has pisado una mina. ¡Juego terminado!");
                    juegoTerminado = true;
                }
            } else if (Character.toUpperCase(accion) == 'M') {
                jugador.marcar(tablero, fila, columna);
            }

            if (tablero.haGanado()) {
                System.out.println("¡Felicidades! Has ganado el juego.");
                juegoTerminado = true;
            }
        }

        scanner.close();
    }
}
