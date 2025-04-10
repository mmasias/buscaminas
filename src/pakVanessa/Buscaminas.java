package pakVanessa;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        do {
            tablero.mostrar();
            System.out.print("[D]espejar, [S]uper despeje o [M]arcar mina? ");
            char accion = scanner.next().charAt(0);

            System.out.println("\nElija coordenada:");
            System.out.print("> Fila: ");
            int fila = scanner.nextInt() - 1;
            System.out.print("> Columna: ");
            int columna = scanner.nextInt() - 1;

            if (accion == 'D' || accion == 'd') {
                if (!jugador.despejar(tablero, fila, columna)) {
                    tablero.mostrar();
                    System.out.println("¡Boom! Has pisado una mina. ¡Juego terminado!");
                    juegoTerminado = true;
                }
            } else if (accion == 'M' || accion == 'm') {
                jugador.marcar(tablero, fila, columna);
            } else if (accion == 'S' || accion == 's') {
                boolean explotó = false;

                for (int i = fila - 1; i <= fila + 1 && !explotó; i++) {
                    for (int j = columna - 1; j <= columna + 1 && !explotó; j++) {
                        if (tablero.esCoordenadaValida(i, j)) {
                            if (!jugador.despejar(tablero, i, j)) {
                                explotó = true;
                            }
                        }
                    }
                }

                if (explotó) {
                    tablero.mostrar();
                    System.out.println("¡Boom! Una mina fue activada durante el super despeje. ¡Juego terminado!");
                    juegoTerminado = true;
                }
            }

            if (tablero.haGanado()) {
                tablero.mostrar();
                System.out.println("¡Felicidades! Has despejado todas las casillas sin mina.");
                juegoTerminado = true;
            }

        } while (!juegoTerminado);

        scanner.close();
    }
}
