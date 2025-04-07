package caicedoFernando;

public class Buscaminas {
    
    final private Tablero tablero;
    final private Jugador jugador;    
    
    public Buscaminas() {
        this.tablero = new Tablero(6, 6, 6);
        this.jugador = new Jugador();
    }
    
    public void iniciarJuego() {
        while(true){
            tablero.mostrarTablero();
            char accion = jugador.pedirAccion();
            Coordenada coordenada = jugador.pedirCoordenada();

            if (!tablero.esValida(coordenada)) {
                System.out.println("Coordenadas inválidas.");
            }

            if (accion == 'D') {
                if (tablero.esMina(coordenada)) {
                    tablero.explosionMina(coordenada);
                    System.out.println("¡Has perdido!");
                } else {
                    tablero.revelar(coordenada);
                }
            } else if (accion == 'M') {
                tablero.marcar(coordenada);
            }

            if (tablero.condicionVictoria()) {
                tablero.mostrarFinal();
                System.out.println("¡Has ganado!");
            }
        }
    }
}