package lianoJavier;

public class Jugador {

    private boolean estaVivo;

    public void jugar(Tablero tablero) {
        Coordenada coordenada = pedirCoordenada();
        tablero.seleccionarCasilla(coordenada);
        estaVivo = !tablero.hayBomba();
    }

    public boolean isVivo() {
        return estaVivo;
    }

}
