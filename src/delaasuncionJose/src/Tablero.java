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
            for (int j = 0; j<tabla.length;j++) {
                System.out.print(parse(tabla[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private char parse(int ficha) {
        return (ficha <= VACIO) ? '_' : fichas[ficha-1];
    }

    public boolean estaOcupado(Coordenada coordenada) {
        return tabla[coordenada.y()][coordenada.x()] != VACIO;
    }

    public void ponerFicha(Coordenada coordenada, int ficha) {
        tabla[coordenada.y()][coordenada.x()] = ficha;
    }

    public int sacarFicha(Coordenada coordenada) {
        int fichaSacada = tabla[coordenada.y()][coordenada.x()];
        tabla[coordenada.y()][coordenada.x()] = VACIO;
        return fichaSacada;
    }

    public boolean despejado() {
        for (int i = 0; i < tabla.length; i++) {
            for (int num : tabla[i]) {
                if (num <= VACIO) return false;
            }
        }
        return true;
    }
}