package lianoJavier;

import java.util.Scanner;

public class Coordenada {

        int fila;
        int columna;
        int[] dimensiones;
        Scanner scanner = new Scanner(System.in);

        public Coordenada(int[] dimensiones) {
                this.dimensiones = dimensiones;
        }

        public Coordenada pedirCoordenada() {
                pedirFila();
                pedirColumna();
                return this;
        }

        private int scanForInt(int[] rango) {
                int respuesta;
                do {
                        try {
                                respuesta = scanner.nextInt();
                        } catch (java.util.NoSuchElementException e) {
                                System.out.println("Error: No se ingresó un número válido");
                                scanner.next(); // Limpiar buffer
                                respuesta = rango[0] - 1; // Forzar nueva iteración
                        }
                } while (respuesta <= rango[0] || respuesta >= rango[1]);
                return respuesta;
        }

        private void pedirColumna() {
                int maximoColumnas = dimensiones[1];
                int[] rango = new int[] {0, maximoColumnas};
                System.out.println("Escriba una columna entre: 1 y " + (maximoColumnas + 1));
                this.columna = scanForInt(rango)-1;
        }

        private void pedirFila() {
                int maximoFilas = dimensiones[0];
                int[] rango = new int[] {0, maximoFilas};
                System.out.println("Escriba una fila entre: 1 y " + (maximoFilas + 1));
                this.fila = scanForInt(rango)-1;
        }

        public int getFila() {
                return fila;
        }

        public int getColumna() {
                return columna;
        }

}
