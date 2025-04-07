package arellanoDiego;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador; 

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void jugar() {
        System.out.println("¡Bienvenido al Buscaminas!");
        System.out.println("Descubre todas las casillas sin minas para ganar.");
        
        do { 
            tablero.mostrar();
            jugador.jugar(tablero);
            
            if (tablero.resuelto()) {
                tablero.mostrar();
                System.out.println("¡Felicidades! Has ganado el juego.");
                break;
            }
            
            if (!jugador.vivo()) {
                tablero.mostrar();
                System.out.println("¡Has perdido! Mejor suerte la próxima vez.");
                break;
            }
            
        } while (true);
    }
}