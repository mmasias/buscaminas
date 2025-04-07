package anayaAndrea;

import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;

    public Buscaminas() {
        tablero = new Tablero(6, 6); // Tamaño 6x6 con 6 minas
        jugador = new Jugador();
    }

    public void jugar() 