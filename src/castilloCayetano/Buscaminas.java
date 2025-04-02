package castilloCayetano;

public class Buscaminas {

    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        this.tablero = new Tablero(5, 5, 5);
        this.jugador = new Jugador();
    }

    public void jugar() {
        do {
            tablero.mostrar(false);
            jugador.jugador(tablero);
        } while (!tablero.despejado() && jugador.vivo());
    
        tablero.mostrar(true);
        if (tablero.despejado()) {
            System.out.println("¡Has ganado!");
        } else {
            System.out.println("¡Has perdido!");
        }
    }
}
