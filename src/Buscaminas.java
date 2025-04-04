import java.util.Scanner;

public class Buscaminas{
    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas(){
        this.tablero = new Tablero(6);
        this.jugador = new Jugador(System.in);
    }

    public void iniciar() {
        while(true){
            tablero.imprimirTablero();
            System.out.println("[D]espejar o [M]arcar mina?");
            
        }






    }
}