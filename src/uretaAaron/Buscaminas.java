package uretaAaron;

public class Buscaminas {

    private Tablero tablero;
    private jugador jugador;

    public Buscaminas () {
        tablero = new Tablero(filas, columnas, minas);
        jugador = new Jugador();
    }

    public void jugar () {
        do {
            Tablero.mostrar();
            jugador.jugar(tablero);
        } while (!tablero.despejado()&& juador.vivo());
    }
}