package cotareloDaniel;

public class Tablero {
    private char[][] tableroMinas;
    private char[][] tableroVisible;
    private final int tamaño = 6;
    private final int cantidadMinas = 6;

    public Tablero() {
        tableroMinas = new char[tamaño][tamaño];
        tableroVisible = new char[tamaño][tamaño];
        inicializarTableros();
        colocarMinas();
    }

    private void inicializarTableros() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                tableroMinas[i][j] = '_';
                tableroVisible[i][j] = '_';
            }
        }
    }

    private void colocarMinas() {
        int minasColocadas = 0;
        while (minasColocadas < cantidadMinas) {
            int fila = (int) (Math.random() * tamaño);
            int columna = (int) (Math.random() * tamaño);
            if (tableroMinas[fila][columna] != 'M') {
                tableroMinas[fila][columna] = 'M';
                minasColocadas++;
            }
        }
    }

    public void mostrarTableroVisible() {
        System.out.println("BUSCAMINAS");
        System.out.print("  ");
        for (int i = 1; i <= tamaño; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < tamaño; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < tamaño; j++) {
                System.out.print(tableroVisible[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void mostrarTableroMinas() {
        System.out.println("BUSCAMINAS - MINAS");
        System.out.print("  ");
        for (int i = 1; i <= tamaño; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < tamaño; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < tamaño; j++) {
                System.out.print(tableroMinas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean hayMina(int fila, int columna) {
        return tableroMinas[fila][columna] == 'M';
    }

    public void marcar(int fila, int columna) {
        tableroVisible[fila][columna] = 'M';
    }

    public void despejar(int fila, int columna) {
        tableroVisible[fila][columna] = 'D';
    }

    public boolean verificarVictoria() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (tableroVisible[i][j] == '_' && tableroMinas[i][j] != 'M') {
                    return false;
                }
            }
        }
        return true;
    }

}
