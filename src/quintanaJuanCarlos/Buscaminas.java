package quintanaJuanCarlos;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador();
    }
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        do {
            tablero.mostrar();
            System.out.print("[D]espejar o [M]arcar mina? ");
            char accion = scanner.next().charAt(0);
            char despejar = 'P';

            if( accion == 'D' || accion == 'd'){
                System.out.print("[C] Despejar Cuadrado o [P] Despejar punto");
                despejar = scanner.next().charAt(0);   
            }
            
            System.out.println("\nElija coordenada:");
            System.out.print("> Fila: ");
            int fila = scanner.nextInt() - 1;
            System.out.print("> Columna: ");
            int columna = scanner.nextInt() - 1;
            

            if (accion == 'D' || accion == 'd') {
                if (!jugador.despejar(tablero, fila, columna,despejar)) {
                    System.out.println(" Has pisado una mina. ¡Juego terminado!");
                    juegoTerminado = true;
                }
            } else if (accion == 'M' || accion == 'm') {
                jugador.marcar(tablero, fila, columna);
            }

            if (tablero.haGanado()) {
                System.out.println("¡Felicidades! Has despejado todas las casillas.");
                juegoTerminado = true;
            }
        } while (!juegoTerminado);
        scanner.close();
    }

}