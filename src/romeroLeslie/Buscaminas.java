public class Buscaminas{

    private Tablero tablero;
    private PartidaBuscaminas partidaBuscaminas;

    public Buscaminas() {
        tablero = new Tablero();
        partidaBuscaminas = new PartidaBuscaminas();

    }

    public void jugar() {
        do {
            tablero.mostrarTablero();
            partidaBuscaminas.jugar(tablero);
        }while (!tablero.juegoCompletado() && partidaBuscaminas.estaVivo());
    }

}