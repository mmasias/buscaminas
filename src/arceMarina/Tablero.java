package arceMarina;

import java.util.Random

public class Tablero {
    private final int N = 6, MINAS = 6;
    private Celda[][] celdas = new Celda[N][N];
    private boolean fin = false;

    public Tablero() {
        inicializarCeldas();
        colocarMinas();
        calcularNumeros();
    }

    private void inicializarCeldas() {
    
    }
}

