package quintanaJuanCarlos;

public class Buscaminas {
    private Tablero tablero;
    private boolean juegoTerminado;
    private boolean juegoGanado;

    public Buscaminas() {
        tablero = new Tablero();
        juegoTerminado = false;
        juegoGanado = false;
    }

    public void jugar() {
        while (!juegoTerminado) {
            tablero.mostrar();
            tablero.pedirCoordenadas();
            juegoTerminado = tablero.revelarCasilla();
            if (tablero.getNumeroCasillasReveladas() == tablero.getNumeroCasillasPorRevelar()) {
                juegoTerminado = true;
                juegoGanado = true;
            }
        }
        tablero.mostrar();
        if (juegoGanado) {
            System.out.println("¡Felicidades! Has ganado.");
        } else {
            System.out.println("¡Has perdido! Inténtalo de nuevo.");
        }
    }
}