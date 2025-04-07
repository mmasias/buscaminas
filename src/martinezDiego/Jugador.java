
package martinezDiego;


import java.util.Scanner;

public class Jugador {
    private Scanner scanner = new Scanner(System.in);

    public void jugarTurno(Tablero tablero) {
        System.out.println("¿Qué deseas hacer? (1 -> Marcar casilla, 2 -> Poner bandera):");
        int opcion = scanner.nextInt();

        System.out.println("fila:");
        int fila = scanner.nextInt();
        System.out.println("columna:");
        int columna = scanner.nextInt();

        if (opcion == 1) {
            tablero.revelarCasilla(fila, columna);
        } else if (opcion == 2) {
            tablero.colocarBandera(fila, columna);
        } else {
            System.out.println("Opción inválida.");
        }
    }  
}