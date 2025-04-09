package doaltoBienvenido;

import java.util.Scanner;

public class Jugador {

    private boolean vivo;
    private int fila;
    private int columna;

    public Jugador() {
        vivo = true;
    }

    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingrese coordenada (1-6)");
            fila = scanner.nextInt() - 1;
            columna = scanner.nextInt() - 1;

            if (!tablero.coordenadaValida(fila, columna)) {
                System.out.println("Coordenada inválida, vuelva a intentarlo.");
            }
        } while (!tablero.coordenadaValida(fila, columna));

        if (tablero.esMina(fila, columna)) {
            tablero.mostrarMina(fila, columna);
            vivo = false;
        } else {
            tablero.despejarCasilla(fila, columna);
        }
    }

    public boolean sigueVivo() {
        return vivo;
    }
}
