package caicedoFernando;

import java.util.Scanner;

public class Jugador {

    private final Scanner scanner;

    public Jugador() {
        this.scanner = new Scanner(System.in);
    }

    public char pedirAccion() {
        while (true) {
            System.out.println("[D]espejar o [M]arcar mina o o [X] Macrodespeje?");
            String entrada = scanner.nextLine().toUpperCase();

            if (entrada.equals("D")) {
                return 'D';
            } else if (entrada.equals("M")) {
                return 'M';
            } else if (entrada.equals("X")) {
                return 'X';
            } else {
                System.out.println("Acción inválida.");
            }
        }
    }

    public Coordenada pedirCoordenada() {
        int fila = pedirEntero("> Fila: ");
        int columna = pedirEntero("> Columna: ");
        return new Coordenada(fila - 1, columna - 1);
    }

    private int pedirEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } else {
                System.out.println("Entrada inválida. Por favor ingresa un número entero.");
                scanner.nextLine();
            }
        }
    }
}
