public class Mapa {
    private int[][] mapa;
    private char[] fichas;

    private final int VACIO = 0;

    public Mapa(int[][] mapa, char[] fichas) {
        this.mapa = mapa;
        this.fichas = fichas;
    }

    public int[] obtenerTamaño() {
        return new int[] { mapa[0].length, mapa.length };
    }

    public void mostrarTablero() {
        System.out.println("\nTablero:");
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(convertirFicha(mapa[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private char convertirFicha(int ficha) {
        return (ficha <= VACIO) ? '_' : fichas[ficha - 1];
    }

    public void colocarFicha(Coordenada coordenada, int ficha) {
        mapa[coordenada.getY()][coordenada.getX()] = ficha;
    }

    public int quitarFicha(Coordenada coordenada) {
        int fichaSacada = mapa[coordenada.getY()][coordenada.getX()];
        mapa[coordenada.getY()][coordenada.getX()] = VACIO;
        return fichaSacada;
    }

    public boolean estaDespejado() {
        for (int i = 0; i < mapa.length; i++) {
            for (int num : mapa[i]) {
                if (num == 0 || num == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
