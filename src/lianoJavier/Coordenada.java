package lianoJavier;

import java.util.Scanner;

public class Coordenada {

        private int[] coordenada;
        private Scanner scanner = new Scanner(System.in);
        private Tablero tablero;

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
                int fila = preguntarFila();
                int columna = preguntarColumna();
                coordenada = new int[] { fila, columna };
                return this;
        }

        private int preguntarColumna() {
                System.out.println("Elige una columna: (0-"+(tablero.getDimensionesColumna()-1)+")");
                return scanner.nextInt();
        }

        private int preguntarFila() {
                System.out.println("Elige una fila: (0-"+(tablero.getDimensionesFila()-1)+")");
                return scanner.nextInt();
        }

}
