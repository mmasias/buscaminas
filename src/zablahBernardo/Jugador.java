package zablahBernardo;

import java.util.Scanner;

public class Jugador {

    private boolean vivo;

    public Jugador() {
        vivo = true;
    }

    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Deseas (D)espejar, (M)arcar o (S)uperDespejar una casilla? ");
        String accion = scanner.next().toUpperCase();

        System.out.print("Ingresa fila: ");
        int fila = scanner.nextInt();

        System.out.print("Ingresa columna: ");
        int columna = scanner.nextInt();

        if (accion.equals("M")) {
            tablero.marcar(fila, columna);
        } else if (accion.equals("D")) {
            boolean resultado = tablero.despejar(fila, columna);
            if (!resultado) {
                vivo = false;
                System.out.println("¡BOOM! Pisaste una mina!");
            } 
        } else if (accion.equals("S")) {
            boolean resultado = tablero.superDespejar(fila, columna);
            if (!resultado) {
                vivo = false;
                System.out.println("¡BOOM! Pisaste una mina!");
            }
        }
    }

    public boolean vivo() {
        return vivo;
    }

}
