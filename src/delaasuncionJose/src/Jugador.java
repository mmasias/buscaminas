package delaasuncionJose.src;

public class Jugador {
    private boolean vivo;

    public Jugador(){
        this.vivo = true;
    } 

    public void juega(Tablero tablero) {
        Pedir pedir = new Pedir();
        System.out.println("[D]espejar o [M]arcar mina?");
        char caracter;

        do {
            caracter = pedir.character();
        } while (!(caracter == 'D' || caracter == 'M'));

        switch (caracter) {
            case 'D':
                despejar(tablero);
                break;
            case 'M':
                marcar(tablero);
                break;
        }
    }

    private void despejar(Tablero tablero) {
        final int DESPEJADO = 2;
        Coordenada coordenada = new Coordenada(tablero.tamaño());
        coordenada.pedir();

        int casilla = tablero.sacarFicha(coordenada);

        if (casilla%3 == 1) {
            System.out.println("KABOOOM!");
            vivo = false;
        } else {
            tablero.ponerFicha(coordenada, DESPEJADO);
        }
    }

    private void marcar(Tablero tablero) {
        final int MARCADO = 3;
        Coordenada coordenada = new Coordenada(tablero.tamaño());
        coordenada.pedir();

        tablero.ponerFicha(coordenada, tablero.sacarFicha(coordenada) + MARCADO);
    }

    public boolean vivo() {
        return vivo;
    }
}