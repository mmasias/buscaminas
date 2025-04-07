package linaresJaime;

import java.util.Scanner;

public class Jugador {
    private final Scanner scanner = new Scanner(System.in);

    public char pedirAccion() {
        while (true) {
            String entrada = scanner.nextLine().trim().toUpperCase();
            if (entrada.equals("D") || entrada.equals("M")) {
                return entrada.charAt(0);
            }
            System.out.println("Entrada inválida. Use D o M.");
        }
    }

    public int pedirCoordenada(String tipo) {
        System.out.print("> " + tipo + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
