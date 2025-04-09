package alvaradoCarlos;

public class Juego {

    public static void main(String[] args) {
        int[] dimensiones = {6, 6};
        Buscaminas buscaminas = new Buscaminas(dimensiones, 12);
        buscaminas.jugar();
    }
}
