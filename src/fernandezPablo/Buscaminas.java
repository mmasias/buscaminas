public class Buscaminas {

    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();

    }

    public void jugar() {
        do {
            tablero.mostrarTablero();
            jugador.jugar(tablero);
        }while (!tablero.juegoCompletado() && jugador.estaVivo());
    }

}
