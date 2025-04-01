package doaltoBienvenido;

public class Buscaminas {

    private Tablero tablero;
    private Jugador jugador;
    private boolean juegoTerminado;
    private int casillasDescubiertas;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
        juegoTerminado = false;
        casillasDescubiertas = 0;
    }

    public void jugar() {
        do {
            tablero.mostrar();
            jugador.jugar(tablero);

        } while (juegoTerminado);

    }

}
