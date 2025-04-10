package alvaradoCarlos;

import java.util.Scanner;

public class Jugador {

    private boolean jugando;
    private boolean perdio;
    private boolean gano;
    private Tablero tablero;

    public Jugador(Tablero tablero) {
        this.tablero = tablero;
        this.jugando = true;
        this.perdio = false;
        this.gano = false;
    }

    public boolean jugando() {
        return jugando;
    }

    public char actuar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una acción: (D) Descubrir, (M) Marcar, (R) Retirar marca");
        char opcion = scanner.next().toUpperCase().charAt(0);

        while (opcion != 'D' && opcion != 'M' && opcion != 'R' && opcion != 'X') {
            System.out.println("Opción no válida. Intenta de nuevo: (D) Descubrir, (M) Marcar, (R) Retirar marca");
            opcion = scanner.next().toUpperCase().charAt(0);
        }

        return opcion;
    }

    public int[] pedirCoordenadas(Scanner scanner) {
        System.out.println("Introduce las coordenadas (fila y columna) separadas por un espacio:");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();

        return new int[]{fila, columna};
    }

    public void actualizarTablero(char opcion, int[] coordenadas) {
        tablero.actualizarTablero(opcion, coordenadas);

        if (tablero.mostrarCelda(coordenadas) == '*' || tablero.minasEnCeldasAdyacentes(coordenadas)) {
            perdio = true;
            jugando = false;
        }

        if (tablero.todasLasCeldasDescubiertas()) {
            gano = true;
            jugando = false;
        }
    }

    public boolean perdio() {
        return perdio;
    }

    public boolean gano() {
        return gano;
    }
}
