package valdesCarlos;

public class Buscaminas {

    private Tablero tablero;
    private Jugador jugador;
    private boolean juegoTerminado;

    public Buscaminas() {
        this.tablero = new Tablero();
        this.jugador = new Jugador("Jugador");
        this.juegoTerminado = false;
    }

    public void jugar() {
        while (!juegoTerminado) {
            tablero.mostrar();
            char accion = jugador.elegirAccion();
            Coordenadas coordenadas = jugador.pedirCoordenadas();

            int fila = coordenadas.getFila() - 1;     
            int columna = coordenadas.getColumna() - 1;

            if (accion == 'D') {
                Celda celda = tablero.celdas[fila][columna];
                if (celda.estaRevelada()) {
                    System.out.println(" Esa casilla ya está despejada.");
                } else if (celda.tieneMina()) {
                    celda.revelar();
                    tablero.mostrar();
                    System.out.println(" ¡Has pisado una mina! Has perdido.");
                    juegoTerminado = true;
                } else {
                    celda.revelar();
                    if (partidaGanada()) {
                        tablero.mostrar();
                        System.out.println("🎉 ¡Felicidades, has ganado!");
                        juegoTerminado = true;
                    }
                }
            } else if (accion == 'M') {
                Celda celda = tablero.celdas[fila][columna];
                if (celda.estaRevelada()) {
                    System.out.println(" No puedes marcar una casilla ya revelada.");
                } else {
                    celda.marcar(!celda.estaMarcada());
                    System.out.println(" Casilla " + (celda.estaMarcada() ? "marcada" : "desmarcada") + ".");
                }
            }
        }
    }

    private boolean partidaGanada() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                Celda celda = tablero.celdas[i][j];
                if (!celda.tieneMina() && !celda.estaRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }
}
