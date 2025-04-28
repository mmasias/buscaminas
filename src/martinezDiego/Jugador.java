
package martinezDiego;

import java.util.Scanner;

public class Jugador {
    private Scanner scanner = new Scanner(System.in);

    public void jugarTurno(Tablero tablero) {
        System.out.println("¿Qué deseas hacer? (1 -> Marcar casilla, 2 -> Poner bandera, 3 -> Despejar casillas):");

        int eleccion = scanner.nextInt();
        int fila, columna = 0;

        switch (eleccion) {
            case 1:
                System.out.println("fila:");
                fila = scanner.nextInt();
                System.out.println("columna:");
                columna = scanner.nextInt();
                tablero.marcarCasilla(fila, columna);
                break;

            case 2:
                System.out.println("fila:");
                fila = scanner.nextInt();
                System.out.println("columna:");
                columna = scanner.nextInt();
                tablero.colocarBandera(fila, columna);
                break;

            case 3:
                System.out.println("fila:");
                fila = scanner.nextInt();
                System.out.println("columna:");
                columna = scanner.nextInt();
                tablero.enseñarCasillas(fila, columna);
                break;

            default:
                break;
        }

    }
}