public class Buscaminas {

    private Mapa mapa;
    private Jugador jugador;
    private final char[] fichas = { '_', 'D', 'M', '.', 'X' };
    private final int TAMANIO = 6;
    private final int MINAS = 6;

    public Buscaminas() {
        int[][] mapaInicial = crearMapaMinas(MINAS, TAMANIO);
        mapa = new Mapa(mapaInicial, fichas);
        jugador = new Jugador();
    }

    public void jugar() {
        do {
            mapa.mostrarTablero();
            jugador.juega(mapa);
        } while (!mapa.estaDespejado() && jugador.vivo());

        mapa.mostrarTablero();

        if (jugador.vivo()) {
            System.out.println("¡Felicidades! Has ganado.");
        } else {
            System.out.println("¡Boom! Has perdido.");
        }
    }

    private int[][] crearMapaMinas(int numeroMinas, int tamaño) {
        int[][] mapa = new int[tamaño][tamaño];

        for (int i = 0; i < numeroMinas; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * tamaño);
                y = (int) (Math.random() * tamaño);
            } while (mapa[y][x] == 1);
            mapa[y][x] = 1;
        }

        return mapa;
    }
}
