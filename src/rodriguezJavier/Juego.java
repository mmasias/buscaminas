import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private boolean enJuego;
    
    public Juego(int tamano, int cantidadMinas) {
        this.tablero = new Tablero(tamano, cantidadMinas);
        this.enJuego = true;
    }
    
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        
        while (enJuego) {
            System.out.println("\n--- BUSCAMINAS ---");
            tablero.mostrar(false);
            
            System.out.print("\n[D]espejar o [M]arcar? ");
            String accion = scanner.nextLine().toUpperCase();
            
            if (!accion.equals("D") && !accion.equals("M")) {
                System.out.println("Opción no válida!");
                continue;
            }
            
            System.out.print("Fila (1-" + tablero.getTamano() + "): ");
            int fila = scanner.nextInt() - 1;
            System.out.print("Columna (1-" + tablero.getTamano() + "): ");
            int columna = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (fila < 0 || fila >= tablero.getTamano() || 
                columna < 0 || columna >= tablero.getTamano()) {
                System.out.println("Coordenadas inválidas!");
                continue;
            }
            
            if (accion.equals("D")) {
                if (!tablero.revelarCasilla(fila, columna)) {
                    System.out.println("\n¡BOOM! Mina explotada.");
                    enJuego = false;
                    tablero.mostrar(true);
                    System.out.println("\nPerdiste :(");
                } else if (tablero.verificarVictoria()) {
                    System.out.println("\n¡Felicidades! Has ganado.");
                    enJuego = false;
                    tablero.mostrar(true);
                }
            } else {
                tablero.marcarCasilla(fila, columna);
            }
        }
        scanner.close();
    }
}