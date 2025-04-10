public class buscaminas {
    private tablero tablero;
    private jugador jugador;

    public buscaminas(){
        tablero = new tablero();
        jugador = new jugador();
    }

    public void play(){
        do {
            tablero.showtablero();
            jugador.play(tablero);
        }while(!tablero.isComplete() && jugador.isAlive());
    }
}