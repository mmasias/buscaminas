public class Buscaminas {
    private static final int CANTIDAD_DE_MINAS = 6;
    private final int cantidadMinas;
    private final Coordenada[] posicionMinas;

    public Buscaminas(int cantidadMinas){
        this.cantidadMinas = cantidadMinas;
        posicionMinas = new Coordenada[cantidadMinas];
    }

    public Buscaminas(){
        this(CANTIDAD_DE_MINAS);
    }

    public void revisarEspacio(Coordenada coordenada, char[][] tablero, String accion){
        if (accion.equals("D")) {
            tablero[coordenada.coordenadaX()][coordenada.coordenadaY()] = 'D';
        } else if (accion.equals("M")) {
            tablero[coordenada.coordenadaX()][coordenada.coordenadaY()] = 'M';
        }   
    }

    public boolean finDePartida(char[][] tablero){
        for (Coordenada mina : posicionMinas) {
            if (tablero[mina.coordenadaX()][mina.coordenadaY()] == 'D') {
                return true;
            }
        }
        return false;
    }

    public void generarMinas(Tablero tablero){
        for(int i = 0; i < cantidadMinas; i++){
            int posicionX = (int)(Math.random() * tablero.dimension() + 1);
            int posicionY = (int)(Math.random() * tablero.dimension() + 1);
            posicionMinas[i] = new Coordenada(posicionX, posicionY);
        }
    }
}
