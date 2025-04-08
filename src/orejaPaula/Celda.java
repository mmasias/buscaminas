package orejaPaula;

public class Celda {
    boolean esMina;
    boolean estaRevelada;
    int minasAdyacentes;

    public Celda() {
        this.esMina = false;
        this.estaRevelada = false;
        this.minasAdyacentes = 0;
    }
}
