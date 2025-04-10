package morenoSara;

class Jugador {

    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void celebrar() {
        System.out.println(nombre + " ¡Ha ganado el juego!");
    }
}
