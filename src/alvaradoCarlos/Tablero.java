public class Tablero {

    private char[][] tablero;
    private int dimensiones;
    private int minas;

    public static void main(String[] args) {
        Tablero tablero = new Tablero(6, 3);
        tablero.mostrarTablero();
    }

    public Tablero(int dimensiones, int minas) {
        this.dimensiones = dimensiones;
        this.minas = colocarMinas(dimensiones, minas);
        this.tablero = crearTablero(dimensiones);
    }

    public int dimensiones() {
        return dimensiones;
    }

    public int minas() {
        return minas;
    }

    public void mostrarTablero() {}
}
