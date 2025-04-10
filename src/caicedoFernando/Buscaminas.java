package caicedoFernando;

public class Buscaminas {

    final private Tablero tablero;
    final private Jugador jugador;

    public Buscaminas() {
        this.tablero = new Tablero(6, 6, 6);
        this.jugador = new Jugador();
    }

    public void iniciarJuego() {

        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            tablero.mostrarTablero();
            char accion = jugador.pedirAccion();
            Coordenada coordenada = jugador.pedirCoordenada();

            if (!tablero.esValida(coordenada)) {
                System.out.println("Coordenadas inválidas.");
            } else {
                if (accion == 'D') {
                    if (tablero.esMina(coordenada)) {
                        tablero.explosionMina(coordenada);
                        System.out.println("¡Has perdido!");
                        juegoTerminado = true;
                    } else {
                        tablero.revelar(coordenada);
                    }
                } else if (accion == 'M') {
                    tablero.marcar(coordenada);
                } else if (accion == 'X') {
                    juegoTerminado = tablero.macrodespeje(coordenada);
                }

                if (!juegoTerminado && tablero.condicionVictoria()) {
                    tablero.mostrarFinal();
                    System.out.println("¡Has ganado!");
                    juegoTerminado = true;
                }
            }
        }
    }
}
