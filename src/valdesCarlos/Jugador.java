package valdesCarlos;

import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Scanner scanner;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.scanner = new Scanner(System.in);
    }

    public String getNombre() {
        return nombre;
    }

    public char elegirAccion() {
        char accion;
        do {
            System.out.println("\n[" + nombre + "] ¿[D]espejar, [M]arcar mina o [X] Macrodespeje?");
            String entrada = scanner.nextLine().toUpperCase();
            accion = entrada.length() > 0 ? entrada.charAt(0) : ' ';
        } while (accion != 'D' && accion != 'M' && accion != 'X');
    
        return accion;
    }
    

    public Coordenadas pedirCoordenadas() {
        int fila = -1;
        int columna = -1;

        System.out.println("Elija coordenada:");
        while (fila < 1 || fila > 6) {
            System.out.print("> Fila (1-6): ");
            fila = leerNumero();
        }
        while (columna < 1 || columna > 6) {
            System.out.print("> Columna (1-6): ");
            columna = leerNumero();
        }

        return new Coordenadas(fila, columna);
    }

    private int leerNumero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Número no válido. Intente de nuevo: ");
            scanner.next(); 
        }
        return scanner.nextInt();
    }
}
