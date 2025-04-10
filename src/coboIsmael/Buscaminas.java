package coboIsmael;
public class Buscaminas {

    public void jugar() {
        Tablero tablero = new Tablero();              
        Jugador jugador = new Jugador();              
        
        System.out.println("¡Bienvenido al Buscaminas!");

        while (!tablero.juegoTerminado()) {           
            tablero.mostrar();                        
            jugador.hacerJugada(tablero);             
        }

        tablero.mostrar();                            

        if (tablero.gano()) {
            System.out.println("¡Felicidades, has ganado!");
        } else {
            System.out.println("Has perdido. ¡Caiste en una mina!");
        }
    }
}
