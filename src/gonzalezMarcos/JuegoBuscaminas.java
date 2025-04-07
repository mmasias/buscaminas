import java.util.Scanner;

public class JuegoBuscaminas {
    private Tablero tablero;
    private boolean juegoTerminado;

    public JuegoBuscaminas() {
        tablero = new Tablero();
        juegoTerminado = false;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al Buscaminas!");
        System.out.println("Acciones: Despejar (D) o Marcar (M)");
        System.out.println("Ingresa coordenadas como: fila columna (ej: 3 4)");

        while (!juegoTerminado) {
            tablero.mostrarTablero();

            System.out.print("Acción (D/M): ");
            String accion = scanner.next().toUpperCase();

            System.out.print("Fila (1-6): ");
            int fila = scanner.nextInt();

            System.out.print("Columna (1-6): ");
            int columna = scanner.nextInt();

            switch (accion) {
                case "D":
                    boolean seguro = tablero.despejar(fila, columna);
                    if (!seguro) {
                        juegoTerminado = true;
                        System.out.println("¡BOOM! Has pisado una mina. Game Over.");
                        tablero.mostrarTablero();
                    } else if (tablero.haGanado()) {
                        juegoTerminado = true;
                        System.out.println("¡Felicidades! Has despejado todas las casillas sin minas.");
                        tablero.mostrarTablero();
                    }
                    break;

                case "M":
                    tablero.marcar(fila, columna);
                    break;

                default:
                    System.out.println("Acción no válida. Usa 'D' para Despejar o 'M' para Marcar.");
                    break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        JuegoBuscaminas juego = new JuegoBuscaminas();
        juego.jugar();
    }
}