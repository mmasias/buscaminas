package arellanoDiego;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador; 

    public Buscaminas(){
        tablero = new Tablero();
        jugador = new Jugador();
    }
    public void jugar() {
        do { 
           tablero.mostrar();
           jugador.jugar(tablero);
        } while (!tablero.resuelto() && jugador.vivo());
    }
}
