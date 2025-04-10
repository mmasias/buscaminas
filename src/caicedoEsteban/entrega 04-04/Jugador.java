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
        System.out.println("¿D = Despejar, M = Marcar mina o X = Macrodespejar?");
        char caracter;

        do {
            caracter = Character.toUpperCase(pedir.pedirCaracter());
        } while (!(caracter == 'D' || caracter == 'M' || caracter == 'X'));

        if (caracter == 'D') {
            despejar(mapa);
        } else if (caracter == 'M') {
            marcar(mapa);
        } else {
            macrodespejar(mapa);
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

    private void macrodespejar(Mapa mapa) {
        Coordenada coordenada = new Coordenada();
        coordenada.pedir();

        boolean exploto = mapa.ejecutarMacrodespeje(coordenada);

        if (exploto) {
            System.out.println("¡KABOOM en macrodespeje!");
            vivo = false;
        }
    }

    public boolean vivo() {
        return vivo;
    }
}
