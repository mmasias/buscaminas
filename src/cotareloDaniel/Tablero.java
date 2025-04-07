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
}
