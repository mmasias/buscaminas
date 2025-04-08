package lianoJavier;

public class Tablero {

        int[] dimensiones;
        int[][] matrizBombas;
        int[][] matrizMarcas;
        int[][] matrizDescubiertos;

        final private String DESCUBIERTO = " o ";
        final private String OCULTAS = " X ";
        final private String MARCADA = " P ";
        final private String BOMBA = " * ";

        public Tablero(int[] dimensiones) {
                this.dimensiones = dimensiones;
                matrizBombas = crearMatriz(dimensiones);
                matrizMarcas = crearMatriz(dimensiones);
                matrizDescubiertos = crearMatriz(dimensiones);
                sembrarBombas(matrizBombas);
        }

        private void sembrarBombas(int[][] matriz) {
                int minasPorColocar = 5;
                while (minasPorColocar > 0) {
                        int fila = (int) (Math.random() * matriz.length);
                        int columna = (int) (Math.random() * matriz[0].length);
                        if (matriz[fila][columna] == -1) {
                                matriz[fila][columna] = 1;
                                minasPorColocar--;
                        }
                }
        }

        private int[][] crearMatriz(int[] dimension) {
                int[][] matriz = new int[dimension[0]][dimension[1]];
                for (int fila = 0; fila < matriz.length; fila++) {
                        for (int columna = 0; columna < matriz[fila].length; columna++) {
                                matriz[fila][columna] = -1;
                        }
                }
                return matriz;
        }

        public boolean gana() {
                return !pierde() && estaCompleto();
        }

        private boolean estaCompleto() {
                for (int fila = 0; fila < this.dimensiones[0]; fila++) {
                        for (int columna = 0; columna < this.dimensiones[1]; columna++) {
                                if (matrizBombas[fila][columna] == -1 && matrizDescubiertos[fila][columna] == -1)
                                        return false;
                        }
                }
                return true;
        }

        public boolean pierde() {
                for (int fila = 0; fila < this.dimensiones[0]; fila++) {
                        for (int columna = 0; columna < this.dimensiones[1]; columna++) {
                                if (matrizBombas[fila][columna] == 1 && matrizDescubiertos[fila][columna] == 1)
                                        return true;
                        }
                }
                return false;
        }

        public void marcarCasilla(Coordenada coordenada) {
                matrizMarcas[coordenada.getFila()][coordenada.getColumna()] *= -1;
        }

        public int[] getDimensiones() {
                return dimensiones;
        }

        public void despejarCasilla(Coordenada coordenada) {
                matrizDescubiertos[coordenada.getFila()][coordenada.getColumna()] = 1;
        }

        public void mostar() {
                for (int fila = 0; fila < dimensiones[0]; fila++) {
                        for (int columna = 0; columna < dimensiones[1]; columna++) {
                                if (matrizDescubiertos[fila][columna] == 1) {
                                        System.out.print(matrizBombas[fila][columna] == 1 ? BOMBA : DESCUBIERTO);
                                } else if (matrizMarcas[fila][columna] == 1) {
                                        System.out.print(MARCADA);
                                } else {
                                        System.out.print(OCULTAS);
                                }
                        }
                        System.out.println();
                }
        }

        public void mostrarBombas() {
                for (int fila = 0; fila < dimensiones[0]; fila++) {
                        for (int columna = 0; columna < dimensiones[1]; columna++) {
                                System.out.print(matrizBombas[fila][columna] == 1 ? BOMBA : DESCUBIERTO);
                        }
                        System.out.println();
                }
        }
}
