package solarAdrian;

public class Buscaminas {

    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new tablero();
        jugador = new Jugador();
    }

    public void jugar() {

        do {
            tablero.mostrar();
            jugador.jugar(tablero);
        } while(!tablero.finalizado());
    }
}