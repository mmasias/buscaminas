package delaasuncionJose.src;

public class Tablero {
    private int[][] tabla;
    private char[] fichas;

    private final int VACIO = 0;

    public Tablero(int[][] tabla, char[] fichas) {
        this.tabla = tabla;
        this.fichas = fichas;
    }

    public int[] tamaño() {
        return new int[] {tabla[0].length, tabla.length};
    }

    public void mostrar() {
        for (int i = 0;i<tabla.length;i++) {
            for (int j = 0; j<tabla[i].length;j++) {
                System.out.print(parse(tabla[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private char parse(int ficha) {
        return (ficha <= VACIO) ? '_' : fichas[ficha-1];
    }

    public void ponerFicha(Coordenada coordenada, int ficha) {
        tabla[coordenada.y()][coordenada.x()] = ficha;
    }

    public int sacarFicha(Coordenada coordenada) {
        int fichaSacada = obtenerFicha(coordenada);
        tabla[coordenada.y()][coordenada.x()] = VACIO;
        return fichaSacada;
    }

    public int obtenerFicha (Coordenada coordenada) {
        return tabla[coordenada.y()][coordenada.x()];
    }

    public boolean despejado() {
        for (int i = 0; i < tabla.length; i++) {
            for (int num : tabla[i]) {
                if (num <= 1 || num%3 == 0) return false;
            }
        }
        return true;
    }

    public int[] obtenerAdyacentes(Coordenada coordenada) {
        Coordenada[] coordenadas = coordenada.adyacente();
        int[] adyacentes = new int[coordenadas.length];
        for (int i = 0; i < adyacentes.length; i++) {
            adyacentes[i] = obtenerFicha(coordenadas[i]);
        }
        return adyacentes;
    }
}