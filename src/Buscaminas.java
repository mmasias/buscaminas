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
}