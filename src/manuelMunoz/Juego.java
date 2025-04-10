package manuelMunoz;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        Buscaminas buscaminas = new Buscaminas(6);
        buscaminas.generarMinas(tablero);

        boolean terminado = false;

        while (!terminado) {
            tablero.mostrarTablero();

            System.out.print("Ingresa coordenada X (1 a " + tablero.dimension()  + "): ");
            int coordenadaX = scanner.nextInt() - 1;

            System.out.print("Ingresa coordenada Y (1 a " + tablero.dimension() + "): ");
            int coordenadaY = scanner.nextInt() - 1;

            System.out.print("Acción (D = destapar, M = marcar): ");
            String accion = scanner.next().toUpperCase();

            Coordenada seleccion = new Coordenada(coordenadaX, coordenadaY);
            buscaminas.revisarEspacio(seleccion, tablero.tablero(), accion);

            if (buscaminas.finDePartida(tablero.tablero())) {
                System.out.println("¡BOOM! Pisaste una mina. Fin del juego.");
                break;
            }
        }

        System.out.println("Tablero final:");
        tablero.mostrarTablero();
        scanner.close();
    }
}
