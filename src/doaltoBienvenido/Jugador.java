package doaltoBienvenido;

import java.util.Scanner;

public class Jugador {

    private boolean vivo;
    private int fila;
    private int columna;

    public Jugador() {
        vivo = true;
    }

    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);
        do {
            tablero.mostrar();  
            System.out.println("Desea Despejar Casilla [D], Marcar/Desmarcar Casilla [M] o superDespejar Casilla [X]");
            char respuesta = scanner.nextLine().toLowerCase().charAt(0);

            if (respuesta == 'd') {
                pedirCoordenada(scanner, tablero);
                if (tablero.esMina(fila, columna)) {
                    tablero.mostrarMina(fila, columna);  
                    vivo = false;
                } else {
                    tablero.despejarCasilla(fila, columna);
                }

            } else if (respuesta == 'x') {
                pedirCoordenada(scanner, tablero);
                boolean exploto = tablero.superDespejarCasilla(fila, columna);
                if (exploto) {
                    vivo = false;
                }

            } else if (respuesta == 'm') {
                pedirCoordenada(scanner, tablero);
                if (!tablero.esMarcada(fila, columna)) {
                    tablero.marcarCasilla(fila, columna);
                    System.out.println("Casilla marcada.");
                } else {
                    tablero.desmarcarCasilla(fila, columna);
                    System.out.println("Casilla desmarcada.");
                }

            } else {
                System.out.println("Opcion no valida. elige una valida.");
            }

        } while (!tablero.finalizado() && vivo);
        
        vivo = false;
    }

    public boolean sigueVivo() {
        return vivo;
    }

    private void pedirCoordenada(Scanner scanner, Tablero tablero) {
        do {
            System.out.println("Ingrese coordenada (1-6):");
            fila = scanner.nextInt() - 1;
            columna = scanner.nextInt() - 1;
            scanner.nextLine();

            if (!tablero.coordenadaValida(fila, columna)) {
                System.out.println("Coordenada invalida, vuelva a intentarlo.");
            }
        } while (!tablero.coordenadaValida(fila, columna));
    }
}
