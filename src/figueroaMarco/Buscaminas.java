package figueroaMarco;

class Buscaminas {
    public void jugar() {
        do { 
            Tablero.mostrar();
            Jugador.jugar(Tablero);
        } while (!Tablero.juegoTerminado());
        
    }
}
