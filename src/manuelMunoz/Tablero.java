package manuelMunoz;
class Tablero{
    private static final int DIMENSION = 6;
    private final String ESPACIO_EN_BALNCO = "_";
    private final int dimension;
    private String[][] tablero;

    public Tablero(int dimension){
        this.dimension = dimension;
        tablero = new String[this.dimension][this.dimension];

        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                tablero[i][j] = ESPACIO_EN_BALNCO;
            }
        }
    }

    public Tablero(){
        this(DIMENSION);
    }

    public void mostrarTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println();
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

    public String[][] tablero() {
        return tablero;
    }

}