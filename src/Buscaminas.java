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
}