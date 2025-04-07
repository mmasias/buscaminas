package lianoJavier;

public class Jugador {

    private boolean estaVivo;

    public void realizarJugada(Tablero tablero) {
        System.out.println("[D]escubrir Casilla");
        System.out.println("Poner/quitar [B]andera");
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String opcion = scanner.nextLine().toUpperCase();
        
        switch(opcion) {
            case "D":
                Coordenada coordenadaDescubrir = new Coordenada(tablero).pedirCoordenada();
                tablero.seleccionarCasilla(coordenadaDescubrir);
                estaVivo = !tablero.hayBomba();
                break;
            case "B":
                Coordenada coordenadaMarcar = new Coordenada(tablero).pedirCoordenada();
                tablero.marcarCasilla(coordenadaMarcar);
                estaVivo = true;
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                realizarJugada(tablero);
                return;
        }
    }

    public boolean haPerdido() {
        return !estaVivo;
    }

}
