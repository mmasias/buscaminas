package maderoCarla;

public class Tablero {

    private final int DIMENSION = 6;
    private final int MINAS_INICIALES = 6;
    private final char VACIA = '_';
    private final char MINA = 'M';
    private final char DESPEJADA = 'D';
    private char [][] casillas;
    private int [][] minas;

    public Tablero(){
        casillas = new char[DIMENSION][DIMENSION];
        generarTablero(casillas);
        ponerMinas(casillas, MINAS_INICIALES);
    }

}
