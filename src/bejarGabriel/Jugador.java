package bejarGabriel;

public class Jugador {
    private boolean estaVivo = true;

    public void realizarJugada(Tablero tablero) {
        System.out.println("[D]escubrir Casilla");
        System.out.println("Poner/quitar [B]andera");

        String opcion = new java.util.Scanner(System.in).nextLine().toUpperCase();

        switch (opcion) {
            case "D":
                Coordenada coordenadaDescubrir = new Coordenada(tablero).pedirCoordenada();
                tablero.seleccionarCasilla(coordenadaDescubrir);
                estaVivo = !tablero.hayBomba();
                break;
            case "B":
                Coordenada coordenadaMarcar = new Coordenada(tablero).pedirCoordenada();
                tablero.marcarCasilla(coordenadaMarcar);
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                realizarJugada(tablero);
        }
    }

    public boolean haPerdido() {
        return !estaVivo;
    }
}