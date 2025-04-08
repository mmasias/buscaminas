package lianoJavier;

import java.util.Scanner;

public class Buscaminas {
        private int[] DIMENSION = new int[] { 10, 10 };
        private Tablero tablero = new Tablero(DIMENSION);
        private Scanner scanner = new Scanner(System.in);

        public void iniciarJuego() {
                while (!tablero.pierde() && !tablero.gana()) {
                        tablero.mostar();
                        String seleccion = pedirOpcion();
                        switch (seleccion) {
                                case "D" -> despejarCasilla();
                                case "M" -> marcarCasilla();
                                default -> System.out.println("error: selección incorrecta");
                        }
                }
                
                tablero.mostrarBombas();
                System.out.println(tablero.pierde() ? 
                        "¡Perdiste! Descubriste una bomba" : 
                        "¡Ganaste! Descubriste todas las casillas seguras");
        }

        private void marcarCasilla() {
                Coordenada coordenada = new Coordenada(tablero.getDimensiones()).pedirCoordenada();
                tablero.marcarCasilla(coordenada);
        }

        private void despejarCasilla() {
                Coordenada coordenada = new Coordenada(tablero.getDimensiones()).pedirCoordenada();
                tablero.despejarCasilla(coordenada);
        }

        private String pedirOpcion() {
                System.out.println("[D]espejar - [M]arcar");
                return scanner.nextLine();
        }

}
