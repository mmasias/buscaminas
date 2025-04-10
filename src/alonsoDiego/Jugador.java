package alonsoDiego;
import java.util.Scanner;
public class Jugador {
    
    private boolean vivo = true;

    public void jugar(Tablero tablero, Scanner scanner) {
        System.out.println("Ingrese coordenada (fila y columna) entre 1 y 6, o agregue 'x' para despeje macro:");
        String input = scanner.nextLine().toLowerCase();

        if (input.contains("x")) {
            String[] partes = input.split("x");
            if (partes.length == 2) {
                try {
                    int fila = Integer.parseInt(partes[0].trim()) - 1; 
                    int columna = Integer.parseInt(partes[1].trim()) - 1;

                    if (tablero.coordenadaValida(fila, columna)) {
                        tablero.macroDespeje(fila, columna);
                        System.out.println("Se ha realizado el macrodespeje.");
                    } else {
                        System.out.println("Coordenada inválida para el macrodespeje.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Asegúrese de ingresar las coordenadas correctamente.");
                }
            }
        } else {
            int fila = Integer.parseInt(input.split(" ")[0]) - 1;
            int columna = Integer.parseInt(input.split(" ")[1]) - 1;

            if (!tablero.coordenadaValida(fila, columna)) {
                System.out.println("Coordenada inválida, por favor intente de nuevo.");
                return;
            }

            if (tablero.esMina(fila, columna)) {
                System.out.println("¡BOOM! Has explotado una mina y has perdido.");
                tablero.mostrarMina(fila, columna);
                vivo = false;
            } else {
                tablero.despejarCasilla(fila, columna);
                System.out.println("Casilla despejada con éxito.");
            }
        }
    }

    public boolean sigueVivo() {
        return vivo;
    }
}
