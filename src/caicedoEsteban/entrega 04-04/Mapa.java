package caicedoEsteban.entrega 04-04;

public class Mapa {
    private Mina[][] campo;
    private int filas, columnas;

    public Mapa(int filas, int columnas, int numMinas) {
        this.filas = filas;
        this.columnas = columnas;
        campo = new Mina[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                campo[i][j] = new Mina();
            }
        }
        colocarMinas(numMinas);
        calcularMinasAdyacentes();
    }

    private void colocarMinas(int numMinas) {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < numMinas) {
            int x = rand.nextInt(filas);
            int y = rand.nextInt(columnas);
            if (!campo[x][y].esMina()) {
                campo[x][y].colocarMina();
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAdyacentes() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!campo[i][j].esMina()) {
                    int contador = 0;
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int nx = i + dx;
                            int ny = j + dy;
                            if (nx >= 0 && ny >= 0 && nx < filas && ny < columnas && campo[nx][ny].esMina()) {
                                contador++;
                            }
                        }
                    }
                    campo[i][j].incrementarMinasAdyacentes();
                }
            }
        }
    }

    public void mostrarMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (campo[i][j].esDescubierta()) {
                    if (campo[i][j].esMina()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(campo[i][j].getMinasAdyacentes() + " ");
                    }
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public boolean descubrirCasilla(Coordenada coord) {
        if (coord.x >= 0 && coord.x < filas && coord.y >= 0 && coord.y < columnas) {
            Mina mina = campo[coord.x][coord.y];
            mina.descubrir();
            return mina.esMina();
        }
        return false;
    }

    public boolean esMapaDescubierto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!campo[i][j].esDescubierta() && !campo[i][j].esMina()) {
                    return false;
                }
            }
        }
        return true;
    }
}
