package cotareloDaniel;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Scanner entrada;
    private boolean juegoTerminado;

    public Buscaminas() {
        tablero = new Tablero();
        entrada = new Scanner(System.in);
        juegoTerminado = false;
    }

    public void jugar() {
        while (!juegoTerminado) {
            tablero.mostrarTableroVisible();

            System.out.print("[D]espejar o [M]arcar mina? ");
            char accion = entrada.next().charAt(0);
            System.out.println();

            System.out.println("Elija coordenada:");
            System.out.print("> Fila: ");
            int fila = entrada.nextInt() - 1;
            System.out.print("> Columna: ");
            int columna = entrada.nextInt() - 1;
            System.out.println();

        }
        entrada.close();
    }
}