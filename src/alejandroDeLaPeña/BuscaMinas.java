package entregas.deLaPeñaAlejandro;

import java.util.Scanner;

public class BuscaMinas {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(6, 6, 6);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            tablero.imprimirTablero();
            System.out.println("[D]espejar, [M]arcar mina o [X] Macrodespejar?");
            String accion = scanner.nextLine().toUpperCase();

            System.out.println("Elija coordenada:");
            System.out.print("> Fila: ");
            int fila = scanner.nextInt() - 1;
            System.out.print("> Columna: ");
            int columna = scanner.nextInt() - 1;
            scanner.nextLine(); 

            if (fila < 0 || fila >= tablero.getFilas() || columna < 0 || columna >= tablero.getColumnas()) {
                System.out.println("Coordenadas inválidas. Intente de nuevo.");
                continue;
            }

            if (accion.equals("D")) {
                if (tablero.despejarCasilla(fila, columna)) {
                    System.out.println("¡Has perdido! Había una mina.");
                    tablero.revelarTodo();
                    tablero.imprimirTablero();
                    break;
                }
            } else if (accion.equals("M")) {
                tablero.marcarCasilla(fila, columna);
            } else if (accion.equals("X")) {
                tablero.macroDespejar(fila, columna);
            } else {
                System.out.println("Acción inválida. Intente de nuevo.");
            }

            if (tablero.esVictoria()) {
                System.out.println("¡Felicidades! Has despejado todas las casillas sin minas.");
                tablero.imprimirTablero();
                break;
            }
        }

        scanner.close();
    }
}

