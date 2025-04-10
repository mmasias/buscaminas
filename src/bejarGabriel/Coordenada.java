package bejarGabriel;

import java.util.Scanner;

public class Coordenada {
    private int[] coordenada;
    private final Scanner scanner = new Scanner(System.in);
    private final Tablero tablero;

    public Coordenada(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getFila() {
        return coordenada[0];
    }

    public int getColumna() {
        return coordenada[1];
    }

    public Coordenada pedirCoordenada() {
        coordenada = new int[] {preguntarFila(), preguntarColumna()};
        return this;
    }

    private int preguntarColumna() {
        System.out.println("Elige una columna: (0-" + (tablero.getDimensionesColumna() - 1) + ")");
        return scanner.nextInt();
    }

    private int preguntarFila() {
        System.out.println("Elige una fila: (0-" + (tablero.getDimensionesFila() - 1) + ")");
        return scanner.nextInt();
    }
}