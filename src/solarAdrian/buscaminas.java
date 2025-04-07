package solarAdrian;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;
    private Scanner scanner;

    public Buscaminas() {
        scanner = new Scanner(System.in);
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void jugar(){
        System.out.println("=== Bienvenido a Buscaminas 6x6 ===");
        boolean continuar = true;

        while (continuar && jugador.sigueVivo() && !tablero.juegoTerminado()) {
            tablero.mostrarTablero(false);
            jugador.jugar(tablero, scanner);
        }

        tablero.mostrarTablero(true); 

        if (!jugador.sigueVivo()) {
            System.out.println("Juego terminado. Has perdido.");
        } else if (tablero.juegoTerminado()) {
            System.out.println("¡Felicidades! Has despejado todas las casillas sin minas.");
        }

        continuar = jugarDeNuevo();
        if (continuar) {
            reiniciar();
            jugar();
        } else {
            System.out.println("Gracias por jugar. ¡Hasta la próxima!");
            scanner.close();
        }
    }

    private void reiniciar() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    private boolean jugarDeNuevo() {
        System.out.print("¿Quieres jugar otra vez? (si/no): ");
        String respuesta = scanner.next().toLowerCase();
        return respuesta.equals("si");
    }
}