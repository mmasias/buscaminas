class Tablero {
    private final int tamano;
    private final char[][] celdas;
    private static final char VACIO = '_';
    private static final char DESPEJADO = 'D';
    private static final char MARCADO = 'M';

    public Tablero(int tamano) {
        this.tamano = tamano;
        this.celdas = new char [tamano][tamano];
        inicializarTablero();
    }
        
    private void inicializarTablero() {
        for (int i = 0; i < tamano ; i++) {
            for(int j = 0 ;  j < tamano; j++){
                celdas[i][j] = VACIO;
            }
        }
    }
        
    public void imprimirTablero() {
        for(int i = 1; i<=tamano; i++){
            System.out.println(i + " ");
        }
        System.out.println();
        for (int i = 0; i < tamano ; i++) {
            System.out.println((i+1) + " ");
            for(int j = 0 ;  j < tamano; j++){
                System.out.print(celdas[i][j] + "");
            }
            System.out.println();
        }
    }

    public boolean esCoordenadaValida(Coordenada coord) {
        return coord.getFila()
    }

    
}
