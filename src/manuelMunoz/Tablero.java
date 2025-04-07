class Tablero{
    private static final int DIMENSION = 6;
    private final char ESPACIO_EN_BALNCO = '_';
    private char[][] tablero;

    public Tablero(int dimension){
        tablero = new char[dimension][dimension];

        for (int i = 0; i <= dimension; i++) {
            for (int j = 0; j <= dimension; j++) {
                tablero[i][j] = ESPACIO_EN_BALNCO;
            }
        }
    }

    public Tablero(){
        this(DIMENSION);
    }

    public void mostrarTablero(){
        for (char[] fila : tablero) {
            for (char columna : fila) {
                System.out.println(columna);
            }
        }
    }

    public void revisarEspacio(Coordenada coordenada, String accion){
        if (accion.equals('D')) {
            tablero[coordenada.CoordenadaX()][coordenada.CoordenadaY()] = 'D';
        } else if (accion.equals('M')) {
            tablero[coordenada.CoordenadaX()][coordenada.CoordenadaY()] = 'M';
        }   
    }

    public Coordenada obtenerEspacio(int posicionX, int posicionY){
        return new Coordenada(posicionX, posicionY);
    }

}