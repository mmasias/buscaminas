package puenteSergio;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;
    private Scanner input;

    public Buscaminas() {
        input = new Scanner(System.in);
        inicializarJuego();
    }

    private void inicializarJuego() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void iniciar() {
        System.out.println("=== ¡Bienvenido al BUSCAMINAS 6x6! ===");

        do {
            jugarRonda();
        } while (preguntarReinicio());

        System.out.println("Gracias por jugar. ¡Nos vemos!");
        input.close();
    }

    private void jugarRonda() {
        while (jugador.sigueVivo() && !tablero.juegoTerminado()) {
            tablero.mostrarTablero(false);
            jugador.jugar(tablero, input);
        }

        tablero.mostrarTablero(true);

        if (!jugador.sigueVivo()) {
            System.out.println("💥 BOOM. Caíste en una mina. Fin del juego.");
        } else {
            System.out.println("🎉 ¡Victoria! Has despejado todas las casillas sin minas.");
        }
    }

    private boolean preguntarReinicio() {
        System.out.print("¿Deseas jugar otra partida? (si/no): ");
        String respuesta = input.next().trim().toLowerCase();
        return respuesta.equals("si");
    }

    public static void main(String[] args) {
        new Buscaminas().iniciar();
    }
}
