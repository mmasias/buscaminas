public class Casilla {

    private boolean tieneMina;
    private int minasAdyacentes;
    private boolean descubierta;
    private boolean marcada;

    public Casilla() {
        this.tieneMina = false;
        this.minasAdyacentes = 0;
        this.descubierta = false;
        this.marcada = false;
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public void ponerMina() {
        this.tieneMina = true;
    }

    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }

    public void setMinasAdyacentes(int minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public void descubrir() {
        this.descubierta = true;
    }

    public boolean estaMarcada() {
        return marcada;
    }

    public void marcar() {
        this.marcada = !this.marcada;
    }
}
