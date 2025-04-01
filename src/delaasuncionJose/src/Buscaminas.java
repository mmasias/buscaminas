package delaasuncionJose.src;

public class Buscaminas {
    private Tablero tablero;
    private Jugador jugador;
    private char[] fichas = { 'D', 'M'};
    private final int MINA = -1;

    public Buscaminas() {
        tablero = new Tablero(crearTableroMinas(6,6), fichas);
        jugador = new Jugador();
    }

    public void jugar() {
        do {
            tablero.mostrar();
            jugador.juega(tablero);
        } while (!tablero.despejado() && jugador.vivo());
    }

    private int[][] crearTableroMinas(int numeroMinas, int tamaño) {
        int[][] tablero = new int[tamaño][tamaño];
        for (int i = 0; i < numeroMinas; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * tablero.length);
                y = (int) (Math.random() * tablero.length);
            } while (tablero[y][x] == MINA);
            tablero[y][x] = -1;
        }
        return tablero;
    }
}