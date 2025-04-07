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

    public void jugar(){
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
