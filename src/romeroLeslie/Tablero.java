import java.util.Random;

public class Tablero {
    private static final int TAM = 6;
    private static final int MINAS = 6;
    private Casilla[][] casillas = new Casilla[TAM][TAM];

    public Tablero() {
        inicializarTablero();
        colocarMinas();
    }

    private void inicializarTablero() {
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                casillas[f][c] = new Casilla();
            }
        }
    }

    private void colocarMinas() {
        Random r = new Random();
        int minasColocadas = 0;

        while (minasColocadas < MINAS) {
            int f = r.nextInt(TAM);
            int c = r.nextInt(TAM);
            if (!casillas[f][c].tieneMina()) {
                casillas[f][c].ponerMina();
                actualizarNumerosVecinos(f, c);
                minasColocadas++;
            }
        }
    }

    private void actualizarNumerosVecinos(int f, int c) {
        for (int df = -1; df <= 1; df++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nf = f + df;
                int nc = c + dc;
                if (enRango(nf, nc)) {
                    casillas[nf][nc].incrementarMinasCerca();
                }
            }
        }
    }

    public void imprimirVisible() {
        System.out.println("  1 2 3 4 5 6");
        for (int f = 0; f < TAM; f++) {
            System.out.print((f + 1) + " ");
            for (int c = 0; c < TAM; c++) {
                System.out.print(casillas[f][c].getVisible() + " ");
            }
            System.out.println();
        }
    }

    public boolean despejar(int f, int c) {
        if (!enRango(f, c)) return false;
        Casilla casilla = casillas[f][c];

        if (casilla.estaDescubierta() || casilla.estaMarcada()) return true;

        casilla.descubrir();

        if (casilla.tieneMina()) {
            return false;
        }

        if (casilla.getMinasCerca() == 0) {
            for (int df = -1; df <= 1; df++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (df != 0 || dc != 0) {
                        despejar(f + df, c + dc);
                    }
                }
            }
        }

        return true;
    }

    public void marcar(int f, int c) {
        if (enRango(f, c)) {
            casillas[f][c].marcar();
        }
    }

    public void descubrirTodo() {
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                casillas[f][c].revelar();
            }
        }
    }

    public boolean verificarVictoria() {
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                Casilla casilla = casillas[f][c];
                if (!casilla.tieneMina() && !casilla.estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean tieneMina(int f, int c) {
        return enRango(f, c) && casillas[f][c].tieneMina();
    }

    private boolean enRango(int f, int c) {
        return f >= 0 && f < TAM && c >= 0 && c < TAM;
    }
}

