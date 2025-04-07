import java.util.Scanner;

class Buscaminas {

    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador("Jugador 1");
    }

    public void jugar() {
        Scanner sc = new Scanner(System.in);
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            tablero.mostrar();

            System.out.print("[D]espejar o [M]arcar mina? ");
            String accion = sc.nextLine().trim().toUpperCase();

            while (!accion.equals("D") && !accion.equals("M")) {
                System.out.print("> Acción inválida. Usa D o M: ");
                accion = sc.nextLine().trim().toUpperCase();
            }

            Coordenada coord = new Coordenada();
            coord.pedir();

            if (accion.equals("D")) {
                if (tablero.yaRevelada(coord)) {
                    System.out.println("¡Esa casilla ya fue despejada!");
                    continue;
                }

                boolean esMina = tablero.revelarCasilla(coord);

                if (esMina) {
                    tablero.mostrar();
                    System.out.println("Pisaste una mina. Fin del juego.");
                    juegoTerminado = true;
                } else if (tablero.juegoGanado()) {
                    tablero.mostrar();
                    jugador.celebrar();
                    juegoTerminado = true;
                }

            } else if (accion.equals("M")) {
                tablero.marcarCasilla(coord);
            }
        }

        sc.close();
    }
}
