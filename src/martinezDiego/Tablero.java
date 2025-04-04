package martinezDiego;

import java.util.Random;
import java.util.Scanner;

public class Tablero {

    private String[][] tablero = {
            { ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", "." },
            { ".", ".", ".", ".", ".", "." },
    };

    private boolean[][] minas = new boolean[5][6];

    public void mostrar() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void imprimir() {
        System.out.println("Tablero actual:");
        mostrar();
    }

    public void seleccionarCasilla() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Selecciona fila (0-4): ");
        int fila = sc.nextInt();
        System.out.print("Selecciona columna (0-5): ");
        int columna = sc.nextInt();

        if (fila >= 0 && fila < 5 && columna >= 0 && columna < 6) {
            if (minas[fila][columna]) {
                tablero[fila][columna] = "*";
                System.out.println("¡BOOM! Pisaste una mina.");
            } else {
                tablero[fila][columna] = "0";
                System.out.println("Casilla segura.");
            }
        } else {
            System.out.println("Coordenadas fuera de rango.");
        }
    }

    public void generarMinas() {
        Random rand = new Random();
        int minasGeneradas = 0;
        while (minasGeneradas < 5) {
            int fila = rand.nextInt(5);
            int columna = rand.nextInt(6);
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                minasGeneradas++;
            }
        }
        System.out.println("Minas generadas.");
    }

    public void plantarBandera() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fila para bandera (0-4): ");
        int fila = sc.nextInt();
        System.out.print("Columna para bandera (0-5): ");
        int columna = sc.nextInt();

        if (fila >= 0 && fila < 5 && columna >= 0 && columna < 6) {
            if (tablero[fila][columna].equals(".")) {
                tablero[fila][columna] = "F";
                System.out.println("Bandera plantada.");
            } else {
                System.out.println("No puedes plantar bandera aquí.");
            }
        } else {
            System.out.println("Coordenadas fuera de rango.");
        }
    }

    public void revelarMinas() {
        for (int i = 0; i < minas.length; i++) {
            for (int j = 0; j < minas[i].length; j++) {
                if (minas[i][j]) {
                    tablero[i][j] = "*";
                }
            }
        }
        System.out.println("Minas reveladas.");
    }
}
