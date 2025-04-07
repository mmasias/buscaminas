import java.util.Scanner;

public class Buscaminas{

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
                System.out.println("\n[D]espejar o [M]arcar mina?");
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




}