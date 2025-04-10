

import java.util.Scanner;

public class PartidaBuscaminas {
    private boolean estaVivo;

    public PartidaBuscaminas() {
        estaVivo = true;
    }

    public void jugar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Quieres (D)espejar, (M)arcar con bandera o usar (B)omba? ");
        String seleccion = scanner.next().toUpperCase();

        System.out.print("Ingresa fila: ");
        int fila = scanner.nextInt();

        System.out.print("Ingresa columna: ");
        int columna = scanner.nextInt();

        if (!tablero.esCoordenadaValida(fila, columna)) {
            System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
            return;
        }

        if (seleccion.equals("M")) {
            tablero.marcarConBandera(fila, columna);
            System.out.println("Casilla marcada con bandera.");
        } else if (seleccion.equals("D")) {
            boolean resultado = tablero.despejarCasilla(fila, columna);
            if (!resultado) {
                estaVivo = false;
                System.out.println("Has pisado una mina. Fin del juego.");
            } else {
                System.out.println("Casilla despejada.");
            }
        } else if (seleccion.equals("B")) {
            boolean resultado = tablero.usarBomba(fila, columna);
            if (!resultado) {
                estaVivo = false;
                System.out.println("La bomba detonó una mina. Fin del juego.");
            } else {
                System.out.println("Bomba usada. Casillas despejadas en el área.");
            }
        } else {
            System.out.println("Opción inválida. Intenta de nuevo.");
        }


        if (estaVivo && tablero.juegoCompletado()) {
            tablero.mostrarTablero(); 
            System.out.println(" Has despejado todo sin pisar minas. ¡Ganaste!");
            estaVivo = false; 
        }
    }

    public boolean estaVivo() {
        return estaVivo;
    }
}