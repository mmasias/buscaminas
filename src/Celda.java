public class Celda {

    private boolean tieneMina;
    private boolean casillaRevelada;
    private boolean casillaMarcada;
    private int minasCercanas;

    public Celda() {
        tieneMina = false;
        casillaRevelada = false;
        casillaMarcada = false;
        minasCercanas = 0;
    }

    public void ponerMina() {
        this.tieneMina = true;
}

}