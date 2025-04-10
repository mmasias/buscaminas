import java.util.Scanner;

public class jugador {
    private boolean isAlive;

    public jugador() {
        isAlive = true;
    }

    public void play(tablero instancetablero) {
        Scanner input = new Scanner(System.in);

        System.out.print("¿Quieres (D)espejar, (M)arcar o (X) macrodespejar?: ");
        String selection = input.next().toUpperCase();

        System.out.print("Ingresar fila: ");
        int row = input.nextInt();

        System.out.print("Ingresar columna: ");
        int column = input.nextInt();

        if (!instancetablero.hasValidCoordinates(row, column)) {
            System.out.println("Coordenadas inválidas, ingrese coordenadas dentro del rango por favor");
            return;
        }

        switch (selection) {
            case "M":
                instancetablero.markFlag(row, column);
                break;
            case "D":
                boolean result = instancetablero.clearCell(row, column);
                if (!result) {
                    isAlive = false;
                    System.out.println("Mina pisada. Fin del juego.");
                }
                break;
            case "X":
                instancetablero.macroDespeje(row, column);
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }
}
