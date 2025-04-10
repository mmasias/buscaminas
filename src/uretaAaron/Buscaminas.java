package uretaAaron;

import java.util.Scanner;

public class Buscaminas {

    public Tablero tablero;
    public Jugador jugador;
    private boolean juegoTerminado = false;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        juegoTerminado = false;

        System.out.print("Selecciona tamaño del tablero: ");
        int size = scanner.nextInt();
        System.out.print("Selecciona número de minas: ");
        int minas = scanner.nextInt();

        tablero.asignarTablero(size);
        tablero.asignarNumMinas(minas);

        while (!juegoTerminado) {
            tablero.mostrar();
            System.out.print("[D]espejar o [M]arcar mina? ");
            char accion = scanner.next().toUpperCase().charAt(0);
            char modoDespeje = 'P';

            if (accion == 'D') {
                System.out.print("[P]unto o [C]uadro completo: ");
                modoDespeje = scanner.next().toUpperCase().charAt(0);
            }

            System.out.println("Elija coordenada:");
            System.out.print("> Fila: ");
            int fila = scanner.nextInt() - 1;
            System.out.print("> Columna: ");
            int columna = scanner.nextInt() - 1;

            if (accion == 'D') {
                if (!jugador.despejar(tablero, fila, columna, modoDespeje)) {
                    System.out.println("💥 ¡Boom! Has pisado una mina.");
                    tablero.revelarTodo();
                    tablero.mostrar();
                    juegoTerminado = true;
                }
            } else if (accion == 'M') {
                jugador.marcar(tablero, fila, columna);
            } else {
                System.out.println("Acción no reconocida.");
            }

            if (tablero.haGanado()) {
                System.out.println("🎉 ¡Felicidades! Has ganado.");
                tablero.mostrar();
                juegoTerminado = true;
            }
        }

        scanner.close();
    }
}
