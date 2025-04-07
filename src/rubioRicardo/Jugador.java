package rubioRicardo;

import java.util.Scanner;

public class Jugador {
    private boolean estavivo;

    public Jugador() {
        estavivo = true;
    }


    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Quieres (D)espejar o (M)arcar una casilla? ");
        String seleccion = scanner.next().toUpperCase();

        System.out.print("Ingresa fila: ");
        int fila = scanner.nextInt();

        System.out.print("Ingresa columna: ");
        int columna = scanner.nextInt();

        if (seleccion.equals("M")) {
            tablero.marcar(fila, columna);
        } else if (seleccion.equals("D")) {
            boolean resultado = tablero.despejar(fila, columna);
            if (!resultado) {
                estavivo = false;
                System.out.println("Pisaste una mina. Fin del juego.");
            } 
        } 
    }

    public boolean vivo() {
        return estavivo;
    }
}
