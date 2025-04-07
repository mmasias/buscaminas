import java.util.Scanner;

public class Buscaminas {

    private Tablero tablero;
    private Scanner scanner;
    private boolean juegoTerminado;

    public Buscaminas() {
        tablero = new Tablero();
        scanner = new Scanner(System.in);
        juegoTerminado = false;
    }

    public void iniciarJuego() {
        while (!juegoTerminado) {
            tablero.mostrarTablero();
            System.out.println("[D]espejar o [M]arcar mina?");
            String accion = scanner.nextLine().trim().toUpperCase();

            if (!accion.equals("D") && !accion.equals("M")) {
                System.out.println("Acción inválida. Usa D o M.");
                continue;
            }

            System.out.println("Elija coordenada:");
            System.out.print(" Fila: ");
            int fila = scanner.nextInt();
            System.out.print(" Columna: ");
            int columna = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (!coordenadaValida(fila, columna)) {
                System.out.println(" Coordenadas inválidas. Intente de nuevo.");
                continue;
            }

            procesarAccion(accion, fila - 1, columna - 1);
        }

            scanner.close();
        }
    
        private boolean coordenadaValida(int fila, int columna) {
            return fila >= 1 && fila <= tablero.getFilas() && columna >= 1 && columna <= tablero.getColumnas();
        }
        
        private void manejarAccionDeJuego(String accion, int fila, int columna) {
            if (accion.equals("D")) {
                if (!tablero.despejarCasilla(fila, columna)) {
                    System.out.println("\n💥 ¡Pisaste una mina! Has perdido.");
                    juegoTerminado = true;
                } else {
                    System.out.println("\nCoordenada despejada");
                    if (tablero.jugadorGano()) {
                        tablero.mostrarTablero();
                        System.out.println("\n🎉 ¡Felicidades! Has ganado.");
                        juegoTerminado = true;
                    }
                }
            } else if (accion.equals("M")) {
                tablero.marcarCasilla(fila, columna);
                System.out.println("\nCoordenada marcada");
            } else {
                System.out.println(" Acción inválida. Usa D o M.");
            }
        }
    }
}
