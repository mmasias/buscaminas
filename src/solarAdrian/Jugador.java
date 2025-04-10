package solarAdrian;

import java.util.Scanner;

public class Jugador {

    private boolean sigueJugando;

    public Jugador() {
        sigueJugando = true;
    }

    public void realizarMovimiento(Tablero tablero) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Elige acción: (D)espejar, (M)arcar o usar (B)omba: ");
            String accion = entrada.next().trim().toUpperCase();

            System.out.print("Introduce la fila: ");
            int fila = entrada.nextInt();

            System.out.print("Introduce la columna: ");
            int columna = entrada.nextInt();

            if (!tablero.coordenadaValida(fila, columna)) {
                System.out.println(" Coordenadas fuera de rango. Intenta otra vez.");
                return;
            }

            switch (accion) {
                case "M":
                    tablero.alternarBandera(fila, columna);
                    System.out.println(" Casilla marcada/desmarcada.");
                    break;

                case "D":
                    boolean despejeExitoso = tablero.despejarCasilla(fila, columna);
                    if (!despejeExitoso) {
                        sigueJugando = false;
                        System.out.println(" ¡Oh no! Has pisado una mina. Fin del juego.");
                    } else {
                        System.out.println("✅ Casilla despejada.");
                    }
                    break;

                case "B":
                    boolean resultadoBomba = tablero.usarBomba(fila, columna);
                    if (!resultadoBomba) {
                        sigueJugando = false;
                        System.out.println(" La bomba explotó sobre una mina. Fin del juego.");
                    } else {
                        System.out.println(" Bomba utilizada con éxito. Zona despejada.");
                    }
                    break;

                default:
                    System.out.println(" Opción no válida. Intenta de nuevo.");
            }
        }

        if (sigueJugando && tablero.juegoCompletado()) {
            tablero.mostrarTablero();
            System.out.println("🎉 ¡Has despejado todas las casillas sin minas! ¡Ganaste!");
            sigueJugando = false;
        }
    }

    public boolean estaVivo() {
        return sigueJugando;
    }
}
