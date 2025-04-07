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

            if (accion == 'D' || accion == 'd') {
                if (tablero.hayMina(fila, columna)) {
                    System.out.println("¡BOOM! Pisaste una mina. Has perdido.");
                    System.out.println();
                    tablero.mostrarTableroMinas();
                    juegoTerminado = true;
                } else {
                    tablero.despejar(fila, columna);
                    System.out.println("Coordenada despejada");
                    System.out.println();
                    if (tablero.verificarVictoria()) {
                        System.out.println("¡Felicidades! Has despejado todas las casillas. Has ganado.");
                        System.out.println();
                        tablero.mostrarTableroVisible();
                        juegoTerminado = true;
                    }
                }
            } else if (accion == 'M' || accion == 'm') {
                tablero.marcar(fila, columna);
                System.out.println("Coordenada marcada");
                System.out.println();
            } else {
                System.out.println("Acción no válida. Intente de nuevo.");
                System.out.println();
            }
        }
        entrada.close();
    }
}
