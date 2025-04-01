package gonzalezMarcos;

public class Tablero {

    private final int DIMENSION = 6; 
    private final int MINAS_INICIALES = 6; 
    private final char VACIA = '_';
    private final char MINA = 'M';
    private final char DESPEJADA = 'D';
    private char[][] casillas;

    public Tablero(){
        casillas = new char[DIMENSION][DIMENSION];
        generarTablero(casillas);
        ponerMinas(casillas,MINAS_INICIALES);

    }

    public void generarTablero(char[][] casillas)

    public void mostrar() {

        limpiar pantallas();
        System.out.println("    1 2 3");
        for (for i = 0; i < casillas.lenght; i++){
            System.out.print((i+1) + " ");
            for (j = 0; j < casillas[i].lenght; j++) {
                System.out.print(casillas[i][j] + " ");
            }
        }
        System.out.println();
    }

    private void PonerMinas(char[][])

    private static void main(Str)
}