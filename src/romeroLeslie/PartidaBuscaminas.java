import java.util.Scanner;

public class PartidaBuscaminas {
    private Tablero tablero;
    private Scanner sc;

    public PartidaBuscaminas() {
        tablero = new Tablero();
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            tablero.imprimirVisible();
            System.out.print("¿[D]espejar o [M]arcar mina?: ");
            char accion = sc.next().toUpperCase().charAt(0);

            System.out.print("Fila (1-6): ");
            int fila = sc.nextInt() - 1;
            System.out.print("Columna (1-6): ");
            int col = sc.nextInt() - 1;

            if (accion == 'D') {
                boolean seguir = tablero.despejar(fila, col);
                if (!seguir) {
                    tablero.descubrirTodo();
                    tablero.imprimirVisible();
                    System.out.println("¡Ups, ya perdiste!");
                    return;
                }
                if (tablero.verificarVictoria()) {
                    tablero.descubrirTodo();
                    tablero.imprimirVisible();
                    System.out.println("¡Ganaste! Lograste despejar todo el tablero.");
                    return;
                }
            } else if (accion == 'M') {
                tablero.marcar(fila, col);
            } else {
                System.out.println("Acción inválida.");
            }
        }
    }
}
