import java.util.Scanner;

public class Acciones {

    public char pedirAccion() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[D]espejar o [M]arcar mina?");
        char accion = sc.next().toUpperCase().charAt(0);

        return accion;
    }

    private int[] pedirCoordenadas() {
        Scanner sc = new Scanner(System.in);
        int[] coordenadas = new int[2];

        System.out.println("Elija coordenada:");
        System.out.print("> Fila: ");
        coordenadas[0] = sc.nextInt();
        System.out.print("> Columna: ");
        coordenadas[1] = sc.nextInt();

        return coordenadas;
    }

    private void actualizarTablero(Tablero tablero, char accion, int fila, int columna) {
        if (accion == 'D') {
            tablero.getTablero()[fila][columna] = 'D';
        } else if (accion == 'M') {
            tablero.getTablero()[fila][columna] = 'M';
        }
    }
}
