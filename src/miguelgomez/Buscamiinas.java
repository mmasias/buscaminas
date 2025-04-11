package miguelgomez;


import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero(6, 6, 6);

        while (true) {
            tablero.mostrarTablero();

            System.out.println("Selecciona una acción:");
            System.out.println("[D] Despejar | [M] Marcar mina | [X] Macrodespejar");
            String accion = scanner.nextLine().trim().toUpperCase();

            System.out.println("Introduce las coordenadas:");
            System.out.print("Fila: ");
            int fila = scanner.nextInt() - 1;

            System.out.print("Columna: ");
            int columna = scanner.nextInt() - 1;
            scanner.nextLine();

            if (!tablero.coordenadasValidas(fila, columna)) {
                System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
                continue;
            }

            switch (accion) {
                case "D":
                    if (tablero.despejarCasilla(fila, columna)) {
                        System.out.println("¡BOOM! Has pisado una mina.");
                        tablero.revelarMinas();
                        tablero.mostrarTablero();
                        return;
                    }
                    break;
                case "M":
                    tablero.marcarCasilla(fila, columna);
                    break;
                case "X":
                    tablero.macroDespejar(fila, columna);
                    break;
                default:
                    System.out.println("Acción no válida. Intenta de nuevo.");
            }

            if (tablero.esVictoria()) {
                System.out.println("¡Felicidades! Has ganado el juego.");
                tablero.mostrarTablero();
                return;
            }
        }
    }
}
