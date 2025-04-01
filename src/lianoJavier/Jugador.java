package lianoJavier;

public class Jugador {

    private boolean estaVivo;

    public void jugar(Tablero tablero) {
        Coordenada coordenada = new Coordenada().pedirCoordenada();
        tablero.seleccionarCasilla(coordenada);
        estaVivo = !tablero.hayBomba();
    }

    public boolean isVivo() {
        return estaVivo;
    }

}
