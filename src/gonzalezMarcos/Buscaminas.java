package gonzalezMarcos;

public class Buscaminas{

    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void jugar(){
        tablero.mostrar();

        jugador.jugar(tablero);

        jugar(tablero, jugador);

        tablero.jugar(jugador);
    }
