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
        for (int j = 0;j<tabla.length;j++) {
            for (int i = 0; i<tabla[j].length;i++) {
                if (tabla[j][i] % 3 == 2) {
                    System.out.print(minasAdyacentes(new Coordenada(tamaño(),i+1,tabla.length-j))+ " ");
                } else {
                    System.out.print(parse(tabla[j][i]) + " ");
                }
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
        return coordenada == null ? 0 : tabla[coordenada.y()][coordenada.x()];
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

    public int minasAdyacentes(Coordenada coordenada) {
        int minasAdyacentes = 0;
        for (int adyacente : obtenerAdyacentes(coordenada)) {
            if (adyacente%3 == 1) minasAdyacentes++;
        }
        return minasAdyacentes;
    }
}