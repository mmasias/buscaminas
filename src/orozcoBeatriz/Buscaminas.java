package orozcoBeatriz;

import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Scanner scanner;
    private int comodinesDisponibles = 2;

    public Buscaminas() {
        tablero = new Tablero();
        scanner = new Scanner(System.in);
    }

    public void jugar() {
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            tablero.imprimir(false);
            String opcion = "";

            while (!opcion.equals("D") && !opcion.equals("M") && !opcion.equals("X")) {
                System.out.print("¿[D]espejar, [M]arcar mina? o [X]Macrodespeje (2 veces máximo): ");
                opcion = scanner.nextLine();

                if (!opcion.equals("D") && !opcion.equals("M") && !opcion.equals("X")) {
                    System.out.println("Opción no válida. Escribe solo D, M o X en mayúscula.");
                }
            }

            System.out.print("> Fila: ");
            int fila = scanner.nextInt() - 1;
            System.out.print("> Columna: ");
            int columna = scanner.nextInt() - 1;
            scanner.nextLine();

            if (tablero.coordenadaValida(fila, columna)) {
                Celda celda = tablero.getCelda(fila, columna);
                if (opcion.equals("D")) {
                    if (celda.tieneMina()) {
                        tablero.imprimir(true);
                        System.out.println("¡Has pisado una mina! DERROTA.");
                        juegoTerminado = true;
                    } else {
                        celda.estaDescubierta(true);

                        int minasCerca = tablero.contarMinasVecinas(fila, columna);
                        System.out.println("Has despejado la casilla (" + (fila + 1) + ", " + (columna + 1) + "). Hay " + minasCerca + " mina(s) cerca.");

                        if (tablero.verificarVictoria()) {
                            tablero.imprimir(true);
                            System.out.println("¡Enhorabuena! ¡Has ganado!");
                            juegoTerminado = true;
                        }
                    }
                } else if (opcion.equals("M")) {
                    celda.estaMarcada(!celda.estaMarcada());
                } else if (opcion.equals("X")) {
                    if (comodinesDisponibles == 0) {
                        System.out.println("Ya has usado tu comodín. Solo se puede una vez.");
                    } else {
                        for (int i = fila - 1; i <= fila + 1; i++) {
                            for (int j = columna - 1; j <= columna + 1; j++) {
                                if (tablero.coordenadaValida(i, j)) {
                                    Celda vecina = tablero.getCelda(i, j);
                                    if (!vecina.tieneMina()) {
                                        vecina.estaDescubierta(true);
                                    }
                                }
                            }
                        }
                        comodinesDisponibles--;

                        if (tablero.verificarVictoria()) {
                            tablero.imprimir(true);
                            System.out.println("¡Enhorabuena! ¡Has ganado!");
                            juegoTerminado = true;
                        }
                    }
                }
            } else {
                System.out.println("Las coordenadas introducidas están fuera del tablero.");
            }
        }
    }
}
