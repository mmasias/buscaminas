package arellanoDiego;

import java.util.Scanner;

public class Jugador {
    private boolean estaVivo = true;

    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);
        int fila = -1;
        int columna = -1;
        boolean modoMacro = false;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.println("\nIngresa las coordenadas (fila y columna) para despejar:");
            System.out.println("O ingresa 'x' para macrodespejar (despejar las 8 celdas alrededor)");
            System.out.print("Fila (1-" + Tablero.DIMENSION + " o 'x'): ");
            
            String inputFila = scanner.next();
            
            if (inputFila.equalsIgnoreCase("x")) {
                modoMacro = true;
                System.out.print("Columna central (1-" + Tablero.DIMENSION + "): ");
                if (scanner.hasNextInt()) {
                    columna = scanner.nextInt() - 1;
                    System.out.print("Fila central (1-" + Tablero.DIMENSION + "): ");
                    if (scanner.hasNextInt()) {
                        fila = scanner.nextInt() - 1;
                        entradaValida = coordenadasValidas(fila, columna);
                    }
                }
            } else {
                if (esNumero(inputFila)) {
                    fila = Integer.parseInt(inputFila) - 1;
                    System.out.print("Columna (1-" + Tablero.DIMENSION + "): ");
                    if (scanner.hasNextInt()) {
                        columna = scanner.nextInt() - 1;
                        entradaValida = coordenadasValidas(fila, columna);
                    }
                }
            }
            
            if (!entradaValida) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
        
        if (modoMacro) {
            if (tablero.macroDespejar(fila, columna)) {
                estaVivo = false;
            }
        } else {
            if (tablero.hayMina(fila, columna)) {
                estaVivo = false;
                System.out.println("¡BOOM! Has pisado una mina. Juego terminado.");
            } else {
                tablero.despejarCasilla(fila, columna);
                System.out.println("Casilla despejada con éxito.");
            }
        }
    }

    private boolean coordenadasValidas(int fila, int columna) {
        return fila >= 0 && fila < Tablero.DIMENSION && 
               columna >= 0 && columna < Tablero.DIMENSION;
    }
    
    private boolean esNumero(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return !str.isEmpty();
    }

    public boolean vivo() {
        return estaVivo;
    }
}