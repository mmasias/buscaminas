import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero(8, 8, 10); 

        while (!tablero.esJuegoTerminado()) {
            tablero.imprimirTablero();
            System.out.print("Introduce fila y columna (opcional: x para macrodespeje, ej: 3 4 x): ");
            
            String input = scanner.nextLine().trim();
            String[] partes = input.split("\\s+");

            if (partes.length < 2) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }

            int fila, columna;
            try {
                fila = Integer.parseInt(partes[0]);
                columna = Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }

            if (fila < 0 || fila >= 8 || columna < 0 || columna >= 8) {
                System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
                continue;
            }

            if (partes.length == 3 && partes[2].equalsIgnoreCase("x")) {
                tablero.macroDespeje(fila, columna);
            } else {
                tablero.revelarCelda(fila, columna);
            }
        }

        tablero.imprimirTablero();
        System.out.println("Juego terminado.");
        scanner.close();
    }
}
