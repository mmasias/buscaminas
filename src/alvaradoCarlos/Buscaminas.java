package alvaradoCarlos;

import java.util.Scanner;

public class Buscaminas {

    private Tablero tablero;
    private Scanner scanner;
    private Jugador jugador;

    public Buscaminas(int[] dimensiones, int minas) {
        this.tablero = new Tablero(dimensiones, minas);
        this.jugador = new Jugador(tablero);
        this.scanner = new Scanner(System.in);
    }

    public void jugar() {
        while (jugador.jugando()) {
            tablero.mostrarTablero();

            char opcion = jugador.actuar();
            int[] coordenadas = jugador.pedirCoordenadas(scanner);

            jugador.actualizarTablero(opcion, coordenadas);

            if (jugador.perdio()) {
                System.out.println("¡Perdiste!");
            } else if (jugador.gano()){
                System.out.println("Ganaste!");
            }
        }
    }
}
