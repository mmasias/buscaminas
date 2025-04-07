class Tablero{
    private static final int DIMENSION = 6;
    private final char ESPACIO_EN_BALNCO = '_';
    private final int dimension;
    private char[][] tablero;

    public Tablero(int dimension){
        this.dimension = dimension;
        tablero = new char[this.dimension][this.dimension];

        for (int i = 0; i <= this.dimension; i++) {
            for (int j = 0; j <= this.dimension; j++) {
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

    public Coordenada obtenerEspacio(int posicionX, int posicionY){
        return new Coordenada(posicionX, posicionY);
    }

    public int dimension(){
        return dimension;
    }

    public int espacios(){
        return dimension * dimension;
    }

    public char[][] tablero() {
        return tablero;
    }

}