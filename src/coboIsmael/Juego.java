package coboIsmael;

public class Juego {
    private Jugador jugador;
    private Tablero tablero;

    public Juego() {
        jugador = new Jugador();
        tablero = new Tablero();
    }

    public void iniciar() {
        System.out.println("¡Bienvenido al Buscaminas!");

        while (!tablero.juegoTerminado(jugador)) {
            tablero.mostrarTablero();
            jugador.realizarJugada(tablero);
        }

        tablero.mostrarTablero();

        if (tablero.ganoJugador(jugador)) {
            System.out.println("¡Felicidades, has ganado!");
        } else {
            System.out.println("Has perdido. ¡Caiste en una mina!");
        }
    }
}
