import java.util.Scanner;

public class jugador {
    private boolean isAlive;

    public jugador() {
        isAlive = true;
    }

    public void play(tablero instancetablero) {
        Scanner input = new Scanner(System.in);

        System.out.print("Quieres (D)espejar o (M)arcar una casilla: ");
        String selection = input.next().toUpperCase();

        System.out.print("Ingresar fila: ");
        int row = input.nextInt();

        System.out.print("Ingresar columna: ");
        int column = input.nextInt();

        if (!instancetablero.hasValidCoordinates(row, column)) {
            System.out.println("Coordenadas inválidas, ingrese coordenadas dentro del rango por favor");
            return;
        }

        if (selection.equals("M")) {
            instancetablero.markFlag(row, column); // ✅ Fixed method name
        } else if (selection.equals("D")) {
            boolean result = instancetablero.clearCell(row, column);
            if (!result) {
                isAlive = false; // ✅ jugador dies if stepped on mine
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
