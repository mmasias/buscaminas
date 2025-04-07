public class Jugador {
    private boolean vivo;
    private static final int DESPEJADO = 2;
    private static final int MARCADO = 3;
    private static final int MINA = 1;

    public Jugador() {
        this.vivo = true;
    }

    public void juega(Mapa mapa) {
        Pedir pedir = new Pedir();
        System.out.println("¿D = Despejar o M = Marcar mina?");
        char caracter;

        do {
            caracter = Character.toUpperCase(pedir.pedirCaracter());
        } while (!(caracter == 'D' || caracter == 'M'));

        if (caracter == 'D') {
            despejar(mapa);
        } else {
            marcar(mapa);
        }
    }

    private void despejar(Mapa mapa) {
        Coordenada coordenada = new Coordenada();
        coordenada.pedir();

        int valor = mapa.quitarFicha(coordenada);

        if (valor == MINA) {
            System.out.println("¡KABOOM!");
            vivo = false;
        } else {
            mapa.colocarFicha(coordenada, DESPEJADO);
        }
    }

    private void marcar(Mapa mapa) {
        Coordenada coordenada = new Coordenada();
        coordenada.pedir();

        int valor = mapa.quitarFicha(coordenada);
        mapa.colocarFicha(coordenada, valor + MARCADO);
    }

    public boolean vivo() {
        return vivo;
    }
}
