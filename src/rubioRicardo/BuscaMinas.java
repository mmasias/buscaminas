package rubioRicardo;

public class BuscaMinas {

    private Tablero tablero;
    private Jugador jugador;

    public BuscaMinas() {
        tablero = new Tablero();
        jugador = new Jugador();

    }

    public void jugar() {
        do {
            tablero.mostrar();
            jugador.jugar(tablero);
        }while (!tablero.completado() && jugador.vivo());
    }

}
