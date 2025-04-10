package alvaradoCarlos;

public class Juego {

    public static void main(String[] args) {
        int[] dimensiones = {7, 7};
        Buscaminas buscaminas = new Buscaminas(dimensiones, 20);
        buscaminas.jugar();
    }
}
