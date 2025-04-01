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
    
    private void inicializarTablero() {
        
    }


    public void colocarMinas() {
        
    }
}
