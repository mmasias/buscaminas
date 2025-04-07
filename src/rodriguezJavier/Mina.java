import java.util.Random;

public class Mina {
    private boolean[][] minas;
    private int cantidad;
    
    public Mina(int tamano, int cantidad) {
        this.minas = new boolean[tamano][tamano];
        this.cantidad = cantidad;
        colocarMinas();
    }
    
    private void colocarMinas() {
        Random rand = new Random();
        int colocadas = 0;
        
        while (colocadas < cantidad) {
            int fila = rand.nextInt(minas.length);
            int columna = rand.nextInt(minas[0].length);
            
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                colocadas++;
            }
        }
    }
    
    public boolean hayMina(int fila, int columna) {
        return minas[fila][columna];
    }
    
    public int contarMinasAlrededor(int fila, int columna) {
        int contador = 0;
        for (int i = Math.max(0, fila-1); i <= Math.min(minas.length-1, fila+1); i++) {
            for (int j = Math.max(0, columna-1); j <= Math.min(minas[0].length-1, columna+1); j++) {
                if (i == fila && j == columna) continue;
                if (minas[i][j]) contador++;
            }
        }
        return contador;
    }
}