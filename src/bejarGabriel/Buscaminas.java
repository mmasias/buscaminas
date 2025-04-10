package bejarGabriel;

public class Buscaminas {
    private final Tablero tablero;
    private final Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero(6, 6);
        jugador = new Jugador();
    }

    public void iniciarJuego() {
        mostrarMensajeBienvenida();
        tablero.mostrarEstadoActual();

        while (true) {
            jugador.realizarJugada(tablero);
            tablero.mostrarEstadoActual();

            if (jugador.haPerdido()) {
                mostrarMensajeDerrota();
                tablero.revelarTodasLasMinas();
                break;
            }

            if (tablero.estaCompleto()) {
                mostrarMensajeVictoria();
                break;
            }
        }
    }

    private void mostrarMensajeBienvenida() {
        System.out.println("¡Bienvenido a Buscaminas!");
        System.out.println("Descubre todas las casillas sin minas para ganar.");
    }

    private void mostrarMensajeDerrota() {
        System.out.println("¡BOOM! Has pisado una mina. Juego terminado.");
        System.out.println("Posiciones de las minas:");
    }

    private void mostrarMensajeVictoria() {
        System.out.println("¡Felicidades! Has ganado el juego.");
    }
}