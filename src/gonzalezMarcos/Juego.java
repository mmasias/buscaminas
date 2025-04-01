package gonzalezMarcos 

public class Juego {

    public void jugar() {

        do{
            tablero.mostrar();
            jugador.jugar(tablero);

        }while (!tablero.resuelto() && jugador.vivo());
    }
}