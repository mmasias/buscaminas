package doaltoBienvenido;

import java.util.Scanner;

public class Jugador {

    private boolean vivo = true;

    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese coordenada (1-6)");
        int fila = scanner.nextInt() - 1;
        int columna = scanner.nextInt() - 1;

        if (fila < 0 || fila >= 6 || columna < 0 || columna >= 6) {
            System.out.println("Coordenada invalida, vuelva a introducirla");
            return;
        }

        if (tablero.esMina(fila,columna)) {
            System.out.println("BOOM!!, Explotaste una mina y perdiste!");
            tablero.mostrarMina(fila,columna);
            vivo = false;
        }else{
            tablero.despejarCasilla(fila,columna);
        }
    }

    public boolean sigueVivo() {
        return vivo;
    }

}
