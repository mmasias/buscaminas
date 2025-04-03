package rivasMiguel;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Acciones acciones;
    private Scanner scanner;

    public Buscaminas(int filas, int columnas, int cantidadMinas) {
        this.tablero = new Tablero(filas, columnas, cantidadMinas);
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
            } 
            else if (tablero.comprobarVictoria(tablero.tablero.length - 1, tablero.tablero[0].length - 1, tablero.minas.length)) {
                tablero.celebrarVictoria();
                jugando = false;
            }
        }

        System.out.println("Fin del juego.");
    }
}
