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

    public boolean tieneMina() {
        return tieneMina;
    }

    public void revelar() {
        this.casillaRevelada = true;
    }

    public boolean casillaRevelada() {
        return casillaRevelada;
    }

    public boolean casillaMarcada() {
        return casillaMarcada;
    }

}