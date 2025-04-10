public class Mapa {
    private int[][] mapa;
    private char[] fichas;

    private final int VACIO = 0;

    public boolean ejecutarMacrodespeje(Coordenada centro) {
        int[][] direcciones = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        boolean exploto = false;

        for (int[] dir : direcciones) {
            int nuevaCoordenadaY = centro.getY() + dir[0];
            int nuevaCoordenadaX = centro.getX() + dir[1];

            if (nuevaCoordenadaY >= 0 && nuevaCoordenadaY < mapa.length && nuevaCoordenadaX >= 0
                    && nuevaCoordenadaX < mapa[0].length) {
                int fichaActual = mapa[nuevaCoordenadaY][nuevaCoordenadaX];

                if (fichaActual == 4)
                    continue;

                if (fichaActual == 1) {
                    exploto = true;
                    mapa[nuevaCoordenadaY][nuevaCoordenadaX] = 0;
                } else if (fichaActual == 0) {
                    mapa[nuevaCoordenadaY][nuevaCoordenadaX] = 2;
                }
            }
        }

        return exploto;
    }

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
