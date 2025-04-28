package morenoSara;

import java.util.Scanner;

class Coordenada {

    private int fila;
    private int columna;

    public void pedir() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("> Fila? [1..6] ");
            this.fila = sc.nextInt();
            System.out.print("> Columna? [1..6] ");
            this.columna = sc.nextInt();
        } while (!this.esValida());
    }

    public boolean esValida() {
        return (fila >= 1 && fila <= 6 && columna >= 1 && columna <= 6);
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}