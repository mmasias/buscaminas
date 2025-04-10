package anayaAndrea;

import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero(6, 6); 
        jugador = new Jugador();
    }

    public void jugar() {
        do {
            tablero.mostrar();
            jugador.jugar(tablero);
        } while (!tablero.despejado() && jugador.vivo());

        tablero.mostrar();

        if (tablero.despejado()) {
            System.out.println("\n¡Enhorabuena! Has ganado.");
        } else {
            System.out.println("\nHas pisado una mina. Derrota.");
        }
    }
}

class Tablero {
    private Celda[][] celdas;
    private int filas;
    private int columnas;
    private int minas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = 6;
        celdas = new Celda[filas][columnas];
        inicializar();
        colocarMinas();
    }

    private void inicializar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    private void colocarMinas() {
        Random rand = new Random();
        int colocadas = 0;
        while (colocadas < minas) {
            int f = rand.nextInt(filas);
            int c = rand.nextInt(columnas);
            if (!celdas[f][c].tieneMina) {
                celdas[f][c].tieneMina = true;
                colocadas++;
            }
        }
    }

    public void mostrar() {
        System.out.println("\nBUSCAMINAS");
        System.out.print("  ");
        for (int i = 1; i <= columnas; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < columnas; j++) {
                Celda celda = celdas[i][j];
                if (celda.estaDescubierta) {
                    if (celda.tieneMina) System.out.print("* ");
                    else System.out.print(contarMinasVecinas(i, j) + " ");
                } else if (celda.estaMarcada) {
                    System.out.print("M ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public boolean coordenadaValida(int f, int c) {
        return f >= 0 && f < filas && c >= 0 && c < columnas;
    }

    public boolean despejado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!celdas[i][j].tieneMina && !celdas[i][j].estaDescubierta) {
                    return false;
                }
            }
        }
        return true;
    }

    public int descubrir(int f, int c) {
        if (celdas[f][c].tieneMina) {
            celdas[f][c].estaDescubierta = true;
            return 0;
        }
        if (!celdas[f][c].estaDescubierta) {
            celdas[f][c].estaDescubierta = true;
            return 1;
        }
        return 0;
    }

    public void marcar(int f, int c) {
        celdas[f][c].estaMarcada = !celdas[f][c].estaMarcada;
    }

    public int contarMinasVecinas(int f, int c) {
        int minasCerca = 0;
        for (int i = f - 1; i <= f + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (coordenadaValida(i, j) && !(i == f && j == c) && celdas[i][j].tieneMina) {
                    minasCerca++;
                }
            }
        }
        return minasCerca;
    }
}

class Celda {
    public boolean tieneMina = false;
    public boolean estaDescubierta = false;
    public boolean estaMarcada = false;
}

class Jugador {
    private boolean vivo = true;
    private Scanner scanner = new Scanner(System.in);

    public void jugar(Tablero tablero) {
        String opcion = "";
        while (!opcion.equals("D") && !opcion.equals("M")) {
            System.out.print("[D]espejar o [M]arcar mina?: ");
            opcion = scanner.nextLine();
            if (!opcion.equals("D") && !opcion.equals("M")) {
                System.out.println("Opcion no valida. Solo D o M en mayuscula.");
            }
        }

        System.out.print("> Fila: ");
        int fila = scanner.nextInt() - 1;
        System.out.print("> Columna: ");
        int col = scanner.nextInt() - 1;
        scanner.nextLine();

        if (!tablero.coordenadaValida(fila, col)) {
            System.out.println("Coordenadas fuera del tablero.");
            return;
        }

        if (opcion.equals("D")) {
            boolean sigueVivo = tablero.descubrir(fila, col);
            if (!sigueVivo) vivo = false;
        } else if (opcion.equals("M")) {
            tablero.marcar(fila, col);
        }
    }

    public boolean vivo() {
        return vivo;
    }
}

