package castilloCayetano;

public class Jugador {
    private Coordenada coordenada;

    public Jugador() {
        this.coordenada = new Coordenada();
    }

    public Jugador(int x, int y) {
        this.coordenada = new Coordenada(x, y);
    }
    
}