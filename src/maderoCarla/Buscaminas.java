package maderoCarla;

import java.util.Scanner;

class Buscaminas {

    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero();
        jugador = new Jugador("Jugador 1");
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;

        
        while (!juegoTerminado) {
            tablero.mostrar(); 

            
            System.out.print("[D]espejar o [M]arcar mina? ");
            String accion = scanner.nextLine().trim().toUpperCase();

            
            while (!accion.equals("D") && !accion.equals("M")) {
                System.out.print("> Acción inválida. Usa D o M: ");
                accion = scanner.nextLine().trim().toUpperCase();
            }

            /
            Coordenada coordenada = new Coordenada();
            coordenada.pedir();

            if (accion.equals("D")) {
                if (tablero.yaRevelada(coordenada)) {
                    System.out.println("¡Esa casilla ya fue despejada!");
                    continue; 
                }

                
                boolean esMina = tablero.revelarCasilla(coordenada);

                if (esMina) {
                    tablero.mostrar();
                    System.out.println("Pisaste una mina. Fin del juego.");
                    juegoTerminado = true;
                } else if (tablero.juegoGanado()) {
                    tablero.mostrar();
                    jugador.celebrar();
                    juegoTerminado = true;
                }

            } else if (accion.equals("M")) {
                tablero.marcarCasilla(coordenada);
            }
        }

        scanner.close(); 
    }
}
