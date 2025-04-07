package zablahBernardo;

import java.util.Scanner;

public class Jugador {

    private boolean vivo;

    public Jugador() {
        vivo = true;
    }

    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa fila: ");
        int fila = scanner.nextInt();
        System.out.print("Ingresa columna: ");
        int columna = scanner.nextInt();

        boolean resultado = tablero.descubrir(fila, columna);
        if (!resultado) {
            vivo = false;
            System.out.println("¡BOOM! Pisaste una mina ");
        }
    }

    public boolean vivo() {
        return vivo;
    }

}
