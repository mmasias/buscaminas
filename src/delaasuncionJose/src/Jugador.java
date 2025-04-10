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
        Coordenada coordenada = new Coordenada(tablero.tamaño());
        coordenada.pedir();
        despejarCoordenada(tablero, coordenada);
    }
    
    private void despejarCoordenada(Tablero tablero, Coordenada coordenada) {
        final int DESPEJADO = 2;
        int casilla = tablero.sacarFicha(coordenada);

        if (casilla%3 == 1) {
            System.out.println("KABOOOM!");
            vivo = false;
        } else {
            tablero.ponerFicha(coordenada, DESPEJADO);
        }

        int minasAdyacentes = 0;
        int[] adyacentes = tablero.obtenerAdyacentes(coordenada);
        for (int adyacente : adyacentes) {
            if (adyacente%3 == 1) minasAdyacentes++;
        }

        if (minasAdyacentes == 0) {
            for (Coordenada nuevCoordenada : coordenada.adyacente()) {
                if (tablero.obtenerFicha(nuevCoordenada)%3 != 2) {
                    despejarCoordenada(tablero, nuevCoordenada);
                }
            }
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