package arceMarina;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;
    private Scanner scanner;

    public Buscaminas() {
        scanner = new Scanner(System.in);
        tablero = new Tablero();
        jugador = new Jugador();
    }

    public void jugar(){
        System.out.println("=== Bienvenido a Buscaminas 6x6 ===");
        boolean continuar = true;
        while (continuar) {
        }

    private void reiniciar() {
        tablero = new Tablero();
        jugador = new Jugador();
    }

    private boolean jugarDeNuevo() {
        System.out.print("¿Quieres jugar otra vez? (si/no): ");
        String respuesta = scanner.next().toLowerCase();
        return respuesta.equals("si");
    }
 }