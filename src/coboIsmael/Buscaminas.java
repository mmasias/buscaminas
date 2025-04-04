package coboIsmael;

import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero(6, 6, 6);
        Juego juego = new Juego(tablero, scanner);
        juego.iniciar();
        scanner.close();
    } 
}