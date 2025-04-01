package castilloCayetano;

public class Tablero {
    
    private int[][] tablero;
    private int filas;
    private int columnas;
    private int minas;
    
    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.tablero = new int[filas][columnas];
        inicializarTablero();
    }

    public void mostrar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public void inicializarTablero() {
        
    }


    public void colocarMinas() {
        
    }

    public boolean despejado() {
        return true;
    }
}
