package linaresJaime;

public class Buscaminas {
    private final Tablero tablero;
    private final Jugador jugador;

    public Buscaminas() {
        this.tablero = new Tablero(6, 6, 6); // 6x6 con 6 minas
        this.jugador = new Jugador();
    }

    public void jugar() {
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            tablero.mostrarTablero();
            char accion = jugador.pedirAccion();

            int fila = jugador.pedirCoordenada("Fila") - 1;
            int columna = jugador.pedirCoordenada("Columna") - 1;

            if (accion == 'D') {
                if (tablero.despejar(fila, columna)) {
                    System.out.println("Coordenada despejada\n");
                    if (tablero.juegoGanado()) {
                        tablero.mostrarTableroFinal();
                        System.out.println("¡Has ganado!");
                        juegoTerminado = true;
                    }
                } else {
                    tablero.mostrarTableroFinal();
                    System.out.println("¡Boom! Has perdido.");
                    juegoTerminado = true;
                }
            } else if (accion == 'M') {
                tablero.marcar(fila, columna);
                System.out.println("Coordenada marcada\n");
            }
        }
    }
}
