package solarAdrian;

public class BuscaMinas {

    private Tablero tablero;
    private Jugador jugador;

    public BuscaMinas() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void jugar() {
        System.out.println("¡Bienvenido al juego de BuscaMinas! Buena suerte.");
        do {
            tablero.mostrarTablero();
            jugador.realizarMovimiento(tablero);
        } while (!tablero.juegoCompletado() && jugador.estaVivo());
    }

    
    public static void main(String[] args) {
        BuscaMinas juego = new BuscaMinas();
        juego.jugar();
    }
}
