package figueroaMarco;

class Buscaminas {

    private Tablero tablero;
    private Jugador jugador;

    public void jugar() {
        do { 
            Tablero.mostrar();
            Jugador.jugar(Tablero);
        } while (!Tablero.juegoTerminado());
        
    }
}
