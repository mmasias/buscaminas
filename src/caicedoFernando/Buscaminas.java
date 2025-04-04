package caicedoFernando;

import java.util.Scanner;

public class Buscaminas {
    
    final private Tablero tablero;
    
    public Buscaminas(int filas, int columnas, int numeroMinas) {
        tablero = new Tablero(filas, columnas, numeroMinas);
    }
    
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            tablero.mostrarTablero();
            System.out.println("Ingrese las coordenadas (fila, columna)");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            Coordenada coordenada = new Coordenada(fila, columna);
            if (mapa.descubrirCasilla(coordenada)) {
                System.out.println("!BOOOOM¡" + " GAME OVER ");
                juegoTerminado = true;
            } else if (tablero.esMapaDescubierto()) {
                System.out.println("FELICIDADES GANASTE");
                juegoTerminado = true;
            }
        }
        scanner.close();
        tablero.mostrarTablero();
    }

}
