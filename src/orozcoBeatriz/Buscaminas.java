package orozcoBeatriz;

import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
    private final int TAM = 6;
    private final int MINAS = 6;
    private Celda[][] tablero;
    private Scanner scanner;

    public Buscaminas() {
        tablero = new Celda[TAM][TAM];
        scanner = new Scanner(System.in);
        inicializarTablero();
        colocarMinas();
    }

    public void jugar() {
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            imprimirTablero(false);
            String opcion = "";
            while (!opcion.equals("D") && !opcion.equals("M")) {
                System.out.print("[D]espejar o [M]arcar mina?: ");
                opcion = scanner.nextLine();
            
                if (!opcion.equals("D") && !opcion.equals("M")) {
                    System.out.println("Opción no válida. Escribe solo D o M en mayúscula.");
                }
            }

            System.out.print("> Fila: ");
            int fila = scanner.nextInt() - 1;
            System.out.print("> Columna: ");
            int col = scanner.nextInt() - 1;
            scanner.nextLine();

            if (coordenadaValida(fila, col)) {
                if (opcion.equals("D")) {
                    if (tablero[fila][col].tieneMina) {
                        imprimirTablero(true);
                        System.out.println("¡Has pisado una mina! DERROTA.");
                        juegoTerminado = true;
                    } else {
                        tablero[fila][col].estaDescubierta = true;
                        if (verificarVictoria()) {
                            imprimirTablero(true);
                            System.out.println("¡Enhorabuena! ¡Has ganado!");
                            juegoTerminado = true;
                        }
                    }
                } else if (opcion.equals("M")) {
                    tablero[fila][col].estaMarcada = !tablero[fila][col].estaMarcada;
                }
            } else {
                System.out.println("Las coordenadas introducidas están fuera del tablero.");
            }
        }
    }

    private void inicializarTablero() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                tablero[i][j] = new Celda();
            }
        }
    }

    private void colocarMinas() {
        Random rand = new Random();
        int colocadas = 0;
        while (colocadas < MINAS) {
            int f = rand.nextInt(TAM);
            int c = rand.nextInt(TAM);
            if (!tablero[f][c].tieneMina) {
                tablero[f][c].tieneMina = true;
                colocadas++;
            }
        }
    }

    private void imprimirTablero(boolean revelar) {
        System.out.println("\nBUSCAMINAS");
        System.out.print("  ");
        for (int i = 1; i <= TAM; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < TAM; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAM; j++) {
                Celda celda = tablero[i][j];
                if (celda.estaDescubierta || revelar) {
                    if (celda.tieneMina) System.out.print("* ");
                    else System.out.print("D ");
                } else if (celda.estaMarcada) {
                    System.out.print("M ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    private boolean verificarVictoria() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (!tablero[i][j].tieneMina && !tablero[i][j].estaDescubierta) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean coordenadaValida(int fila, int col) {
        return fila >= 0 && fila < TAM && col >= 0 && col < TAM;
    }
}
