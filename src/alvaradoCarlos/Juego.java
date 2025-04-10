package alvaradoCarlos;

public class Juego {

    public static void main(String[] args) {
        int[] dimensiones = {4, 3};
        Buscaminas buscaminas = new Buscaminas(dimensiones, 8);
        buscaminas.jugar();
    }
}
