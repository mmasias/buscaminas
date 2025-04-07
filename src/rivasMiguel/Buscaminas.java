package rivasMiguel;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Acciones acciones;
    private Scanner scanner;

    public Buscaminas(int area, int cantidadMinas) {
        this.tablero = new Tablero(area, cantidadMinas);
        this.acciones = new Acciones();
        this.scanner = new Scanner(System.in);
    }

    public void jugar() {
        boolean jugando = true;

        while (jugando) {
            tablero.mostrarTablero();

            char accion = acciones.pedirAccion();
            int[] coordenadas = acciones.pedirCoordenadas();
            int fila = coordenadas[0];
            int columna = coordenadas[1];

            acciones.actualizarTablero(tablero, accion, fila, columna);

            if (tablero.comprobarDerrota(fila, columna, accion)) {
                tablero.hasPerdido();
                jugando = false;
            } else if (tablero.comprobarVictoria(tablero.getCantidadMinas())) {
                tablero.celebrarVictoria();
                jugando = false;
            }
        }

        System.out.println("Fin del juego.");
    }
}
