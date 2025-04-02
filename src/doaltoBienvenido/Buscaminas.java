package doaltoBienvenido;

import java.util.Scanner;

public class Buscaminas {
    Scanner scanner = new Scanner(System.in);
    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void jugar() {
        do {
            reiniciar();
            do {
                tablero.mostrar();
                jugador.jugar(tablero);
            } while (!tablero.finalizado() && jugador.sigueVivo());

            if (tablero.finalizado()) {
                System.out.println("Has despejado todas las casillas, Ganaste!!");
            }

        } while (juegoNuevo());

    }

    private boolean juegoNuevo() {
        System.out.println("Jugar de nuevo? (si/no)");
        String respuesta = scanner.next().toLowerCase();
        return respuesta.equals("si");
    }

    private void reiniciar() {
        tablero = new Tablero();
        jugador = new Jugador();
    }
}
