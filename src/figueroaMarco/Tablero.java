package figueroaMarco;

class Tablero {

    private static final int DIMENSION = 6;
    private char[][] casillas;


    public Tablero() {
        casillas = new char[DIMENSION][DIMENSION];
        generarTablero(casillas);
        ponerMinas(casillas, MINAS_INICIALES);
    }


}
