package nicolasNavas;

import java.util.Scanner;

public class Player {
    private boolean isAlive;

    public Player() {
        isAlive = true;
    }

    public void play(Board instanceBoard) {
        Scanner input = new Scanner(System.in);

        System.out.print("Quieres (D)espejar o (M)arcar una casilla: ");
        String selection = input.next().toUpperCase();

        System.out.print("Ingresar fila: ");
        int row = input.nextInt();

        System.out.print("Ingresar columna: ");
        int column = input.nextInt();

        if (!instanceBoard.hasValidCoordinates(row, column)) {
            System.out.println("Coordenadas inválidas, ingrese coordenadas dentro del rango por favor");
            return;
        }

        if (selection.equals("M")) {
            instanceBoard.markFlag(row, column); // ✅ Fixed method name
        } else if (selection.equals("D")) {
            boolean result = instanceBoard.clearCell(row, column);
            if (!result) {
                isAlive = false; // ✅ Player dies if stepped on mine
                System.out.println("Mina pisada. Fin del juego.");
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }

    public boolean isAlive() {
        return isAlive;
    }
}
