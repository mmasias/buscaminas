package martinezDiego;

public class Buscaminas {

    Tablero tablero = new Tablero();
    Jugador jugador = new Jugador();

    public void jugar() {

        while (!tablero.partidaTerminada()) {
            tablero.imprimirMapaVisible();
            jugador.jugarTurno(tablero);
        }

        tablero.imprimirMapaVisible();
        if (tablero.jugadorHaPerdido()) {
            System.out.println("Has pisado una mina");
        } else {
            System.out.println("Has ganado la partida");
        }
    }
}
